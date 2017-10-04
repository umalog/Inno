package ru.clubbreakfast.labs.lab02;

import javax.xml.bind.annotation.*;
import java.util.Set;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Company", propOrder = {
        "employeeIDCounter",
        "taskIDCounter",
        "workers",
        "allTask"
})
@XmlRootElement
public class Company {
    private static Company ourInstance = new Company();

    public static Company getInstance() {
        return ourInstance;
    }

    public Company() {
    }

    private int employeeIDCounter = 0;
    private int taskIDCounter = 0;

    Set<Employee> workers;
    Set<Task> allTask;

    public void addWorkers(Employee worker) {
        this.workers.add(worker);
    }

    public void addTask(Task task) {
        this.allTask.add(task);
    }

    public int getEmployeeIDCounter() {
        employeeIDCounter = employeeIDCounter+1;
        return employeeIDCounter;
    }

    public int getTaskIDCounter() {
        taskIDCounter = taskIDCounter+1;
        return taskIDCounter;
    }
}
