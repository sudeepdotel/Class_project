package operation;

import model.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Scanner;

public class ExcelOperation {
    public static String excelPath = "/Users/sudeep-macmini/IdeaProjects/root/employeeBackground/src/main/resources/employeeInfo.xlsx";

    public static Employee[] addEmployeeInfo(int n) {
        Employee[] employees = new Employee[n];

        try {
            File file = new File(excelPath);
            FileInputStream fileInputStream = new FileInputStream(file);

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

            // Iterate over each cell in the header row
            Iterator<Cell> cellIterator = xssfSheet.getRow(0).cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String header = cell.getStringCellValue();

                // Check if the header corresponds to any attribute
                if ("Employee ID".equalsIgnoreCase(header)
                        || "employee name".equalsIgnoreCase(header)
                        || "employee address".equalsIgnoreCase(header)
                        || "employee phone".equalsIgnoreCase(header)
                        || "qualification".equalsIgnoreCase(header)
                        || "status".equalsIgnoreCase(header)
                        || "user name".equalsIgnoreCase(header)
                        || "password".equalsIgnoreCase(header)) {
                    // Header found, add the employee information
                    addEmployeeInformation(xssfSheet, header, employees);

                }
            }

            // Save the changes to the Excel file
            try (FileOutputStream fileOutputStream = new FileOutputStream(excelPath)) {
                xssfWorkbook.write(fileOutputStream);
            }

        } catch (Exception e) {
            System.err.println("Error Message " + e.getMessage());
        }

        return employees;
    }

    private static void addEmployeeInformation(XSSFSheet xssfSheet, String header, Employee[] employees) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < employees.length; i++) {
            Employee employee = new Employee();

            // Switch on the header and set values to  Employee object
            switch (header.toLowerCase()) {
                case "employee id":
                    employee.setEmpId(i+1);
                    break;
                case "employee name":
                    System.out.println("Enter Employee Name: ");
                    employee.setEmpName(scanner.next());
                    break;
                case "employee address":
                    System.out.println("Enter Employee Address: ");
                    employee.setEmpAddress(scanner.next());
                    break;
                case "employee phone":
                    System.out.println("Enter Employee Phone: ");
                    employee.setEmpPhone(scanner.nextLong());
                    break;
                case "qualification":
                    System.out.println("Enter Qualification: ");
                    employee.setQualification(scanner.next());
                    break;
                case "status":
                    System.out.println("Enter Status (Active/New): ");
                    employee.setStatus(scanner.next());
                    break;
                case "user name":
                    System.out.println("Enter User Name: ");
                    employee.setUserName(scanner.next());
                    break;
                case "password":
                    System.out.println("Enter Password: ");
                    employee.setPassword(scanner.next());
                    break;

                default:
                    System.out.println("Invalid header: " + header);
            }


            employees[i] = employee;
        }
    }


}
