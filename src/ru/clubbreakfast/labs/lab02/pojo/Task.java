package ru.clubbreakfast.labs.lab02.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {

    String company;

    int taskID;

    String taskName;
    String description;
    TaskStatus status;

    int executor;
    int author;
    Date workStartDate;
    Date closingDate;
    Date deadline;

    /* конструктор для БД */
    public Task(int id, String taskName, String description, int executor, int author,
                Date startDate ,Date closingDate, Date deadline, TaskStatus status, String company){
        this.taskID=id;
        this.taskName=taskName;
        this.description=description;
        this.executor = executor;
        this.author=author;
        if (startDate!=null) this.workStartDate=startDate;
        if (closingDate!=null) this.closingDate=closingDate;
        this.deadline=deadline;
        this.status=status;
this.company=company;


    }




    /* Задача на конкретного исполнителя */
    public Task(String taskName, String description, Employee executor, Employee author, Date deadline, Company company) {
        this.company = company.companyName;
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
        this.company = company.companyName;
        taskID = company.getTaskIDCounter();
        this.status = TaskStatus.Paused;
        this.taskName = taskName;
        this.description = description;
        this.author = author.employeeID;
        this.deadline = deadline;
        company.addTask(this);
    }

    public Task() {
    }

    public void setExecutor(Employee executor) {
        this.executor = executor.employeeID;
        this.status = TaskStatus.InWork;
        this.workStartDate = new Date();
        executor.currentTask=this.taskID;
    }

    public String getCompany() {
        return company;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getExecutor() {
        return executor;
    }

    public int getAuthor() {
        return author;
    }

    public Date getWorkStartDate() {
        return workStartDate;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public Date getDeadline() {
        return deadline;
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
