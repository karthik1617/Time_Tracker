package com.controller;

import com.dao.TaskDAO;
import com.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ViewTasksServlet")
public class ViewTasksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TaskDAO taskDAO;

    @Override
    public void init() {
        taskDAO = new TaskDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int employeeId = (int) request.getSession().getAttribute("employeeId");

        List<Task> tasks = taskDAO.getTasksByEmployeeId(employeeId);

        request.setAttribute("tasks", tasks);
        request.getRequestDispatcher("viewTasks.jsp").forward(request, response);
    }
}
