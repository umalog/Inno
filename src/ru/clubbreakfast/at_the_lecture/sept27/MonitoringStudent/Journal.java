package ru.clubbreakfast.at_the_lecture.sept27.MonitoringStudent;

import java.io.Serializable;
import java.util.*;

public class Journal implements Serializable {
    private Lesson lesson;
    private Set<Student> presentSet = new HashSet<>();
    private Set<Group> groups = new HashSet<>();

    public Journal(Lesson lesson) {
        this.lesson = lesson;
        this.presentSet = new HashSet<>();
        this.groups = new HashSet<>();
    }

    public Lesson getLesson() {
        return lesson;
    }

    public Set<Student> getPresentSet() {
        return presentSet;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public void setPresentSet(Set<Student> presentSet) {
        this.presentSet = presentSet;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }
    public void addPresentSet(Student student) {
        presentSet.add(student);
    }
}
