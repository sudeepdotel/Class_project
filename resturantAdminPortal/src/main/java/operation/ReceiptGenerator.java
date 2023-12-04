package operation;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class ReceiptGenerator {
    public static String fileName = "/Users/sudeep-macmini/IdeaProjects/root/resturantAdminPortal/src/main/resources/orders.txt";
    public static void generateReceipt() {

        String[] header = {"Order ID", "Item", "Unit Price", "Quantity", "Total", "Order Date"};

        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            float margin = 50;
            float yStart = page.getMediaBox().getHeight() - margin;
            float tableWidth = page.getMediaBox().getWidth() - 2 * margin;

            ReceiptGenerator.addHeader(contentStream, header, margin, yStart, tableWidth);
            ReceiptGenerator.addContent(contentStream, fileName, margin, yStart - 20, tableWidth);

            contentStream.close();

            document.save("/Users/sudeep-macmini/IdeaProjects/root/resturantAdminPortal/src/main/resources/receipt.pdf");
            document.close();

            System.out.println("Receipt generated successfully.");

        } catch (Exception e) {
            System.err.println("Error Message :: " + e.getMessage());
        }
    }

    public static void addHeader(PDPageContentStream contentStream, String[] header, float margin, float yStart, float tableWidth) throws IOException {
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yStart);
        for (String headerTitle : header) {
            contentStream.showText(headerTitle);
            contentStream.newLineAtOffset(tableWidth / header.length, 0);
        }
        contentStream.endText();

        float yPosition = yStart - 20;
        contentStream.setLineWidth(1f);
        contentStream.moveTo(margin, yPosition);
        contentStream.lineTo(margin + tableWidth, yPosition);
        contentStream.stroke();
    }


    public static void addContent(PDPageContentStream contentStream, String fileName, float margin, float yStart, float tableWidth) throws IOException {
        float tableHeight = 20f;
        float rowHeight = 15f;
        float tableMargin = 15f;

        contentStream.setFont(PDType1Font.HELVETICA, 12);

        for (String line : Files.readAllLines(Paths.get(fileName))) {
            String[] values = line.split("\\s+");
            yStart -= rowHeight;

            contentStream.beginText();
            contentStream.newLineAtOffset(margin, yStart);
            for (String value : values) {
                contentStream.showText(value);
                contentStream.newLineAtOffset(tableWidth / values.length, 0);
            }
            contentStream.endText();

            contentStream.setLineWidth(1f);
            contentStream.moveTo(margin, yStart - tableMargin);
            contentStream.lineTo(margin + tableWidth, yStart - tableMargin);
            contentStream.stroke();
        }
    }




}
