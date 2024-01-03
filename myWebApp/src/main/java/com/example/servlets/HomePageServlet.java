package com.example.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/home")
public class HomePageServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       try{
           request.getRequestDispatcher("/html/index.html").forward(request,response);

           PrintWriter out = response.getWriter();
           out.println("successfully inside the doGet of home ");

       }catch (ServletException e){
           System.err.println("error message :: "+ e.getMessage());
       }

    }

}
