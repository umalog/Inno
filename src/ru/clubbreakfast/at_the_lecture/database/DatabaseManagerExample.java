package ru.clubbreakfast.at_the_lecture.database;

import ru.clubbreakfast.at_the_lecture.sept26.task08.Student;

import java.sql.*;

public class DatabaseManagerExample {
public static void showStudents() throws ClassNotFoundException {
    Class.forName("org.postgresql.Driver");
    Connection connection;
    try{ connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/students", "postgres", "");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
        while (resultSet.next()){
            Student student= new Student(
                    (short) resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("second_name"),
                    resultSet.getString("last_name"),
                    resultSet.getDate("birth_date").toLocalDate());
            System.out.println(student.toString());
        }


    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
