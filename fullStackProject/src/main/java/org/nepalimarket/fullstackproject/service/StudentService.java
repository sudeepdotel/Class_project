package org.nepalimarket.fullstackproject.service;

import org.hibernate.SessionFactory;
import org.nepalimarket.fullstackproject.dao.StudentDao;
import org.nepalimarket.fullstackproject.model.Student;

import java.util.List;

public class StudentService {

    private final StudentDao studentDao;

    public StudentService ( SessionFactory sessionFactory ) {
        this.studentDao = new StudentDao ( sessionFactory );
    }

    public void saveStudentDetails( Student  student){
        studentDao.saveStudent ( student );
    }

    public List<Student> getAllStudentDetails ( ) {
       return studentDao.getAllStudentInfo();
    }
}
