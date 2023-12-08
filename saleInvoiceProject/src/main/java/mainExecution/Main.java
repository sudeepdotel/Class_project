package mainExecution;

import model.Invoice;
import org.apache.poi.hpsf.Date;
import service.PdfTemplate;

import static service.PdfTemplate.generateInvoicePDF;

public class Main {

    public static void main(String[] args) {
        // Example usage:
        Invoice invoice = new Invoice();
        invoice.setInvoiceNumber("INV-001");
        invoice.setInvoiceDate("02-10-2025");
        invoice.setDueDate("02-25-2025");
        // Set more details...

        generateInvoicePDF(invoice, "/Users/sudeep-macmini/IdeaProjects/root/saleInvoiceProject/src/main/resources/generated.pdf");
    }
}
