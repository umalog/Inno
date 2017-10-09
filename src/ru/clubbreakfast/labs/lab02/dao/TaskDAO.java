package ru.clubbreakfast.labs.lab02.dao;

import ru.clubbreakfast.labs.lab02.ConnectionManager;
import ru.clubbreakfast.labs.lab02.ConnectionManagerPostgreSQL;
import ru.clubbreakfast.labs.lab02.pojo.Task;
import ru.clubbreakfast.labs.lab02.pojo.TaskStatus;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class TaskDAO {
    public static class TaskDAOException extends Exception {
    }

    private static ConnectionManager manager;

    static {
        manager = ConnectionManagerPostgreSQL.getInstance();
    }


    public static Set<Task> getAllTaskOfCompany(String name) throws TaskDAOException {
        Set<Task> tasks = new HashSet<>();
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement(
                    ("SELECT * FROM umalog.public.task WHERE company = ?"));
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task(
                        resultSet.getInt("id"),
                        resultSet.getString("task_name"),
                        resultSet.getString("description"),
                        resultSet.getInt("executor"),
                        resultSet.getInt("author"),
                        resultSet.getDate("start_date"),
                        resultSet.getDate("close_date"),
                        resultSet.getDate("deadline"),
                        TaskStatus.valueOf(resultSet.getString("status")),
                        resultSet.getString("company"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TaskDAOException();
        }
        return tasks;
    }

    public static void insertAll(Set<Task> tasks) throws TaskDAOException {
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement(
                    "INSERT INTO umalog.public.task" +
                            "(id, task_name, description, executor, author, start_date, close_date, deadline, status, company)"
                            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            for (Task task : tasks) {
                statement.setInt(1, task.getTaskID());
                statement.setString(2, task.getTaskName());
                statement.setString(3, task.getDescription());
                statement.setInt(4, task.getExecutor());
                statement.setInt(5, task.getAuthor());
                if (task.getWorkStartDate() != null)
                    statement.setDate(6, new Date(task.getWorkStartDate().getTime()));
                else statement.setDate(6, null);
                if (task.getClosingDate() != null)
                    statement.setDate(7, new Date(task.getClosingDate().getTime()));//!!!
                else statement.setDate(7, null);
                statement.setDate(8, new Date(task.getDeadline().getTime()));
                statement.setObject(9, task.getStatus().toString());
                statement.setString(10, task.getCompany());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new TaskDAOException();
        }
    }

    public static void udateTaskStatus(Task task) throws TaskDAOException {
        try {
            if (task.getClosingDate() == null) {
                PreparedStatement statement = manager.getConnection().prepareStatement
                        ("UPDATE umalog.public.task SET executor = ?, start_date = ? WHERE id = ?");
                statement.setInt(1, task.getExecutor());
                statement.setDate(2, new Date(task.getWorkStartDate().getTime()));
                statement.setInt(3, task.getTaskID());
                statement.executeUpdate();
            }else{
                PreparedStatement statement = manager.getConnection().prepareStatement
                        ("UPDATE umalog.public.task SET close_date = ? WHERE id = ?");
                statement.setDate(1, new Date(task.getClosingDate().getTime()));
                statement.setInt(2, task.getTaskID());
                statement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new TaskDAOException();
        }
    }

    public static void deleteAllTask() throws TaskDAOException {
        try {
            manager.getConnection().createStatement().execute("DELETE FROM umalog.public.task");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new TaskDAOException();
        }
    }
}
