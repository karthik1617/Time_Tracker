package com.dao;

import com.model.Task;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public boolean addTask(Task task) {
        String query = "INSERT INTO Tasks (employee_id, project, date, start_time, end_time, duration, category, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, task.getEmployeeId());
            ps.setString(2, task.getProject());
            ps.setDate(3, task.getDate());
            ps.setTime(4, task.getStartTime());
            ps.setTime(5, task.getEndTime());
            ps.setInt(6, task.getDuration());
            ps.setString(7, task.getCategory());
            ps.setString(8, task.getDescription());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateTask(Task task) {
        String query = "UPDATE Tasks SET project = ?, date = ?, start_time = ?, end_time = ?, duration = ?, category = ?, description = ? WHERE task_id = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, task.getProject());
            ps.setDate(2, task.getDate());
            ps.setTime(3, task.getStartTime());
            ps.setTime(4, task.getEndTime());
            ps.setInt(5, task.getDuration());
            ps.setString(6, task.getCategory());
            ps.setString(7, task.getDescription());
            ps.setInt(8, task.getTaskId());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteTask(int taskId) {
        String query = "DELETE FROM Tasks WHERE task_id = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, taskId);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Task> getTasksByEmployeeId(int employeeId) {
        List<Task> tasks = new ArrayList<>();
        String query = "SELECT * FROM Tasks WHERE employee_id = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, employeeId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Task task = new Task();
                    task.setTaskId(rs.getInt("task_id"));
                    task.setEmployeeId(rs.getInt("employee_id"));
                    task.setProject(rs.getString("project"));
                    task.setDate(rs.getDate("date"));
                    task.setStartTime(rs.getTime("start_time"));
                    task.setEndTime(rs.getTime("end_time"));
                    task.setDuration(rs.getInt("duration"));
                    task.setCategory(rs.getString("category"));
                    task.setDescription(rs.getString("description"));
                    tasks.add(task);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public Task getTaskById(int taskId) {
        Task task = null;
        String query = "SELECT * FROM Tasks WHERE task_id = ?";
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, taskId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    task = new Task();
                    task.setTaskId(rs.getInt("task_id"));
                    task.setEmployeeId(rs.getInt("employee_id"));
                    task.setProject(rs.getString("project"));
                    task.setDate(rs.getDate("date"));
                    task.setStartTime(rs.getTime("start_time"));
                    task.setEndTime(rs.getTime("end_time"));
                    task.setDuration(rs.getInt("duration"));
                    task.setCategory(rs.getString("category"));
                    task.setDescription(rs.getString("description"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;
    }
}
