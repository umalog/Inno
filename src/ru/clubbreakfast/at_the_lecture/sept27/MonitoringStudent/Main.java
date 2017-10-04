package ru.clubbreakfast.at_the_lecture.sept27.MonitoringStudent;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        PrintFieldForReflection.printFieldForReflection(Journal.class);
    }

//    public static void main(String[] args) {
//        Set<Journal> journals = new HashSet<>();
//        Group group01 = new Group(1, "Группа доп. подготовки");
//        Group group02 = new Group(2, "6504");
//        Student s01 = new Student((short) 1, "Иван", "Иванович", "Иванов", Date.parse("1994/07/07"));
//        Student s02 = new Student((short) 2, "Петр", "Петрович", "Петров", Date.parse("1995/10/05"));
//        Student s03 = new Student((short) 3, "Сергей", "Сергеевич", "Сергеев", Date.parse("1995/07/09"));
//        Student s04 = new Student((short) 4, "Дарья", "Владимировна", "Косарева", Date.parse("1987/11/13"));
//        Student s05 = new Student((short) 5, "Вера", "Петровна", "Жигалова", Date.parse("2010/11/13"));
//        group01.addStudent(s01);
//        group01.addStudent(s02);
//        group01.addStudent(s03);
//        group01.addStudent(s04);
//        group01.addStudent(s05);
//
//        Lesson lesson01 = new Lesson(Date.parse("2017/09/21"), "Параметризованные типы", (short) 1, "Артем");
//        Lesson lesson02 = new Lesson(Date.parse("2017/09/22"), "Электродинамика", (short) 1, "Вадим");
//
//        Journal journal01 = new Journal(lesson01);
//        Journal journal02 = new Journal(lesson02);
//        journals.add(journal01);
//        journals.add(journal02);
//        journal01.addGroup(group01);
//        journal02.addGroup(group01);
//        journal01.addPresentSet(s01);
//        journal01.addPresentSet(s02);
//        journal01.addPresentSet(s04);
//        journal02.addPresentSet(s01);
//        journal02.addPresentSet(s02);
//        journal02.addPresentSet(s03);
//        journal02.addPresentSet(s05);
//
//        try {
//            MySerializationAction.serializeGroup(group01);
//            MySerializationAction.serializeJournalAttendanceLesson(journal01);
//            MySerializationAction.serializeJournalAttendance(journals);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        journalAttendanceLesson(journals, group01);
//        journalAttendanceStudent(s04, journals, group01);
//        journalAttendanceGroup( journals, group01);
//
//    }

    public static String journalAttendanceGroup(Set<Journal> journals, Group group) {
        try {
            System.out.println("Посещаемость группы '" + group.getGroupName() + "'");
            int kol_files = journals.size();
            for (int k = 1; k <= kol_files; k++) {
                Journal restoredJournal = MySerializationAction.readJournal("journal" + k + ".txt");
                //Journal restoredJournal = MySerializationAction.readJournal("journal.txt");
                String topic = restoredJournal.getLesson().getTopic();
                String data_les = String.format("%1$te/%1$tm/%1$tY", restoredJournal.getLesson().getDateTime());
                Iterator it_group = group.getStudents().iterator();

                while (it_group.hasNext()) {
                    Student stud = (Student) it_group.next();
                    int len_word = stud.toString().length();// =
                    int len_probel = 10 - len_word % 5;
                    String probel = " ";
                    for (int i = 0; i < len_probel; i++) {
                        probel = probel + " ";
                    }
                    String metka = "";
                    if (restoredJournal.getPresentSet().contains(stud)) {
                        metka = "был";
                    } else {
                        metka = "не был";
                    }
                    String string_line = stud + probel + topic + "      " + data_les + "     " + metka;
                    System.out.println(string_line);
                    return string_line;
                }
            }
            System.out.println("----------------------------------------------------------------------------------------");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void journalAttendanceLesson(Set<Journal> journals, Group group) {
        try {
            int kol_files = journals.size();
            for (int k = 1; k <= kol_files; k++) {
                Journal restoredJournal = MySerializationAction.readJournal("journal" + k + ".txt");
                //Journal restoredJournal = MySerializationAction.readJournal("journal.txt");
                String topic = restoredJournal.getLesson().getTopic();
                String data_les = String.format("%1$te/%1$tm/%1$tY", restoredJournal.getLesson().getDateTime());
                Iterator it_group = group.getStudents().iterator();
                System.out.println("Посещаемость лекции '" + topic + "'");
                while (it_group.hasNext()) {
                    Student stud = (Student) it_group.next();
                    int len_word = stud.toString().length();// =
                    int len_probel = 10 - len_word % 5;
                    String probel = " ";
                    for (int i = 0; i < len_probel; i++) {
                        probel = probel + " ";
                    }
                    String metka = "";
                    if (restoredJournal.getPresentSet().contains(stud)) {
                        metka = "был";
                    } else {
                        metka = "не был";
                    }
                    System.out.println(stud + probel + topic + "      " + data_les + "     " + metka);
                }
            }
            System.out.println("----------------------------------------------------------------------------------------");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void journalAttendanceStudent(Student student, Set<Journal> journals, Group group) {
        try {

            System.out.println("Посещаемость студента '" + student.toString() + "'");
            int kol_files = journals.size();
            for (int k = 1; k <= kol_files; k++) {
                Journal restoredJournal = MySerializationAction.readJournal("journal" + k + ".txt");
                String topic = restoredJournal.getLesson().getTopic();
                String data_les = String.format("%1$te/%1$tm/%1$tY", restoredJournal.getLesson().getDateTime());
                Iterator it_group = group.getStudents().iterator();

                while (it_group.hasNext()) {
                    Student stud = (Student) it_group.next();
                    if (stud.equals(student)) {
                        int len_word = stud.toString().length();// =
                        int len_probel = 10 - len_word % 5;
                        String probel = " ";
                        for (int i = 0; i < len_probel; i++) {
                            probel = probel + " ";
                        }
                        String metka = "";
                        if (restoredJournal.getPresentSet().contains(stud)) {
                            metka = "был   ";
                        } else {
                            metka = "не был";
                        }
                        System.out.println(stud + probel + topic + "      " + data_les + "     " + metka);
                    } else {
                    }


                }

            }
            System.out.println("----------------------------------------------------------------------------------------");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}


