import model.Student;
import studentUtils.InputUsers;
import studentUtils.StudentUtils;

import java.util.Scanner;

public class MainExecution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student[] studentArr = InputUsers.getStudentDetails(input, 2);
        for(Student students: studentArr){
            StudentUtils.graceMarks(students, 10);

            String updatedMarksAfterEvaluation = StudentUtils.evaluateMarks(students,75);
            students.setGrade(updatedMarksAfterEvaluation);
            System.out.println("*****Student Details*****");
            StudentUtils.displayStudentsDetails(students);
        }
    }
}
