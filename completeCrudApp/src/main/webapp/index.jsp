<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Management System</title>
    <link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>

<nav>
    <a href="index.jsp">Home</a>
    <a href="login.jsp">Login</a>
    <a href="student-form.jsp">Signup</a>

    <div class="search-container">
        <form action="http://localhost:8081/crudApp_war/studentName" method="get">
            <input type="text" placeholder="Search by Name" name="search">
            <input type="submit" value="Search">
        </form>
    </div>
</nav>

<div style="padding:20px" >
    <!-- Your page content goes here -->
    <h2>Welcome to Student Management System</h2>
    <p>This is the home page content.</p>

</div>

</body>
</html>
