package ru.clubbreakfast.at_the_lecture.sept26.task08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {
    private static Group group;

    @BeforeAll
    static void setupGroup() {
        group = new Group(1, "testGroup");
    }

    @BeforeEach
    void clearStudents() {
        group.setStudents(new HashSet<Student>());

    }

    @Test
    void setStudents() {
        Student student1 = new Student((short) 1, "Ivan", "Ivanovoch", "Ivanov", new Date().getTime());
        Student student2 = new Student((short) 2, "Ivana", "Ivanovna", "Ivanova", new Date().getTime() + 1000);
        HashSet<Student> newStudents = new HashSet<>();
        newStudents.add(student1);
        newStudents.add(student2);
        group.setStudents(newStudents);

        assertEquals(newStudents.size(), group.getStudents().size());
        assertTrue(newStudents.equals(group.getStudents()));


    }

    @Test
    void addStudent() {
        Student student = new Student((short) 1, "Ivan", "Ivanovoch", "Ivanov", new Date().getTime());
        group.addStudent(student);
        assertEquals(1, group.getStudents().size());
        Student getStud = (Student) group.getStudents().toArray()[0];
        assertEquals(student.getNum(), getStud.getNum());
        assertEquals(student.getBdate(), getStud.getBdate());
        assertTrue(student.getFamilyName().equals(getStud.getFamilyName()));
        assertTrue(student.getFirstName().equals(getStud.getFirstName()));
        assertEquals(student.getSecondName(), getStud.getSecondName());

    }

    @Test
    void removeStudent() {
        Student student1 = new Student((short) 1, "Ivan", "Ivanovoch", "Ivanov", new Date().getTime());
        Student student2 = new Student((short) 2, "Ivana", "Ivanovna", "Ivanova", new Date().getTime() + 1000);
        HashSet<Student> newStudents = new HashSet<>();
        newStudents.add(student1);
        newStudents.add(student2);
        group.setStudents(newStudents);
        group.removeStudent(student1);
        assertEquals(group.getStudents().size(),1);
        assertEquals(group.getStudents().toArray()[0], student2);

    }

}