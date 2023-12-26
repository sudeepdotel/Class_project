package org.nepalimarket.fullstackproject.fileOperation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.nepalimarket.fullstackproject.model.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelFileWriter {

    private static final String FILE_PATH = "/Users/sudeep-macmini/IdeaProjects/root/fullStackProject/src/main/resources/files/studentData.xlsx";

    public static void writeStudentDataToExcel( List<Student> students) {


        try (Workbook workbook = new XSSFWorkbook ()) {
            Sheet sheet = workbook.createSheet("Student Data");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Student ID");
            headerRow.createCell(1).setCellValue("First Name");
            headerRow.createCell(2).setCellValue("Last Name");
            headerRow.createCell(3).setCellValue("Age");
            headerRow.createCell(4).setCellValue("Address");
            headerRow.createCell(5).setCellValue("Department");

            // Populate data rows
            int rowNum = 1;
            for (Student student : students) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(student.getStudentId());
                row.createCell(1).setCellValue(student.getFirstName());
                row.createCell(2).setCellValue(student.getLastName());
                row.createCell(3).setCellValue(student.getAge());
                row.createCell(4).setCellValue(student.getAddress());
                row.createCell(5).setCellValue(student.getStudentDepartment());
            }

            // Write the workbook to a file
            try (FileOutputStream fileOut = new FileOutputStream(FILE_PATH)) {
                workbook.write(fileOut);
                System.out.println("Student data written to Excel file successfully!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readStudentDataFromExcel() {
        List<Student> students = new ArrayList<> ();

        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip header row
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Student student = new Student();
                int cellIndex = 0;

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cellIndex) {
                        case 0:
                            student.setStudentId((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            student.setFirstName(cell.getStringCellValue());
                            break;
                        case 2:
                            student.setLastName(cell.getStringCellValue());
                            break;
                        case 3:
                            student.setAge((int) cell.getNumericCellValue());
                            break;
                        case 4:
                            student.setAddress(cell.getStringCellValue());
                            break;
                        case 5:
                            student.setStudentDepartment(cell.getStringCellValue());
                            break;
                        default:
                            // Handle additional columns if needed
                            break;
                    }
                    cellIndex++;
                }

                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

}
