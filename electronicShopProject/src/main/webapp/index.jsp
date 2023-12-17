<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles1.css">

    <title>Office Theme | Electronic Store</title>
</head>
<body>
<header>
    <h1>Welcome to our Electronic Store</h1>
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
    <!-- Content will be dynamically loaded based on user interaction -->
    <h2>Educational Home Page </h2>
    <p>This is the main content area of the homepage. You can add more content here.</p>
</section>

<footer>
    <p>&copy; 2023 Electronic Store. All rights reserved.</p>
</footer>
</body>
</html>
