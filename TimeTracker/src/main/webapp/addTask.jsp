<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Task</title>
</head>
<body>
    <h2>Add Task</h2>
    <form action="AddTaskServlet" method="post">
        <input type="hidden" name="employeeId" value="${sessionScope.user.userId}" />
        <label for="project">Project:</label>
        <input type="text" name="project" id="project" required><br>
        <label for="date">Date:</label>
        <input type="date" name="date" id="date" required><br>
        <label for="startTime">Start Time:</label>
        <input type="time" name="startTime" id="startTime" required><br>
        <label for="endTime">End Time:</label>
        <input type="time" name="endTime" id="endTime" required><br>
        <label for="duration">Duration (hours):</label>
        <input type="number" name="duration" id="duration" min="1" max="8" required><br>
        <label for="category">Category:</label>
        <input type="text" name="category" id="category" required><br>
        <label for="description">Description:</label>
        <textarea name="description" id="description" required></textarea><br>
        <button type="submit">Add Task</button>
    </form>
</body>
</html>
