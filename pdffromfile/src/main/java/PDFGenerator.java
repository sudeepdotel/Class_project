import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.*;

public class PDFGenerator {

    public static String fileName1 = "/Users/sudeep-macmini/IdeaProjects/root/pdffromfile/src/main/resources/data.txt";
    public static String fileName2 = "/Users/sudeep-macmini/IdeaProjects/root/pdffromfile/src/main/resources/data.pdf";

    public static void main(String[] args) {
        // Write data to a file
        writeDataToFile(fileName1, "Hello, this is some data!");

        // Read data from the file
        String data = readDataFromFile(fileName1);
        System.out.println("Read data from file: " + data);

        // Generate a PDF file
        generatePDF(fileName2, data);
        System.out.println("PDF generated successfully!");
    }

    private static void writeDataToFile(String fileName, String data) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readDataFromFile(String fileName) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    private static void generatePDF(String fileName, String content) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.newLineAtOffset(20, 700);
                PDType0Font font = PDType0Font.load(document, new File(fileName2));
                contentStream.setFont(font, 12);
                contentStream.showText(content);
                contentStream.endText();
            }

            document.save(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
