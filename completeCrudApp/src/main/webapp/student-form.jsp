<%--
  Created by IntelliJ IDEA.
  User: sudeep-macmini
  Date: 12/14/23
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Student Form</title>
    <link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>
<nav>
    <a href="index.jsp">Home</a>
    <a href="login.jsp">Login</a>
    <a href="student-form.jsp">Signup</a>

    <div class="search-container">
        <form action="http://localhost:8080/crudApp_war/studentName" method="get">
            <input type="text" placeholder="Search by Name" name="search">
            <input type="submit" value="Search">
        </form>
    </div>
</nav>

<h1>Student Form</h1>
<form action="http://localhost:8081/completeCrudApp_war_exploded/register" method="post">
    <input type="hidden" name="action" value="create">
    <label for="firstName">First Name:</label>
    <input type="text" name="firstName" required><br>
    <label for="lastName">Last Name:</label>
    <input type="text" name="lastName" required><br>
    <label for="address">Address:</label>
    <input type="text" name="address" required><br>
    <label for="phone">Phone:</label>
    <input type="text" name="phone" required><br>
    <label for="userName">Username:</label>
    <input type="text" name="userName" required><br>
    <label for="password">Password:</label>
    <input type="password" name="password" required><br>
    <input type="submit" value="Create">
</form>
<br>
<a href="student-list.jsp">Back to List</a>
</body>
</html>

