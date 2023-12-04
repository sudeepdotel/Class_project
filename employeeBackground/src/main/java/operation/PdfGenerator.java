

package operation;

import model.Employee;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;


    public class PdfGenerator {
        public static String pdfFilePath = "/Users/sudeep-macmini/IdeaProjects/root/employeeBackground/src/main/resources/agreement.pdf";
        public static void generateAndSaveAgreementPDF(Employee employee) {
            try {
                if ("new".equalsIgnoreCase(employee.getStatus())) {
                    // Create a new PDF document
                    PDDocument document = new PDDocument();
                    PDPage page = new PDPage();
                    document.addPage(page);

                    // Create content stream
                    PDPageContentStream contentStream = new PDPageContentStream(document, page);
                    contentStream.beginText();

                    // Set font and font size
                    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

                    // Add content to the PDF
                    String content = "Hi " + employee.getEmpName() + ",\n\n" +
                            "We are delighted to inform you that you have been selected for the job. We will " +
                            "send further communication to the following address:\n" +
                            employee.getEmpAddress() + "\n\n" +
                            "We request you to accept the agreement and send us confirmation of the joining.\n\n" +
                            "Thanks,\nHR Team.";

                    // Set text position
                    contentStream.newLineAtOffset(20, 700);

                    // Add content to the PDF
                    contentStream.showText(content);

                    // End text and close content stream
                    contentStream.endText();
                    contentStream.close();

                    // Save the document

                    document.save(pdfFilePath);
                    document.close();

                    System.out.println("Agreement PDF generated and saved successfully for employee ID " + employee.getEmpId());
                } else {
                    System.out.println("No agreement PDF generated for employee ID " + employee.getEmpId() + " as the status is not 'New'.");
                }
            } catch (IOException e) {
                System.err.println("Error generating the PDF: " + e.getMessage());
            }
        }
    }


