package ru.clubbreakfast.at_the_lecture.sept27.MonitoringStudent;

import java.io.*;
import java.util.Iterator;
import java.util.Set;

public class MySerializationAction {
    public static ObjectInputStream ois;

    static Journal readJournal (ObjectInputStream ois) throws IOException, ClassNotFoundException {
        Journal journal = (Journal) ois.readObject();
        return journal;
    }
    static Journal readJournal(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        return readJournal(ois);
    }

    static void serializeJournalAttendanceLesson(Journal journal) throws IOException {
        File file = new File("journal.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Iterator it = journal.getPresentSet().iterator();
        oos.writeObject(journal);
    }

    static void serializeJournalAttendance(Set<Journal> journals) throws IOException {
        int i = 0;
        Iterator it = journals.iterator();
        while (it.hasNext()) {
            i++;
            String nameFile = "journal" + i + ".txt";
            File file = new File(nameFile);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(it.next());
        }
       /* File file = new File("journals.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(journals);*/
    }

    static Group readGroup(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
        Group group = (Group) ois.readObject();
        return group;
    }

    static void serializeGroup(Group group) throws IOException {
        File file = new File("group.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(group);

    }
}
