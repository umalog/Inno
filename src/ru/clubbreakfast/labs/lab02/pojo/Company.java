package ru.clubbreakfast.labs.lab02.pojo;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Company {
    public String companyName;
    private int employeeIDCounter;
    private int taskIDCounter;

    Set<Employee> workers;
    Set<Task> allTask;

    public Company() {
    }

    public Company(String companyName) {
        this.companyName = companyName;
        employeeIDCounter = 0;
        taskIDCounter = 0;
        workers = new HashSet<>();
        allTask = new HashSet<>();
    }

    /* конструктор для БД */
    public Company(String companyName, int employeeIDCounter, int taskIDCounter, Set<Employee> workers, Set<Task> allTask) {
        this.companyName = companyName;
        this.employeeIDCounter = employeeIDCounter;
        this.taskIDCounter = taskIDCounter;
        this.workers = workers;
        this.allTask = allTask;
    }

    public void addWorkers(Employee worker) {
        this.workers.add(worker);
    }

    public void addTask(Task task) {
        this.allTask.add(task);
    }

    public int getEmployeeIDCounter() {
        employeeIDCounter = employeeIDCounter + 1;
        return employeeIDCounter;
    }

    public int getTaskIDCounter() {
        taskIDCounter = taskIDCounter + 1;
        return taskIDCounter;
    }

    public Set<Employee> getWorkers() {
        return workers;
    }

    public Set<Task> getAllTask() {
        return allTask;
    }

    public Employee getEmployer(int id) {
        for (Employee e : workers) {
            if (e.employeeID == id) return e;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Company{" +
                "employeeIDCounter=" + employeeIDCounter +
                ", taskIDCounter=" + taskIDCounter +
                ", workers=" + workers.size() +
                ", allTask=" + allTask.size() +
                '}';
    }
}
