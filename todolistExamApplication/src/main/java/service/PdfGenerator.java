package service;

import model.DailyExpenses;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PdfGenerator {

    public static void generateExpenseReport(List<DailyExpenses> expenses, OutputStream outputStream) {
        String[] header = {"ID", "Expense Name", "Date Time", "Purpose", "Amount"};
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
            contentStream.showText("Expense Report");
            contentStream.endText();

            // Add Header
            yStart = addHeader(contentStream, header, 650, tableWidth);

            // Add Content for each expense
            for (DailyExpenses expense : expenses) {
                yStart = addContent(contentStream, expense, yStart);
            }

            // Add Total Amount
            double totalAmount = expenses.stream().mapToDouble(DailyExpenses::getAmount).sum();
            addTotalAmount(document, totalAmount, yStart, 550, contentStream);

            contentStream.close();
            document.save(outputStream);
            document.save ( "/Users/sudeep-macmini/IdeaProjects/root/todolistExamApplication/src/main/resources/expense_report.pdf" );
            document.close();
            System.out.println("Expense report generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static float addHeader(PDPageContentStream contentStream, String[] header, float yStart, float tableWidth) throws IOException {
        // Add Header
        float margin = 50;
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.beginText();
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

    private static float addContent(PDPageContentStream contentStream, DailyExpenses expense, float yStart) throws IOException {
        // Add Content for each expense
        float margin = 50;
        float tableWidth = 500;
        float rowHeight = 15f;
        contentStream.setFont(PDType1Font.HELVETICA, 12);

        // Set yStart to the current y-position
        float yPosition = yStart;

        contentStream.beginText();
        contentStream.newLineAtOffset(margin, yPosition);
        contentStream.showText(String.valueOf(expense.getExpenseId()));
        contentStream.newLineAtOffset(tableWidth / 5, 0);
        contentStream.showText(expense.getExpenseName());
        contentStream.newLineAtOffset(tableWidth / 5, 0);
        contentStream.showText( String.valueOf ( expense.getDateTime () ) );
        contentStream.newLineAtOffset(tableWidth / 5, 0);
        contentStream.showText(expense.getPurpose());
        contentStream.newLineAtOffset(tableWidth / 5, 0);
        contentStream.showText(String.valueOf(expense.getAmount()));
        contentStream.endText();

        // Update yStart for the next expense
        yStart -= rowHeight;

        return yStart;
    }

    private static void addTotalAmount(PDDocument document, double totalAmount, float yStart, float tableWidth, PDPageContentStream contentStream) throws IOException {
        // Add a line
        contentStream.setLineWidth(1f);
        float margin = 50;
        contentStream.moveTo(margin, yStart);
        contentStream.lineTo(margin + tableWidth, yStart);
        contentStream.stroke();

        // Update yStart for the next operation
        yStart -= 1f;

        // Add Total Amount text
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.newLineAtOffset(margin + tableWidth / 1.40f, yStart - 10);
        contentStream.showText("Total Amount: $" + String.format("%.2f", totalAmount));
        contentStream.endText();
    }


}
