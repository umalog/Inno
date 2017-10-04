package ru.clubbreakfast.labs.lab02;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;

public class ObjectFactory {

    public static void main(String[] args) {

//        Company xmlCorp = new Company();
//        Employee director = new Employee("Ivan Ivanovich", Position.Director, "test@inno.ru", xmlCorp);
//        Task bag = new Task("мыть окна", "все окна", director, director, new Date(), xmlCorp);
//        //bag.closeTask();
//        saveCompany(xmlCorp);

        loadCompany();
    }


    private static void saveCompany(Company company) {
        try {
            File file = new File("/Users/umalog/IdeaProjects/Inno/src/ru/clubbreakfast/labs/lab02/file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(company, file);
            jaxbMarshaller.marshal(company, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    private static Company loadCompany() {
        try {
            File file = new File("/Users/umalog/IdeaProjects/Inno/src/ru/clubbreakfast/labs/lab02/file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Company company = (Company) jaxbUnmarshaller.unmarshal(file);
            System.out.println(company);
            return company;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
