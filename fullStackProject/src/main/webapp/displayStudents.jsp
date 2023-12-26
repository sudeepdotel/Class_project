<%@ taglib prefix="c" uri=""%>
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
    <jsp:useBean id="students" scope="request" type="java.util.List"/>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.getStudentId}</td>
            <td>${student.getFirstName}</td>
            <td>${student.getLastName}</td>
            <td>${student.getAge}</td>
            <td>${student.getAddress}</td>
            <td>${student.getStudentDepartment}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
