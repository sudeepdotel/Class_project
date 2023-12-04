package mainExecution;

import model.Employee;
import operation.PropertiesFileOperation;

import java.util.Scanner;

import static operation.ExcelOperation.addEmployeeInfo;
import static operation.PdfGenerator.generateAndSaveAgreementPDF;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee =new Employee();
        System.out.print("Enter the number of employees : ");
        int n = scanner.nextInt();

        // Collect employee information and store in Excel file
        addEmployeeInfo(n);

        PropertiesFileOperation.fetchEmployeeCredentials();

        //TODO this is not write way need to fix it but I ll update

        // Generate and save agreement in PDF format
        generateAndSaveAgreementPDF(employee);

        System.out.println("Program executed successfully.");
    }

}

