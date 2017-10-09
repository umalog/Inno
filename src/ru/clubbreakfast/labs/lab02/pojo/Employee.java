package ru.clubbreakfast.labs.lab02.pojo;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class Employee {
    @XmlElement(required = true)
    String company;
    @XmlElement(required = true)
    int employeeID;
    @XmlElement(required = true)
    String employeeName;
    @XmlElement(required = true)
    String employeePosition;
    @XmlElement(required = true)
    String eMail;

    @XmlElement(name = "taskInWork")
    int currentTask;


    public Employee(String employeeName, String employeePosition, String eMail, Company company) {
        this.company = company.companyName;
        employeeID = company.getEmployeeIDCounter();
        this.employeeName = employeeName;
        this.employeePosition = employeePosition;
        this.eMail = eMail;
        company.addWorkers(this);
    }

    public Employee() {
    }
    /* конструктор для БД */
    public Employee(int employeeID, String employeeName, String employeePosition, String eMail, int currentTask, String company) {
        this.company = company;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeePosition = employeePosition;
        this.eMail = eMail;
        this.currentTask = currentTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return employeeID == employee.employeeID;
    }

    @Override
    public int hashCode() {
        return employeeID;
    }

    public String getCompany() {
        return company;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public String geteMail() {
        return eMail;
    }

    public int getCurrentTask() {
        return currentTask;
    }
}
