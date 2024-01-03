package operation;

import model.Employee;

import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesFileOperation {

    public void addEmployeeCredentialToPropertiesFile(Employee[] employees, String path) {

        try {
            Properties properties = new Properties();

            for (int i = 0; i < employees.length; i++) {
                Employee employee = employees[i];

                // Use a specific format for the keys (e.g., userid1, user1, password1, ...)
                String keyPrefix = "user" + (i + 1);

                // Store empId, userName, and password in properties file with the specific key format
                properties.setProperty(keyPrefix + "_UserID", employee.getEmpId());
                properties.setProperty(keyPrefix + "_User", employee.getUsername());
                properties.setProperty(keyPrefix + "_Password", employee.getPassword());
            }

            // Save to the property file
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            properties.store(fileOutputStream, "Employee Credentials");

            System.out.println("Employee info fetched and stored to property file !! ");
        } catch (Exception e) {
            System.err.println("Error message : " + e.getMessage());
        }
    }
}
