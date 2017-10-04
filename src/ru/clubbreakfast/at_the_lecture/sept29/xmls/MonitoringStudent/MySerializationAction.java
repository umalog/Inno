package ru.clubbreakfast.at_the_lecture.sept29.xmls.MonitoringStudent;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.lang.reflect.Field;
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

    static void serializeXML(Student student) throws Exception{
        //for(Field field:student.getClass().getDeclaredFields())
            //field.getName();


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();

        DOMImplementation implementation = documentBuilder.getDOMImplementation();
        Document document = implementation.createDocument(null, null, null);

        NodeList list = ((Node)document).getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node childNode = list.item(i);
            if (childNode instanceof Element){
                Element e = (Element) childNode;
            }

        }


            Element element = document.createElement("Student");

        //element.set(student.getFirstName()+" "+student.getFamilyName());
        document.appendChild(element);


        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result output = new StreamResult(new File("Student.XML"));
        Source source = new DOMSource(document);
        transformer.transform(source,output);

    }
}
