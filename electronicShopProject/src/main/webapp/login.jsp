
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles1.css">
    <title>Login | Electronic Store</title>
</head>
<body>
<header>
    <h1>Login to Electronic Store</h1>
</header>

<nav>
    <ul>
        <li><a href="login.jsp">Login</a></li>
        <li><a href="registration.jsp">Sign Up</a></li>
    </ul>
</nav>

<section id="main-content">
    <h2>Login Form</h2>
    <form action="LoginServlet" method="post">
        <!-- Add login form fields here -->
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>

        <input type="submit" value="Login">
    </form>


</section>

<footer>
    <p>&copy; 2023 Electronic Store. All rights reserved.</p>
</footer>
</body>
</html>
