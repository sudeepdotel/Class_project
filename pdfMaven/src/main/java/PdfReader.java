import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDType0Font;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.IOException;

public class PdfReader {

    public static void main(String[] args) {
        try {
            // Create a new document
            PDDocument document = new PDDocument();

            // Add a page to the document
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            // Create a content stream for writing to the page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Use a TrueType font (DejaVuSans) with size 12
            PDType0Font font = PDType0Font.load(document, new File("/Users/sudeep-macmini/IdeaProjects/pdfMaven/src/main/resources/test1.pdf")); // Replace with the path to your font file

            // Set font and font size
            contentStream.setFont(font, 12);

            // Begin text formatting
            contentStream.beginText();

            // Set text position on the page (x, y)
            contentStream.newLineAtOffset(100, 700);

            // Write text to the page
            contentStream.showText("Hello, PDFBox with DejaVuSans!");

            // End text formatting
            contentStream.endText();

            // Close the content stream
            contentStream.close();

            // Save the document to a file
            document.save("output.pdf");

            // Close the document
            document.close();

            System.out.println("PDF created successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
