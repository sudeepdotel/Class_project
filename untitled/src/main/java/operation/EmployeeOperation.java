package operation;

import model.Employee;

import java.util.Scanner;

public class EmployeeOperation {

    public void addEmployeeDetails(int n, String excelPath,String pdfPath, Employee[] empArr){

        for (int i =0; i < empArr.length; i++){
            Employee employee = new Employee();

            System.out.println("Enter Employee Details "+ (i + 1) + ": ");
//            System.out.println("ID :");
//            employee.setId(new Scanner(System.in).nextInt());
            System.out.println("Name :");
            employee.setName(new Scanner(System.in).next());
            System.out.println("Phone :");
            employee.setPhone(new Scanner(System.in).nextLong());
            System.out.println("Status Active or New? : ");
            employee.setStatus(new Scanner(System.in).next());
            System.out.println("User Name :");
            employee.setUsername(new Scanner(System.in).next());
            System.out.println("User Password :");
            employee.setPassword(new Scanner(System.in).next());
            empArr[i] = employee;
            System.out.println(employee.toString());

            PdfFileOperation.welcomeLetterPdfGenerator(employee,pdfPath,2);
        }
        ExcelOperation.addEmployeeDetailsToExcelFile(empArr,excelPath);

    }


}
