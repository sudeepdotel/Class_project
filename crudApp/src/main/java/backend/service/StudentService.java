package backend.service;

import backend.dao.StudentDAO;
import backend.model.Student;



public class StudentService {
    public static StudentDAO dao = new StudentDAO();
    public static void studentRegistration(Student student){
        dao.save(student);
    }
    public static void getStudentDetails(String name){
        dao.getStudentDetailsByName(name);
    }
    //TODO implemantation required

}
