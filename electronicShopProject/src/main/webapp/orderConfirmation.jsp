<%@ page import="java.util.List" %>
<%@ page import="org.nepalimarket.electronicshopproject.model.Order" %>
<%@ page import="org.nepalimarket.electronicshopproject.controller.OrderServlet" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles1.css">
    <title>Order Confirmation | Electronic Store</title>
</head>
<body>
<header>
    <h1>Order Confirmation</h1>
</header>

<nav>
    <li><a href="index.jsp">Home</a></li>
    <li><a href="registration.jsp">Sign Up</a></li>
    <li><a href="#search">Search & Explore</a></li>
    <li><a href="ProductDetailsServlet">Products</a></li>
    <li><a href="registerProduct.jsp">Admin Register Product</a></li>
    <li><a href="PlaceOrderForm.jsp">Place Order</a></li>

    <% if (session.getAttribute("customerId") != null) { %>
    <li class="welcome-message">Welcome, <%= session.getAttribute("customerFullName") %></li>
    <% } %>
</nav>

<section id="main-content">
    <h2>Order Confirmation</h2>

    <%-- Display order confirmation details --%>
    <p>Your order with Order ID <%= ((Order) request.getAttribute("placedOrder")).getOrderId() %> has been placed successfully!</p>

    <%-- Display list of items ordered --%>
    <h3>Items Ordered:</h3>
    <table>
        <thead>
        <tr>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Price Per Unit</th>
            <th>Total Price</th>
        </tr>
        </thead>
        <tbody>
        <%
            @SuppressWarnings("unchecked")
            List<Order> customerOrders = (List<Order>) request.getAttribute("customerOrders");
            if (customerOrders != null) {
                for (Order order : customerOrders) {
        %>
        <tr>
            <td><%= order.getProductName() %></td>
            <td><%= order.getQuantity() %></td>
            <td><%= order.getPricePerUnit() %></td>
            <td><%= order.getTotalPrice() %></td>
        </tr>
        <%
                }
            } else {
                // Handle the case where customerOrders is null
                System.out.println("<p>No orders found.</p>");
            }
        %>


        </tbody>
    </table>
</section>

<footer>
    <p>&copy; 2023 Electronic Store. All rights reserved.</p>
</footer>
</body>
</html>
