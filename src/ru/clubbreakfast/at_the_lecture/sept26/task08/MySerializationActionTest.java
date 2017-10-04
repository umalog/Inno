package ru.clubbreakfast.at_the_lecture.sept26.task08;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.HashSet;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class MySerializationActionTest {
    @Test
    void readJournal() throws IOException, ClassNotFoundException {
        ObjectInputStream mockStream = mock(ObjectInputStream.class);
        Group group01 = new Group(1, "Группа доп. подготовки");
        Student s01 = new Student((short) 1, "Иван", "Иванович", "Иванов", Date.parse("1995/07/07"));
        Student s02 = new Student((short) 2, "Петр", "Иванович", "Иванов", Date.parse("1995/07/07"));
        Student s03 = new Student((short) 3, "Сергей", "Иванович", "Иванов", Date.parse("1995/07/07"));
        group01.addStudent(s01);
        group01.addStudent(s02);
        group01.addStudent(s03);
        Lesson lesson01 = new Lesson(Date.parse("2017/09/21"), "Параметризованные типы", (short) 1, "Артем");
        when(mockStream.readUnshared()).thenReturn(new Journal(lesson01, group01.getStudents()));
        HashSet<Journal> journals = new HashSet<>();
        journals.add((Journal)mockStream.readObject());
       // String result = Main.someMethod();
       // assertEquals(result, "контрольный текст");
    }

}