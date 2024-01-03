package org.nepalimarket.completecrudapp.dao;

import org.nepalimarket.completecrudapp.model.Student;
import org.nepalimarket.completecrudapp.utils.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public static List<Student> getAllStudentDetails(){

        //declare a list object
        List<Student> stdList = new ArrayList<Student>();

        try {
            Connection conn = DbConnection.getConnection();
            String sql = "select * from student"; // 3 records
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Student  student = new Student();
                ///setting object values from resultset
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
                student.setPhone(rs.getString(4));
                student.setUserName(rs.getString(5));
                student.setPassword(rs.getString(6));

                stdList.add(student);

            }
            conn.close();

        }catch(Exception e) {
            e.printStackTrace();
        }

        return stdList;
    }
}
