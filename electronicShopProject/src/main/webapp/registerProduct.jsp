<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles1.css">
    <title>Product Registration</title>
</head>
<body>
<header>
    <h1>Product Registration</h1>
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
        <!-- Add more navigation items as needed -->
    </ul>
</nav>
        <!-- Add more navigation items as needed -->
    </ul>
</nav>

<section id="main-content">
    <h2>Product Registration Form</h2>
    <form action="ProductRegistrationServlet" method="post">
        <label for="productName">Product Name:</label>
        <input type="text" id="productName" name="productName" required><br>

        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea><br>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" required><br>

        <label for="quantityAvailable">Quantity Available:</label>
        <input type="number" id="quantityAvailable" name="quantityAvailable" required><br>

        <input type="submit" value="Register Product">
    </form>
</section>

<footer>
    <p>&copy; 2023 Electronic Store. All rights reserved.</p>
</footer>
</body>
</html>
