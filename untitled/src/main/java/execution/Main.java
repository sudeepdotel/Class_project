package execution;

import model.Employee;
import operation.EmployeeOperation;
import operation.PdfFileOperation;
import operation.PropertiesFileOperation;

public class Main {

    private static final String EXCEL_PATH = "/Users/sudeep-macmini/IdeaProjects/root/untitled/src/main/resources/emp_sheet.xlsx";
    private static final String PROPERTIES_PATH = "/Users/sudeep-macmini/IdeaProjects/root/untitled/src/main/resources/emp_credentials.properties";
    private static final String PDF_PATH = "/Users/sudeep-macmini/IdeaProjects/root/untitled/src/main/resources/welcomeLetter.pdf";

    public static void main(String[] args) {
        System.out.println("Welcome to the team!!");
        Employee[] employees = new Employee[2];
        //Employee emp = new Employee();
        EmployeeOperation employeeOperation = new EmployeeOperation();
        employeeOperation.addEmployeeDetails(2, EXCEL_PATH,PDF_PATH,employees);
        PropertiesFileOperation propertiesFileOperation = new PropertiesFileOperation();
        propertiesFileOperation.addEmployeeCredentialToPropertiesFile(employees,PROPERTIES_PATH);


//        PdfFileOperation pdfFileOperation = new PdfFileOperation();
//        pdfFileOperation.welcomeLetterPdfGenerator(emp,PDF_PATH);


    }
}

