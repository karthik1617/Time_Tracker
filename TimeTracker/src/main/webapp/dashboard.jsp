<%@ page import="com.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        out.println("No user found in session. Please login.");
    } else {
%>
    <h2>Welcome, <%= user.getUsername() %>!</h2>
    <p>Your role: <%= user.getRole() %></p>
    <a href="addTask.jsp">Add Task</a>
    
    <!-- Add links to task management and reporting functionalities -->
    <a href="login.jsp">Logout</a>
<%
    }
%>
</body>
</html>
