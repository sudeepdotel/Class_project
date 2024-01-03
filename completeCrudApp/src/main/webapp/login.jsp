<%--
  Created by IntelliJ IDEA.
  User: sudeep-macmini
  Date: 12/14/23
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<!-- Navigation Bar -->
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

<h1>Login</h1>
<form action="http://localhost:8080/crudApp_war/login" method="post">
    <label for="userName">Username:</label>
    <input type="text" name="userName" required><br>
    <label for="password">Password:</label>
    <input type="password" name="password" required><br>
    <input type="submit" value="Login">
</form>
<br>
<a href="student-list.html">Back to List</a>

</body>
</html>

