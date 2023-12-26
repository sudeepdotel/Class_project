<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Students</title>
</head>
<body>

<h2>Student Data</h2>

<table border="1">
    <tr>
        <th>Student ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Address</th>
        <th>Department</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.studentId}</td>
            <td>${student.firstName}</td>
            <td>${student.lastName}</td>
            <td>${student.age}</td>
            <td>${student.address}</td>
            <td>${student.studentDepartment}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
