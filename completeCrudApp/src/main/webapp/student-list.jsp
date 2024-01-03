
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
    <link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>

<nav>
    <a href="index.jsp">Home</a>
    <a href="login.jsp">Login</a>
    <a href="student-form.jsp">Signup</a>

    <div class="search-container">
        <form action="studentName" method="get">
            <input type="search" placeholder="Search by Name" name="search">
            <input type="submit" value="Search">
        </form>
    </div>
</nav>

<h1>Student List</h1>
<table action="studentList" border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Username</th>
        <th>Password</th>

    </tr>
    </thead>
    <tbody>
    <!-- Add dynamic content here -->
    </tbody>
</table>
<br>
<a href="student-form.jsp">Add New Student</a>
</body>
</html>
