package service;

import model.Invoice;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


import java.awt.*;

import java.io.File;
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
            System.out.println(yStart);

            // Sample header content variables
            String headerContent4 = "Weekytrips Tour Planner";
            String headerContent5 = "207 Webel IT Park, City Center, Haldia, Debhog, Haldia, West Bengal, 721631";
            String headerContent6 = "Mobile: 9174100111";
            String headerContent7 = "Email: support@weekytrips.com";

            //Load the logo to the header
            PDImageXObject pdImageXObject = PDImageXObject.createFromFile("/Users/sudeep-macmini/IdeaProjects/root/saleInvoiceProject/src/main/resources/img/logo.png",document);
            //Display the logo
            addLogoImage(contentStream,pdImageXObject,15,yStart-150);

            // Display each line of the header content
            displayHeaderContent(contentStream, headerContent4, 185, yStart - 60);
            displayHeaderContent(contentStream, headerContent5, 185, yStart - 80);
            displayHeaderContent(contentStream, headerContent6, 185, yStart - 100);
            displayHeaderContent(contentStream, headerContent7, 185, yStart - 120);

            // Add bold red line to separate header and body
            addSeparatorLine(contentStream, margin, yStart - 130,page, Color.RED,3f);

            // Sample template for the body (replace with actual values)
            displayBodyContent(contentStream, margin, yStart - 150,invoice);
            addSeparatorLine(contentStream, margin, yStart - 262,page, Color.RED,1f);

            addSeparatorLine(contentStream, margin, yStart - 285,page, Color.RED,1f);

            addSeparatorLine(contentStream, margin, yStart - 320,page, Color.RED,0.15f);

            addSeparatorLine(contentStream, margin, yStart - 400,page, Color.RED,1f);
            addSeparatorLine(contentStream, margin, yStart - 430,page, Color.RED,1f);

            addSeparatorLine(contentStream, 290, 250,page, Color.RED,1f);
            addSeparatorLine(contentStream, 290, 270,page, Color.RED,1f);


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

    private static void addLogoImage(PDPageContentStream pdPageContentStream, PDImageXObject img, float margin, float yPosition) throws IOException {


        pdPageContentStream.drawImage(img,margin,yPosition,200,150);

//        pdPageContentStream.newLineAtOffset(img.getWidth(), 0);
    }

    private static void addSeparatorLine(PDPageContentStream contentStream, float margin, float yPosition, PDPage page, Color color,float lineWidth) throws IOException {
        // Set the line color to red
//        contentStream.setStrokingColor(Color.RED);
//        contentStream.setLineWidth(2f); color , lineWidth

        contentStream.setStrokingColor(color);
        contentStream.setLineWidth(lineWidth);

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
        contentStream.newLineAtOffset(-390, -19);
        contentStream.showText("Bill To");

        // Firstname LastName
        contentStream.newLineAtOffset(0, -20);
        contentStream.showText("Firstname LastName" );

        // Address
        contentStream.newLineAtOffset(0, -21);
        contentStream.showText("Address: " + "address");

        // Mobile
        contentStream.newLineAtOffset(0,-22 );
        contentStream.showText("Mobile: " + "mobile");

        // State
        contentStream.newLineAtOffset(0, -23);
        contentStream.showText("State: " + "state");

        //Service
        contentStream.setFont(PDType1Font.HELVETICA, 12);
        contentStream.newLineAtOffset(0,-24.5f);
        contentStream.showText("SERVICES");

        //QTY
        contentStream.setFont(PDType1Font.HELVETICA,12);
        contentStream.newLineAtOffset(205,0);
        contentStream.showText("QTY");

        //RATE
        contentStream.setFont(PDType1Font.HELVETICA,12);
        contentStream.newLineAtOffset(68,0);
        contentStream.showText("RATE");

        //DISC
        contentStream.setFont(PDType1Font.HELVETICA,12);
        contentStream.newLineAtOffset(78,0);
        contentStream.showText("DISC");

        //AMOUNT
        contentStream.setFont(PDType1Font.HELVETICA,13);
        contentStream.newLineAtOffset(88,0);
        contentStream.showText("AMOUNT");

        contentStream.endText();
    }
}
