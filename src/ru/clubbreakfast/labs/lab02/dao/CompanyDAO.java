package ru.clubbreakfast.labs.lab02.dao;

import ru.clubbreakfast.labs.lab02.ConnectionManager;
import ru.clubbreakfast.labs.lab02.ConnectionManagerPostgreSQL;
import ru.clubbreakfast.labs.lab02.pojo.Company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDAO {
    public static class CompanyDAOException extends Exception {
    }

    private static ConnectionManager manager;

    static {
        manager = ConnectionManagerPostgreSQL.getInstance();
    }


    /* getAll() заменить на джойн ? */
    public static Company getByName(String name) throws CompanyDAOException, TaskDAO.TaskDAOException, EmployeeDAO.EmployeeDAOException {
        Company com = null;
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement
                    ("SELECT * FROM umalog.public.companies WHERE name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // String companyName, int employeeIDCounter, int taskIDCounter, Set<Employee> workers, Set<Task> allTask
                com = new Company(
                        resultSet.getString("name"),
                        resultSet.getInt("employee_count"),
                        resultSet.getInt("task_count"),

                        EmployeeDAO.getAllEmployee(name),
                        TaskDAO.getAllTaskOfCompany(name)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CompanyDAOException();
        }
        return com;
    }

    public static void deleteAll() throws CompanyDAOException, EmployeeDAO.EmployeeDAOException, TaskDAO.TaskDAOException {
        try {
            TaskDAO.deleteAllTask();
            EmployeeDAO.deleteAllEmployee();
            //  ON DELETE CASCADE
            manager.getConnection().createStatement().execute
                    ("DELETE FROM umalog.public.companies");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new CompanyDAOException();
        }


    }

    public static void insertCompany(Company company) throws CompanyDAOException, TaskDAO.TaskDAOException, EmployeeDAO.EmployeeDAOException {
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement(
                    "INSERT INTO umalog.public.companies" +
                            "(name, employee_count, task_count) VALUES(?, ?, ?)");
            statement.setString(1, company.companyName);
            statement.setInt(2, company.getEmployeeIDCounter());
            statement.setInt(3, company.getTaskIDCounter());
            statement.executeUpdate();
            EmployeeDAO.insertAllEmployee(company.getWorkers());
            TaskDAO.insertAll(company.getAllTask());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CompanyDAOException();
        }

    }
}
