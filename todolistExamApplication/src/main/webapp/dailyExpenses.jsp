<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Daily Expenses</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h2>Daily Expenses</h2>

<form action="addExpense" method="post">
    <label for="expenseName">Expense Name:</label>
    <input type="text" id="expenseName" name="expenseName" required><br>

    <label for="expenseDateTime">Expense Date and Time:</label>
    <input type="datetime-local" id="expenseDateTime" name="expenseDateTime" pattern="\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}"
           title="Enter date and time in the format YYYY-MM-DDThh:mm:ss" required>

    <label for="expensePurpose">Expense Purpose:</label>
    <input type="text" id="expensePurpose" name="expensePurpose" required><br>

    <label for="expenseAmount">Expense Amount:</label>
    <input type="number" id="expenseAmount" name="expensesAmount" required><br>

    <input type="submit" value="Add Expense">
</form>

<form action="generateExpenseReport" method="post">
    <label for="reportDate">Generate Expense Report for Date:</label>
    <input type="datetime-local" id="reportDate" name="reportDate" pattern="\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}"
    title="Enter date and time in the format YYYY-MM-DDThh:mm:ss" required><br>

    <input type="submit" value="Generate Expense Report">
</form>
</body>
</html>

