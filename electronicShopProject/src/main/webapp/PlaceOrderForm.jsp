<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles1.css">
    <title>Place Order</title>
</head>
<body>
<header>
    <h1>Place Order</h1>
</header>

<nav>
    <ul>
        <li><a href="index.jsp">Home</a></li>
        <li><a href="registration.jsp">Sign Up</a></li>
        <li><a href="#search">Search & Explore</a></li>
        <li><a href="ProductDetailsServlet">Products</a></li>
        <li><a href="registerProduct.jsp">Admin Register Product</a></li>
        <li><a href="PlaceOrderForm.jsp">Place Order</a></li>

        <% if (session.getAttribute("customerId") != null) { %>
        <li class="welcome-message">Welcome, <%= session.getAttribute("customerFullName") %></li>
        <% } %>
    </ul>
</nav>

<section id="main-content">
    <h2>Order Details</h2>
    <!-- Add your order form here -->
    <form action="OrderServlet" method="post">
        <label for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName" required><br>

        <label for="quantity">Quantity:</label>
        <input type="text" id="quantity" name="quantity" required><br>

        <input type="submit" value="Place Order">
    </form>

    <!-- Add a button to generate the PDF receipt -->
    <form action="receipt" method="post">
        <input type="hidden" name="customerId" value="<%= session.getAttribute("customerId") %>">
        <input type="submit" value="Generate PDF Receipt">
    </form>
</section>

<footer>
    <p>&copy; 2023 Electronic Store. All rights reserved.</p>
</footer>
</body>
</html>
