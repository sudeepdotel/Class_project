package org.electronicShop.Service;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.electronicShop.model.Order;

import java.io.IOException;
import java.io.OutputStream;

public class ReceiptGenerator {

    public static void generateReceipt ( Order order, OutputStream outputStream ) {
        String[] header = { "ID", "Product Name", "Qty", "Price", "Total Price" };

        try {
            PDDocument document = new PDDocument ( );
            PDPage page = new PDPage ( );
            document.addPage ( page );

            PDPageContentStream contentStream = new PDPageContentStream ( document, page );
            // Add Title
            contentStream.setFont ( PDType1Font.HELVETICA_BOLD, 18 );
            contentStream.beginText ( );
            contentStream.newLineAtOffset ( 50, 750 );
            contentStream.showText ( "Quality Electronic Shop" );
            contentStream.endText ( );
            contentStream.beginText ( );
            contentStream.newLine ( );
            // Add Header
            addHeader ( contentStream, header );
            // Add Content
            addContent ( contentStream, order );
            contentStream.close ( );

            document.save ( "/Users/sudeep-macmini/IdeaProjects/root/myElectronicShopProject/src/main/resources/receipt.pdf" );
            document.save ( outputStream );
            document.close ( );
            System.out.println ( "Receipt generated successfully." );
        } catch (IOException e) {
            e.printStackTrace ( );
        }
    }

    private static void addHeader ( PDPageContentStream contentStream, String[] header ) throws IOException {
        contentStream.setFont ( PDType1Font.HELVETICA_BOLD, 12 );
        float margin = 50;
        float yStart = 700;
        float tableWidth = 500;

        contentStream.newLineAtOffset ( margin, yStart );
        for (String headerTitle : header) {
            contentStream.showText ( headerTitle );
            contentStream.newLineAtOffset ( tableWidth / header.length, 0 );
        }
        contentStream.endText ( );

        float yPosition = yStart - 20;
        contentStream.setLineWidth ( 1f );
        contentStream.moveTo ( margin, yPosition );
        contentStream.lineTo ( margin + tableWidth, yPosition );
        contentStream.stroke ( );
    }

    private static void addContent ( PDPageContentStream contentStream, Order order ) throws IOException {
        float margin = 50;
        float yStart = 700;
        float tableWidth = 500;
        float rowHeight = 15f;

        contentStream.setFont ( PDType1Font.HELVETICA, 12 );
        contentStream.beginText ( );
        contentStream.newLineAtOffset ( margin, yStart - rowHeight );
        contentStream.showText ( String.valueOf ( order.getOrderId ( ) ) );
        contentStream.newLineAtOffset ( tableWidth / 5, 0 );
        contentStream.showText ( order.getProductName ( ) );
        contentStream.newLineAtOffset ( tableWidth / 5, 0 );
        contentStream.showText ( String.valueOf ( order.getQty ( ) ) );
        contentStream.newLineAtOffset ( tableWidth / 5, 0 );
        contentStream.showText ( String.valueOf ( order.getPrice ( ) ) );
        contentStream.newLineAtOffset ( tableWidth / 5, 0 );
        contentStream.showText ( String.valueOf ( order.getTotalPrice ( ) ) );
        contentStream.endText ( );
    }
}
