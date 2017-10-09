package ru.clubbreakfast.labs.lab02.dao;

import ru.clubbreakfast.labs.lab02.ConnectionManager;
import ru.clubbreakfast.labs.lab02.ConnectionManagerPostgreSQL;
import ru.clubbreakfast.labs.lab02.pojo.Employee;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDAO {
    public static class EmployeeDAOException extends Exception {
    }

    private static ConnectionManager manager;

    static {
        manager = ConnectionManagerPostgreSQL.getInstance();
    }


    public static Set<Employee> getAllEmployee(String name) throws EmployeeDAOException {
        Set<Employee> emp = new HashSet<>();
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement("SELECT * FROM umalog.public.employee WHERE company = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                emp.add(
                        new Employee(
                                resultSet.getInt("id"),
                                resultSet.getString("full_name"),
                                resultSet.getString("position"),
                                resultSet.getString("e_mail"),
                                resultSet.getInt("current_task"),
                                resultSet.getString("company")
                        )
                );
            }
            return emp;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new EmployeeDAOException();
        }
    }

    public static void insertAllEmployee(Set<Employee> emp) throws EmployeeDAOException {
        try {
            PreparedStatement statement = manager.getConnection().prepareStatement(
                    "INSERT INTO umalog.public.employee" +
                            "(id, full_name, position, e_mail, current_task, company)"
                            + "VALUES(?, ?, ?, ?, ?, ?)");
            for (Employee st : emp) {
                statement.setInt(1, st.getEmployeeID());
                statement.setString(2, st.getEmployeeName());
                statement.setString(3, st.getEmployeePosition());
                statement.setString(4, st.geteMail());
                statement.setInt(5, st.getCurrentTask());
                statement.setString(6, st.getCompany());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new EmployeeDAOException();
        }
    }

    @Deprecated
    public static void deleteAllEmployee() throws EmployeeDAOException{
        try {
            manager.getConnection().createStatement().execute("DELETE FROM umalog.public.employee");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new EmployeeDAOException();
        }
    }
}
