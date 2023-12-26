<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>To-Do List</title>
</head>
<body>
<h2>To-Do List</h2>

<form action="addTask" method="post">
    <label for="taskDate">Task Date:</label>
    <input type="date" id="taskDate" name="taskDate" required><br>

    <label for="taskName">Task Name:</label>
    <input type="text" id="taskName" name="taskName" required><br>

    <label for="taskDescription">Task Description:</label>
    <input type="text" id="taskDescription" name="taskDescription" required><br>

    <label for="taskDuration">Task Duration (in hours):</label>
    <input type="number" id="taskDuration" name="taskDuration" required><br>

    <input type="submit" value="Add Task">
</form>

<form action="getTasksByDate" method="get">
    <label for="searchDate">Search Tasks for Date:</label>
    <input type="date" id="searchDate" name="searchDate" required><br>

    <input type="submit" value="Search Tasks">
</form>
</body>
</html>
