package ru.clubbreakfast.labs.lab02.pojo;


import ru.clubbreakfast.labs.lab02.dao.CompanyDAO;
import ru.clubbreakfast.labs.lab02.dao.EmployeeDAO;
import ru.clubbreakfast.labs.lab02.dao.TaskDAO;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Date;

public class XMLFactory {

    public static void main(String[] args) throws EmployeeDAO.EmployeeDAOException, TaskDAO.TaskDAOException, CompanyDAO.CompanyDAOException {

        /* очистка SQL */
//        CompanyDAO.deleteAll();

        /* создание обьектов, сохранение в XML */
//        Company xmlCorp = new Company("xmlCorp");
//        Employee director = new Employee("Ivan Ivanovich", "Director", "test@inno.ru", xmlCorp);
//        Employee windowCleaner = new Employee("Vasya", "Window Cleaner", "work@inno.ru", xmlCorp);
//        Task bag = new Task("мыть окна", "все окна", windowCleaner, director, new Date(), xmlCorp);
//        Task alert = new Task("Бу!","I need help!",windowCleaner, new Date(),xmlCorp);
//        saveCompany(xmlCorp);

        /* из XML в SQL */
//        Company xmlCorp = loadCompany();
//        CompanyDAO.insertCompany(xmlCorp);

        /* из SQL в XML */
//        Company cmp = CompanyDAO.getByName("xmlCorp");
//        if (cmp != null) saveCompany(cmp);

        /* чтение из XML */
//        Company myCompany = loadCompany();




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
