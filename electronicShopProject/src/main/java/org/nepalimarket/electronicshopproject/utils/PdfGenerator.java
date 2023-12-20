package org.nepalimarket.electronicshopproject.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.nepalimarket.electronicshopproject.model.Order;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PdfGenerator {


    public static void generateReceipts(List<Order> orders, OutputStream outputStream, String customerName) {
        String[] header = {"ID", "Product Name", "Qty", "Price", "Total Price"};
        float rowHeight = 15f;

        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            float yStart = 700; // Set an initial yStart value
            float tableWidth = 500;

            // Add Title
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, yStart);
            contentStream.showText("Quality Electronic Shop");
            contentStream.endText();

            // Add Customer Name and Date in the top right corner
            contentStream.setFont(PDType1Font.HELVETICA, 14);
            contentStream.beginText();
            contentStream.newLineAtOffset(400, yStart);
            contentStream.showText("Name: " + customerName);
            contentStream.newLineAtOffset(0, -15);
            contentStream.showText("Date: " + getCurrentDateTime());
            contentStream.endText();

            // Add Header
            yStart = addHeader(contentStream, header, 650, tableWidth);

            // Add Content for each order
            for (Order order : orders) {
                yStart = addContent(contentStream, order, yStart);
            }

            // Add Subtotal
            double subtotal = orders.stream().mapToDouble(Order::getTotalPrice).sum();
            addSubtotal(document, subtotal, yStart, 550, contentStream);

            contentStream.close();
            document.save(outputStream);
            document.close();
            System.out.println("Receipts generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static float addHeader(PDPageContentStream contentStream, String[] header, float yStart, float tableWidth) throws IOException {
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        float margin = 50;

        contentStream.beginText ();
        contentStream.newLineAtOffset(margin, yStart);
        for (String headerTitle : header) {
            contentStream.showText(headerTitle);
            contentStream.newLineAtOffset(tableWidth / header.length, 0);
        }
        contentStream.endText();


        // Update yStart for the next operation
        yStart -= 20; // Adjust as needed
        return yStart;
    }
    private static float addContent(PDPageContentStream contentStream, Order order, float yStart) throws IOException {
        float margin = 50;
        float tableWidth = 500;
        float rowHeight = 15f;

        contentStream.setFont(PDType1Font.HELVETICA, 12);

        // Set yStart to the current y-position
        float yPosition = yStart;

        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);
        contentStream.showText(String.valueOf(order.getOrderId()));
        contentStream.newLineAtOffset(tableWidth / 5, 0);
        contentStream.showText(order.getProductName());
        contentStream.newLineAtOffset(tableWidth / 5, 0);
        contentStream.showText(String.valueOf(order.getQuantity()));
        contentStream.newLineAtOffset(tableWidth / 5, 0);
        contentStream.showText(String.valueOf(order.getPricePerUnit()));
        contentStream.newLineAtOffset(tableWidth / 5, 0);
        contentStream.showText(String.valueOf(order.getTotalPrice()));
        contentStream.endText();

        // Update yStart for the next order
        yStart -= rowHeight;

        return yStart;
    }
    private static void addSubtotal(PDDocument document, double subtotal, float yStart, float tableWidth, PDPageContentStream contentStream) throws IOException {
        float margin = 50;

        // Add a line
        contentStream.setLineWidth(1f);
        contentStream.moveTo(margin, yStart);
        contentStream.lineTo(margin + tableWidth, yStart);
        contentStream.stroke();

        // Update yStart for the next operation
        yStart -= 1f;

        // Add Subtotal text
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.newLineAtOffset(margin + tableWidth/1.40f, yStart - 10);
        contentStream.showText("Subtotal: $" + String.format("%.2f", subtotal));
        contentStream.endText();
    }
    private static String getCurrentDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

}
