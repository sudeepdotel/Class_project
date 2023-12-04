package operations;

import model.Student;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StudentOperation {

    public static void addStudentDetails(Student[] student) {
        for(int i =0; i < student.length; i++){
            Student std = new Student();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name: ");
            String sName = scanner.next();
            std.setName(sName);
            System.out.println("Enter address: ");
            String sAddress = scanner.next();
            std.setAddress(sAddress);
            System.out.println("Enter contact: ");
            String sContact = scanner.next();
            std.setContact(sContact);
            System.out.println("Enter email: ");
            String sEmail = scanner.next();
            if(emailValidation(sEmail)){
                std.setEmail(sEmail);
            }else {
                System.out.println("invalid email");
            }
            student[i] = std;
        }
    }

    public static void displayStudentDetails(Student[] student) {

        System.out.printf("%-20s%-20s%-20s%-20s%-20s%n", "Roll Number", "Name", "Address", "Contact", "Email");
        System.out.println("***************************************************************************************");

        for (Student stdVar : student) {
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%n",
                    stdVar.getStudentRollNumber(),
                    stdVar.getName(),
                    stdVar.getAddress(),
                    stdVar.getContact(),
                    stdVar.getEmail());
            System.out.println("***************************************************************************************");

        }
    }

    public static void displaySingleStudentDetails(Student student) {

        System.out.println("********************************STUDENT DETAILS****************************************");
        System.out.printf("%-15s%-15s%-20s%-20s%-20s%n", "Roll Number", "Name", "Address", "Contact", "Email");
        System.out.println("***************************************************************************************");
        System.out.printf("%-15s%-15s%-20s%-20s%-20s%n",
                    student.getStudentRollNumber(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getEmail());
        System.out.println("***************************************************************************************");


    }



    public static Student searchStudentByRollNumber(String  rollNum, Student[] students) {
        for (Student student : students) {
            if (student.getStudentRollNumber().equalsIgnoreCase(rollNum)) {
                return student;
            }
        }
        return null;
    }



    public static void editStudentInfo(Student student) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                choose 1 for name :\s
                choose 2 for address :\s
                choose 3 for contact :\s
                choose 4 for email :\s
                """);
        int choice = scanner.nextInt();
        switch (choice) {

            case 1:
                System.out.println("Update name : ");
                student.setName((String) scanner.next());
                break;
            case 2:
                System.out.println("Update address : ");
                student.setAddress((String) scanner.next());
                break;
            case 3:
                System.out.println("update contact : ");
                student.setContact((String) scanner.next());
                break;
            case 4:
                System.out.println("update email : ");
                student.setEmail((String) scanner.next());
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void saveStudentDetails(Student student, Student[] students) {
        // Find the index of the student in the array
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && student.getStudentRollNumber().equalsIgnoreCase(students[i].getStudentRollNumber())) {
                index = i;
                break;
            }
        }

        // Save the updated student back to the array
        if (index != -1) {
            students[index] = student;
            System.out.println("Student details saved successfully.");
        } else {
            System.out.println("Error: Student not found in the array.");
}
    }

    public static boolean emailValidation(String email){

        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void nameValidation(String name ){
        //TODO validate name

    }

    public static void addressValidation(String address ){
        //TODO validate address

    }

    public static void contactValidation(String contact ){
        //TODO validate contact

    }

}
