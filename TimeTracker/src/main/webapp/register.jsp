<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>Register</h2>
    <form action="RegisterServlet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <label for="role">Role:</label>
        <select id="role" name="role">
            <option value="Associate">Associate</option>
            <option value="Admin">Admin</option>
        </select><br>
        <button type="submit">Register</button>
        <a href="login.jsp">Login</a>
    </form>
</body>
</html>
