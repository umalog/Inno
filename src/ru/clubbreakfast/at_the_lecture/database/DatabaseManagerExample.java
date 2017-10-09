package ru.clubbreakfast.at_the_lecture.database;

import ru.clubbreakfast.at_the_lecture.sept26.task08.Student;

import java.sql.*;

public class DatabaseManagerExample {
    public static void main(String[] args) throws ClassNotFoundException {
        saveStudent(new Student((short) 0, "Анна", "Мария", "Дарк", System.currentTimeMillis()));
        showStudents();
    }

    public static void showStudents()
            throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/students", "postgres", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
            while (resultSet.next()) {
                Student student = new Student((short) resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("second_name"), resultSet.getString("last_name"), resultSet.getDate("birth_date").getTime());
                System.out.println(student.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void saveStudent(Student student) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/students", "postgres", "");

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO student(first_name, second_name, last_name, birth_date, group_id)" + "VALUES(?, ?, ?, ?, ?)");

            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getSecondName());
            statement.setString(3, student.getFamilyName());
            statement.setDate(4, new Date(student.getBdate()));
            statement.setInt(5, 2);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
