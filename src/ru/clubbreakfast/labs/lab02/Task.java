package ru.clubbreakfast.labs.lab02;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;
import java.util.Date;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {

    @XmlTransient
    Company company;

    int taskID;

    String taskName;
    String description;
    TaskStatus status;

    int executor;
    int author;
    Date workStartDate;
    Date closingDate;
    Date deadline;

    /* Задача на конкретного исполнителя */
    public Task(String taskName, String description, Employee executor, Employee author, Date deadline, Company company) {
        this.company = company;
        this.taskID = company.getTaskIDCounter();
        this.status = TaskStatus.InWork;
        this.workStartDate = new Date();
        this.taskName = taskName;
        this.description = description;
        this.executor = executor.employeeID;
        this.author = author.employeeID;
        this.deadline = deadline;
        company.addTask(this);
        executor.currentTask=this.taskID;
    }

    /**
     * Задача без исполнителя
     * недостающие поля заполняются при  {@link Task#setExecutor}
     */
    public Task(String taskName, String description, Employee author, Date deadline, Company company) {
        this.company = company;
        taskID = company.getTaskIDCounter();
        this.status = TaskStatus.Paused;
        this.taskName = taskName;
        this.description = description;
        this.author = author.employeeID;
        this.deadline = deadline;
        company.addTask(this);
        company.getEmployer(this.author).assignedTask.add(this.taskID);
    }

    public Task() {
    }

    public void setExecutor(Employee executor) {
        this.executor = executor.employeeID;
        this.status = TaskStatus.InWork;
        this.workStartDate = new Date();
        executor.currentTask=this.taskID;
    }

    public void closeTask() {
        this.status = TaskStatus.Closed;
        this.closingDate = new Date();
        company.getEmployer(this.executor).currentTask = 0;
        company.getEmployer(this.executor).completedTask.add(this.taskID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return taskID == task.taskID;
    }

    @Override
    public int hashCode() {
        return taskID;
    }
}
