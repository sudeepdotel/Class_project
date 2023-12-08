package service;

import model.Invoice;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import org.apache.pdfbox.pdmodel.font.PDType1Font;


import java.awt.*;

import java.io.IOException;

public class PdfTemplate {

    public static void generateInvoicePDF(Invoice invoice, String outputPath) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

            float margin = 50;
            float yStart = page.getMediaBox().getHeight() - margin;

            // Sample header content variables
            String headerContent4 = "Weekytrips Tour Planner";
            String headerContent5 = "207 Webel IT Park, City Center, Haldia, Debhog, Haldia, West Bengal, 721631";
            String headerContent6 = "Mobile: 9174100111";
            String headerContent7 = "Email: support@weekytrips.com";

            // Display each line of the header content
            displayHeaderContent(contentStream, headerContent4, margin, yStart - 60);
            displayHeaderContent(contentStream, headerContent5, margin, yStart - 80);
            displayHeaderContent(contentStream, headerContent6, margin, yStart - 100);
            displayHeaderContent(contentStream, headerContent7, margin, yStart - 120);

            // Add bold red line to separate header and body
            addSeparatorLine(contentStream, margin, yStart - 130,page);

            // Sample template for the body (replace with actual values)
            displayBodyContent(contentStream, margin, yStart - 150,invoice);

            contentStream.close();

            // Save the document
            document.save(outputPath);
            document.close();

            System.out.println("Invoice PDF generated successfully.");

        } catch (Exception e) {
            System.err.println("Error Message : " + e.getMessage());
        }
    }

    private static void displayHeaderContent(PDPageContentStream contentStream, String content, float margin, float yPosition) throws IOException {
        contentStream.beginText();
        // Applying different font styles and sizes based on the line content
        if (content.equals("Weekytrips Tour Planner")) {
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
        } else if (content.contains("Mobile:") || content.contains("Email:")) {
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10);
        } else {
            contentStream.setFont(PDType1Font.HELVETICA, 10);
        }

        contentStream.newLineAtOffset(margin, yPosition);
        contentStream.showText(content);
        contentStream.endText();
    }

    private static void addSeparatorLine(PDPageContentStream contentStream, float margin, float yPosition, PDPage page) throws IOException {
        // Set the line color to red
        contentStream.setStrokingColor(Color.RED);
        contentStream.setLineWidth(2f);

        // Draw a bold red line
        contentStream.moveTo(margin, yPosition);
        contentStream.lineTo(page.getMediaBox().getWidth() - margin, yPosition);
        contentStream.stroke();

        // Reset color and line width
        contentStream.setStrokingColor(Color.BLACK);
        contentStream.setLineWidth(1f);
    }

    private static void displayBodyContent(PDPageContentStream contentStream, float margin, float yPosition, Invoice inv) throws IOException {


        // Sample template for the body content (replace with actual values)
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.newLineAtOffset(margin, yPosition);
        contentStream.showText("Invoice No: " + inv.getInvoiceNumber());

        contentStream.newLineAtOffset(185, 0);
        contentStream.showText("Invoice Date: " + inv.getInvoiceDate());

        contentStream.newLineAtOffset(205, 0);
        contentStream.showText("Due Date: " + inv.getDueDate());

        // Bill To
        contentStream.newLineAtOffset(0, -12);
        contentStream.showText("Bill To: " + "billTo");

        // Firstname LastName
        contentStream.newLineAtOffset(0, -12);
        contentStream.showText("Firstname LastName: " + "firstNameLastName");

        // Address
        contentStream.newLineAtOffset(0, -12);
        contentStream.showText("Address: " + "address");

        // Mobile
        contentStream.newLineAtOffset(0, -12);
        contentStream.showText("Mobile: " + "mobile");

        // State
        contentStream.newLineAtOffset(0, -12);
        contentStream.showText("State: " + "state");

        contentStream.endText();
    }
}
