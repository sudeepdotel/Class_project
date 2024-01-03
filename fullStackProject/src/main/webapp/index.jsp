<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<h2>Save Student Information</h2>

<form action="saveInfo" method="post">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required><br>

    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" required><br>

    <label for="age">Age:</label>
    <input type="number" id="age" name="age" required><br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required><br>

    <label for="studentDepartment">Department:</label>
    <input type="text" id="studentDepartment" name="studentDepartment" required><br>

    <input type="submit" value="Save Student">

</form>

<div class="nav-links">
    <a href="getStudentInfo">Student Info</a>
</div>

</body>
</html>