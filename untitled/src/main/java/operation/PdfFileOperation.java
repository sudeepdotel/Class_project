package operation;

import model.Employee;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PdfFileOperation {

    public static List<PDDocument> welcomeLetterPdfGenerator(Employee employee, String path, int n) {
        List<PDDocument> pdfDocuments = new ArrayList<>();

        try {
            for (int i = 0; i < n; i++) {
                if (employee.status.equalsIgnoreCase("new")) {
                    File file = new File(path);

                    // create new pdf file
                    PDDocument pdDocument = new PDDocument();
                    PDPage pdPage = new PDPage();
                    pdDocument.addPage(pdPage);

                    // create PDPageContentStream
                    PDPageContentStream pdPageContentStream = new PDPageContentStream(pdDocument, pdPage);
                    pdPageContentStream.setFont(PDType1Font.HELVETICA, 12);

                    // Add content to the PDF
                    String content = "Hi " + employee.getName() +
                            " We are delighted to inform you that you have been selected for the job." +
                            " We request you to accept the agreement and send us confirmation of the joining." +
                            " Thanks, HR Team.";

                    pdPageContentStream.beginText();
                    pdPageContentStream.newLineAtOffset(20, 700);
                    pdPageContentStream.showText(content);
                    pdPageContentStream.endText();
                    pdPageContentStream.close();

                    pdDocument.save(file);
                    pdfDocuments.add(pdDocument);

                    System.out.println("Agreement PDF generated for employee: " + employee.getEmpId());
                } else {
                    System.out.println("No agreement PDF generated for employee ID " + employee.getEmpId() + " as the status is not 'New'.");
                }
            }

        } catch (Exception e) {
            System.err.println("Error message : " + e.getMessage());
        }

        return pdfDocuments;
    }
}
