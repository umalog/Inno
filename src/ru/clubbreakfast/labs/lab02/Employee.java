package ru.clubbreakfast.labs.lab02;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    int employeeID;
    String employeeName;
    Position enployeePosition;
    String eMail;

    @XmlElement
    Task currentTask;

    @XmlElement
    @XmlElementWrapper(name = "Competed")
    List<Task> completedTask;

    @XmlElement
    @XmlElementWrapper(name = "Assigned")
    List<Task> assignedTask;


    public Employee(String employeeName, Position enployeePosition, String eMail) {
        employeeID = Company.getInstance().getEmployeeIDCounter();
        this.employeeName = employeeName;
        this.enployeePosition = enployeePosition;
        this.eMail = eMail;
        Company.getInstance().addWorkers(this);
    }

    public Employee() {
    }
}
