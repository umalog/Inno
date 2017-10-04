package ru.clubbreakfast.at_the_lecture.sept26.task08;

import java.io.*;

public class MySerializationAction {

    public static ObjectInputStream ois;

    static Journal readJournal (ObjectInputStream ois) throws IOException, ClassNotFoundException {
        Journal journal = (Journal)ois.readObject();
        return  journal;
    }

    static Group readGroup(String fileName) throws IOException,
            ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fileName)
        );
        Group group = (Group) ois.readObject();
        return group;
    }

    static void serializeGroup(Group group) throws IOException {
        File file = new File("group.txt");
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file)
        );
        oos.writeObject(group);

    }
}
