package backend.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentRegistration","root","Coding@2211");
        }catch(Exception e){
            System.out.println(e.getMessage());}
        return con;
    }


}
