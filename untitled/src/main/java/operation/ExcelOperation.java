package operation;

import model.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class ExcelOperation {

    public static void addEmployeeDetailsToExcelFile(Employee[] employees, String path){

        try{
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);

            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            // create sheet and giving its name
            XSSFSheet sheet = workbook.createSheet("Employeeeesssss");

            // create and add header row content
            Row headerRow = sheet.createRow(0);
            String[] headerContent = {"Employee ID", "Name", "Phone","Status","UserName", "Password"};
            //add each index value one by one
            for (int i =0; i < headerContent.length; i++){
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headerContent[i]);
            }
            System.out.println(Arrays.toString(headerContent) + " ");

            //populate the data to the each row
            for (int i =0; i < employees.length; i++){
                Row dataRow = sheet.createRow(i +1);
                Employee employee = employees[i];

                dataRow.createCell(0).setCellValue(employee.getEmpId());
                dataRow.createCell(1).setCellValue(employee.getName());
                dataRow.createCell(2).setCellValue(employee.getPhone());
                dataRow.createCell(3).setCellValue(employee.getStatus());
                dataRow.createCell(4).setCellValue(employee.getUsername());
                dataRow.createCell(5).setCellValue(employee.getPassword());
            }

            //Save to excel file
            FileOutputStream fileOutputStream = new FileOutputStream(path);

            workbook.write(fileOutputStream);
            System.out.println("Data saved successfully");



        }catch (Exception e){
            System.err.println("Error writing to excel file : " + e.getMessage());
        }
    }


}
