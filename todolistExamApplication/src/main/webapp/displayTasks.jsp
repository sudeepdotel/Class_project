<%@ page import="model.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tasks for Date</title>
</head>
<body>

<h2>Tasks for Date</h2>

<%-- Display tasks here --%>
<% for (Task task : (List<Task>) request.getAttribute("tasks")) { %>
<p><%= task.getTaskName() %></p>
<p><%= task.getTaskDate() %></p>
<p><%= task.getTaskDescription() %></p>
<p><%= task.getTaskDuration() %></p>
<hr>
<% } %>

</body>
</html>
