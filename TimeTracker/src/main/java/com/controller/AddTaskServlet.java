package com.controller;

import com.dao.TaskDAO;
import com.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskDAO taskDAO;

    @Override
    public void init() {
        taskDAO = new TaskDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String project = request.getParameter("project");
        Date date = Date.valueOf(request.getParameter("date"));
        Time startTime = Time.valueOf(request.getParameter("startTime"));
        Time endTime = Time.valueOf(request.getParameter("endTime"));
        int duration = Integer.parseInt(request.getParameter("duration"));
        String category = request.getParameter("category");
        String description = request.getParameter("description");

        Task task = new Task();
        task.setEmployeeId(employeeId);
        task.setProject(project);
        task.setDate(date);
        task.setStartTime(startTime);
        task.setEndTime(endTime);
        task.setDuration(duration);
        task.setCategory(category);
        task.setDescription(description);

        taskDAO.addTask(task);

        response.sendRedirect("ViewTasksServlet");
    }
}
