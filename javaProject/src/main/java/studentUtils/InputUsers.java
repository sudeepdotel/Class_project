package studentUtils;

import model.Student;

import java.util.Scanner;

public class InputUsers {

    public static Student[] getStudentDetails(Scanner input, int numberOfStudent){
        Student[] studentArray = new Student[numberOfStudent];

        for (int i = 0; i < studentArray.length; i++){
            Student student = new Student();

            System.out.println("Enter " + ( i +1) + " Student ID : ");
            student.setId(input.nextInt());
            System.out.println("Enter " + (i + 1) + " Student Name : ");
            student.setName(input.next());
            System.out.println("Enter " + (i + 1) + " Student Address : ");
            student.setAddress(input.next());
            System.out.println("Enter " + (i + 1) + " Student Subject : ");
            student.setSubject(input.next());
            System.out.println("Enter " + (i + 1) + " Student Marks : ");
            student.setMarks(input.nextInt());

            studentArray[i] = student;
        }
        return studentArray;
    }
}
