package ru.clubbreakfast.labs.lab02;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class Employee {
    Company company;
    @XmlElement(required = true)
    int employeeID;
    @XmlElement(required = true)
    String employeeName;
    @XmlElement(required = true)
    Position enployeePosition;
    @XmlElement(required = true)
    String eMail;

    @XmlElement(name = "taskInWork")
    int currentTask;

    @XmlElement
    @XmlElementWrapper(name = "Competed")
    List<Integer> completedTask;

    @XmlElement
    @XmlElementWrapper(name = "Assigned")
    List<Integer> assignedTask;


    public Employee(String employeeName, Position enployeePosition, String eMail, Company company) {
        this.company = company;
        employeeID = company.getEmployeeIDCounter();
        this.employeeName = employeeName;
        this.enployeePosition = enployeePosition;
        this.eMail = eMail;
        company.addWorkers(this);
    }

    public Employee() {
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
}
