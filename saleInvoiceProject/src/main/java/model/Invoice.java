package model;

import org.apache.poi.hpsf.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Invoice {

    private static  String COMPANY_HEADER = "Weekytrips Tour Planner\n207 Webel IT Park, City Center, Haldia, Debhog, Haldia, West Bengal, 721631\nMobile: 9174100111\nEmail: support@weekytrips.com";
    private static final String BANK_DETAILS = "Name: Proctom Technology Pvt Ltd\nIFSC Code: ICIC0003507\nAccount No: 350705000991\nBank: ICICI Bank, HALDIA TOWNSHIP";
    private static final String NOTES = "1 Child Half TAXABLE AMOUNT\nTOTAL AMOUNT\nReceived Amount\nBalance";
    private static final String AUTHORIZED_SIGNATORY = "AUTHORISED SIGNATORY FOR Weekytrips Tour Planner";

    private String invoiceNumber;
    private String invoiceDate;
    private String dueDate;
    private String billTo;
    private String services;
    private float taxableAmount;
    private float totalAmount;
    private float receivedAmount;
    private float balanceAmount;
    private String nextDueDate;


    public String getCompanyHeader() {
        return COMPANY_HEADER;
    }

    public String getBankDetails() {
        return BANK_DETAILS;
    }

    public String getNotes() {
        return NOTES;
    }

    public String getAuthorizedSignatory() {
        return AUTHORIZED_SIGNATORY;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }


    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }



    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getBillTo() {
        return billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public float getTaxableAmount() {
        return taxableAmount;
    }

    public void setTaxableAmount(float taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(float receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public float getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(float balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getNextDueDate() {
        return nextDueDate;
    }

    public void setNextDueDate(String nextDueDate) {
        this.nextDueDate = nextDueDate;
    }
}
