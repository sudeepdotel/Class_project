import model.Student;
import operations.StudentOperation;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Student[] student = new Student[2];

        StudentOperation.addStudentDetails(student);

        System.out.println("********************************STUDENT DETAILS****************************************");
        StudentOperation.displayStudentDetails(student);

        Scanner sc = new Scanner(System.in);

        System.out.println("Would you like to update? Y/N");
        String choice= sc.next();
        if(choice.equalsIgnoreCase("Y")){
            System.out.println("Search by the rollNumber");
            String checkRollNumber = sc.next();
            Student foundStudent = StudentOperation.searchStudentByRollNumber(checkRollNumber, student);

            if (foundStudent != null ){
                StudentOperation.editStudentInfo(foundStudent);
                StudentOperation.saveStudentDetails(foundStudent, student);
                StudentOperation.displaySingleStudentDetails(foundStudent);

            } else {
                System.out.println("student not found !!");
            }
        } else{
            System.out.println("Session is done !!");
        }



    }
}
