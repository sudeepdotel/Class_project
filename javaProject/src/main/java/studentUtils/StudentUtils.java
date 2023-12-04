package studentUtils;

import model.Student;

public class StudentUtils {

    public static String evaluateMarks(Student student , int passMark){
        if(student.getMarks() > passMark){
            return "A";
        }else {
            return "B";
        }
    }

    public static void graceMarks(Student student, int graceMark){
        if (student.getAddress().equalsIgnoreCase("Texas")){
            double percent = (double) graceMark/100;
            student.setMarks(student.getMarks() + (int)(student.getMarks() * percent));
        }
    }

    public static void displayStudentsDetails(Student student){
        System.out.println("Student ID : " + student.getId());
        System.out.println("Student Name : " + student.getName());
        System.out.println("Student Address : " + student.getAddress());
        System.out.println("Student Subject : " + student.getSubject());
        System.out.println("Student Marks : " + student.getMarks());
        System.out.println("Student Grade : " + student.getGrade());
        System.out.println("*********************");
    }
}
