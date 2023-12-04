package operation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Properties;

import static operation.ExcelOperation.excelPath;

public class PropertiesFileOperation {
    public static String propertiesFilePath = "/Users/sudeep-macmini/IdeaProjects/root/employeeBackground/src/main/resources/emp_credentials.properties";
    public static void fetchEmployeeCredentials() {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);

            Properties properties = new Properties();
            int noOfSheets = workbook.getNumberOfSheets();

            for (int i = 0; i < noOfSheets; i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rowIterator = sheet.iterator();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();

                    // Skip the header row
                    if (row.getRowNum() == 0) {
                        continue;
                    }

                    Iterator<Cell> cellIterator = row.cellIterator();

                    int empId = -1;
                    String userName = null;
                    String password = null;

                    while (((Iterator<?>) cellIterator).hasNext()) {
                        Cell cell = cellIterator.next();
                        int columnIndex = cell.getColumnIndex();

                        switch (columnIndex) {
                            case 0:
                                empId = (int) cell.getNumericCellValue();
                                break;
                            case 6:
                                userName = cell.getStringCellValue();
                                break;
                            case 7:
                                password = cell.getStringCellValue();
                                break;
                        }
                    }

                    if (empId != -1 && userName != null && password != null) {
                        // Store empId, userName, and password in properties file
                        properties.setProperty("empId" + empId, String.valueOf(empId));
                        properties.setProperty("userName" + empId, userName);
                        properties.setProperty("password" + empId, password);
                    }
                }
            }

            // Save the properties to the file
            try (FileOutputStream fileOutputStream = new FileOutputStream(propertiesFilePath)) {
                properties.store(fileOutputStream, "Employee Credentials");
            }

            System.out.println("Employee credentials fetched and stored successfully.");

        } catch (Exception e) {
            System.err.println("Error Message: " + e.getMessage());
        }
    }
}
