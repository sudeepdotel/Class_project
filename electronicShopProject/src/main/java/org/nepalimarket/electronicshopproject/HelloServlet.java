package org.nepalimarket.electronicshopproject;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init ( ) {
        message = "it's working ";
    }

    public void doGet ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.setContentType ( "text/html" );

        // Hello
        PrintWriter out = response.getWriter ( );
        out.println ( "<html><body>" );
        out.println ( "<h1>" + message + "</h1>" );
        out.println ( "</body></html>" );
    }

    public void destroy ( ) {
    }
}