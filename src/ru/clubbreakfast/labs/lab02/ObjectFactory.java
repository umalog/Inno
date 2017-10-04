package ru.clubbreakfast.labs.lab02;


import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {


    public ObjectFactory() {
    }

    public Company createCompany() {
        return Company.getInstance();
    }

    public Employee createEmployee() {
        return new Employee();
    }

    public Task createTask() {
        return new Task();
    }


}
