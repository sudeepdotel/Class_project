// HomePageServlet
package org.electronicShop.Controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class HomePageServlet extends HttpServlet {

    protected void doGet ( HttpServletRequest request, HttpServletResponse response ) throws IOException {
        response.setContentType ( "text/html" );

        // Welcome page with a link to get a receipt for an order number
        PrintWriter out = response.getWriter ( );
        out.println ( "<html><head><title>Welcome to Electronic Shop</title></head><body>" );
        out.println ( "<h1>Welcome to Electronic Shop</h1>" );
        out.println ( "<p>Enter the order number below to get a receipt:</p>" );
        out.println ( "<form action=\"/myElectronicShopProject_war_exploded/receipt\" method=\"get\">" );
        out.println ( "  Order Number: <input type=\"text\" name=\"orderId\" required>" );
        out.println ( "  <input type=\"submit\" value=\"Get Receipt\">" );
        out.println ( "</form>" );
        out.println ( "</body></html>" );
    }
}
