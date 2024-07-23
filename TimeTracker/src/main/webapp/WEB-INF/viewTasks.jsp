<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.model.Task" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Tasks</title>
</head>
<body>
    <h2>View Tasks</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Project</th>
                <th>Date</th>
                <th>Start Time</th>
                <th>End Time</th>
                <th>Duration</th>
                <th>Category</th>
                <th>Description</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% 
                // Retrieve the list of tasks from the request
                List<Task> tasks = (List<Task>) request.getAttribute("tasks");
                if (tasks != null) {
                    for (Task task : tasks) {
            %>
                <tr>
                    <td><%= task.getProject() %></td>
                    <td><%= task.getDate() %></td>
                    <td><%= task.getStartTime() %></td>
                    <td><%= task.getEndTime() %></td>
                    <td><%= task.getDuration() %></td>
                    <td><%= task.getCategory() %></td>
                    <td><%= task.getDescription() %></td>
                    <td>
                        <a href="editTaskForm?taskId=<%= task.getTaskId() %>">Edit</a>
                        <form action="deleteTask" method="post" style="display:inline;">
                            <input type="hidden" name="taskId" value="<%= task.getTaskId() %>">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            <% 
                    } 
                }
            %>
        </tbody>
    </table>
    <a href="addTaskForm.jsp">Add New Task</a>
</body>
</html>
