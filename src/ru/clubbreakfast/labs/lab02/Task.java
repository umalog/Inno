package ru.clubbreakfast.labs.lab02;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDate;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {

    int taskID;
    String taskName;
    String description;
    TaskStatus status;

    Employee executor;
    Employee author;
    LocalDate workStartDate;
    LocalDate closingDate;
    LocalDate deadline;

    /* Задача на конкретного исполнителя */
    public Task(String taskName, String description, Employee executor, Employee author, LocalDate deadline) {
        this.taskID = Company.getInstance().getTaskIDCounter();
        this.status = TaskStatus.InWork;
        this.workStartDate = LocalDate.now();
        this.taskName = taskName;
        this.description = description;
        this.executor = executor;
        this.author = author;
        this.deadline = deadline;
        Company.getInstance().addTask(this);
    }

    /** Задача без исполнителя
    * недостающие поля заполняются при  {@link Task#setExecutor} */
    public Task(String taskName, String description, Employee author, LocalDate deadline) {
        taskID = Company.getInstance().getTaskIDCounter();
        this.status = TaskStatus.Paused;
        this.taskName = taskName;
        this.description = description;
        this.author = author;
        this.deadline = deadline;
        Company.getInstance().addTask(this);
    }

    public Task() {
    }

    public void setExecutor(Employee executor) {
        this.executor = executor;
        this.status = TaskStatus.InWork;
        this.workStartDate = LocalDate.now();
        //обновление задачи
    }
}
