package employeeAgreement;



import model.Employee;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import static operation.PropertiesFileOperation.propertiesFilePath;

public class EmployeeManagement {

    private static final String EXCEL_PATH = "/Users/sudeep-macmini/IdeaProjects/root/employeeBackground/src/main/resources/employeeInfo1.xlsx";
    private static final String PROPERTIES_PATH = "/Users/sudeep-macmini/IdeaProjects/root/employeeBackground/src/main/resources/emp_credentials.properties";
    private static final String AGREEMENT_PDF_PATH = "/Users/sudeep-macmini/IdeaProjects/root/employeeBackground/src/main/resources/agreement.pdf";

    private static final int EMPLOYEE_COUNT = 1; // Default value, can be changed based on user input

    public static void main(String[] args) {


        // Collect employee information and store in Excel file
        Employee[] employees = addEmployeeInfo(EMPLOYEE_COUNT);

        // Fetch and store empId, username, and password in properties file
        fetchAndStoreEmployeeCredentials(employees);

        // Generate and save agreement in PDF format for new employees
        generateAndSaveAgreementPDF(employees);

        System.out.println("Program executed successfully.");
    }

    private static Employee[] addEmployeeInfo(int n) {
        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            Employee employee = new Employee();

            // Collect employee details from the console
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            employee.setEmpId(i + 1); // Automatically set empId as per the loop index
            System.out.print("Name: ");
            employee.setEmpName(new Scanner(System.in).nextLine());
            System.out.print("Address: ");
            employee.setEmpAddress(new Scanner(System.in).nextLine());
            System.out.print("Mobile No: ");
            employee.setEmpPhone(new Scanner(System.in).nextLong());
            System.out.print("Qualification: ");
            employee.setQualification(new Scanner(System.in).nextLine());
            System.out.print("Status (Active/New): ");
            employee.setStatus(new Scanner(System.in).nextLine());
            System.out.print("Username: ");
            employee.setUserName(new Scanner(System.in).nextLine());
            System.out.print("Password: ");
            employee.setPassword(new Scanner(System.in).nextLine());

            employees[i] = employee;
        }

        // Save employee information to Excel file
        saveEmployeeInfoToExcel(employees);

        return employees;
    }

    private static void saveEmployeeInfoToExcel(Employee[] employees) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Employee Information");

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] headers = {"Employee ID", "Name", "Address", "Mobile No", "Qualification", "Status", "Username", "Password"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Populate data rows
            for (int i = 0; i < employees.length; i++) {
                Row dataRow = sheet.createRow(i + 1);
                Employee employee = employees[i];

                dataRow.createCell(0).setCellValue(employee.getEmpId());
                dataRow.createCell(1).setCellValue(employee.getEmpName());
                dataRow.createCell(2).setCellValue(employee.getEmpAddress());
                dataRow.createCell(3).setCellValue(employee.getEmpPhone());
                dataRow.createCell(4).setCellValue(employee.getQualification());
                dataRow.createCell(5).setCellValue(employee.getStatus());
                dataRow.createCell(6).setCellValue(employee.getUserName());
                dataRow.createCell(7).setCellValue(employee.getPassword());
            }

            // Save to Excel file
            try (FileOutputStream fileOut = new FileOutputStream(EXCEL_PATH)) {
                workbook.write(fileOut);
                System.out.println("Saved data successfully");
            }

        } catch (Exception e) {
            System.err.println("Error saving to Excel: " + e.getMessage());
        }
    }



    private static void generateAndSaveAgreementPDF(Employee[] employees) {
        try {
            for (Employee employee : employees) {
                if ("new".equalsIgnoreCase(employee.getStatus())) {
                    generateAndSaveAgreementPDF(employee, AGREEMENT_PDF_PATH);
                }
            }
        } catch (Exception e) {
            System.err.println("Error generating and saving agreement PDF: " + e.getMessage());
        }
    }

    public static void fetchAndStoreEmployeeCredentials(Employee[] employees) {
        try {
            Properties properties = new Properties();

            for (Employee employee : employees) {
                // Store empId, userName, and password in properties file
                properties.setProperty("empId" + employee.getEmpId(), String.valueOf(employee.getEmpId()));
                properties.setProperty("userName" + employee.getEmpId(), employee.getUserName());
                properties.setProperty("password" + employee.getEmpId(), employee.getPassword());
            }

            // Save the properties to the file
            try (FileOutputStream fileOutputStream = new FileOutputStream(propertiesFilePath)) {
                properties.store(fileOutputStream, "Employee Credentials");
            }

            System.out.println("Employee credentials fetched and stored successfully.");

        } catch (Exception e) {
            System.err.println("Error fetching and storing employee credentials: " + e.getMessage());
        }
    }

    public static void generateAndSaveAgreementPDF(Employee employee, String path) {
        try {
            if ("new".equalsIgnoreCase(employee.getStatus())) {
                File file = new File(path);
                // Create a new PDF document
                PDDocument document = new PDDocument();
                PDPage page = new PDPage();
                document.addPage(page);

                // Create content stream
                PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, false);
                contentStream.beginText();

                // Set font and font size


                contentStream.setFont(PDType1Font.HELVETICA, 15);

                // Add content to the PDF
//                String content = "Hi " + employee.getEmpName() + ",\n\n" +
//                        "We are delighted to inform you that you have been selected for the job. We will " +
//                        "send further communication to the following address:\n" +
//                        employee.getEmpAddress() + "\n\n" +
//                        "We request you to accept the agreement and send us confirmation of the joining.\n\n" +
//                        "Thanks,\nHR Team.";

                String content = "Hi very delighted to have you in our team";
                // Set text position
                contentStream.newLineAtOffset(20, 700);



                // Add content to the PDF
                contentStream.showText(content);

                // End text and close content stream
                contentStream.endText();
                contentStream.close();

                // Save the document
                document.save(file);
                document.close();

                System.out.println("Agreement PDF generated and saved successfully for employee ID " + employee.getEmpId());
            } else {
                System.out.println("No agreement PDF generated for employee ID " + employee.getEmpId() + " as the status is not 'New'.");
            }
        } catch (IOException e) {
            System.err.println("Error generating the PDF: " + e.getMessage());
        }
    }

}

