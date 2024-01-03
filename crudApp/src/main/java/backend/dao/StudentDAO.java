package backend.dao;

import backend.utils.DbConnection;
import backend.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public int save(Student student){
        int status =0;
        try{
            // Establish connection with db
            Connection conn = DbConnection.getConnection();
            String sql = "INSERT INTO studentdetails (firstName,lastName,address,phone, userName,password)" + "values (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            //add the values from object

            ps.setString(1,student.getFirstName());
            ps.setString(2,student.getLastName());
            ps.setString(3,student.getAddress());
            ps.setString(4, String.valueOf(student.getPhone()));
            ps.setString(5,student.getUserName());
            ps.setString(6,student.getPassword());

            status =ps.executeUpdate();
            System.out.println("Data inserted successfully");
            conn.close();


        }catch (Exception e){
            e.printStackTrace();
        }
        return status;

    }

    public static List<Student> getStudentDetailsByName(String name) {
        List<Student> stdList = new ArrayList<>();

        try {
            Connection conn = DbConnection.getConnection();
            String sql = "SELECT * FROM studentdetails WHERE firstname=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String address = rs.getString("address");
                long phone = rs.getLong("phone");
                String userName = rs.getString("userName");
                String password = rs.getString("password");

                Student student = new Student(firstName, lastName, address, phone, userName, password);
                stdList.add(student);
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stdList;
    }


    public static List<Student> getAllStudentDetails(){

        //declare a list object
        List<Student> stdList = new ArrayList<Student>();

        try {
            Connection conn = DbConnection.getConnection();
            String sql = "select * from studentdetails"; // 3 records
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Student  student = new Student();
                ///setting object values from resultset
                student.setFirstName(rs.getString(2));
                student.setLastName(rs.getString(3));
                student.setAddress(rs.getString(4));
                student.setPhone(rs.getLong(5));
                student.setUserName(rs.getString(6));
                student.setPassword(rs.getString(7));

                stdList.add(student);

            }
            conn.close();

        }catch(Exception e) {
            e.printStackTrace();
        }

        return stdList;
    }

//    public static Student updateStudentDetailsByName(String name){
//
//        return student;
//    }
    }

