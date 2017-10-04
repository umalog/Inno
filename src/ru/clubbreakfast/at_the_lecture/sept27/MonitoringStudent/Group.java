package ru.clubbreakfast.at_the_lecture.sept27.MonitoringStudent;

import java.io.Serializable;
import java.util.*;

public class Group implements Serializable {
    private final int groupNum;
    private final String groupName;
    private Set<Student> students = new HashSet<>();

    public Group(int groupNum, String gName) {
        this.groupNum = groupNum;
        this.groupName = gName;
        this.students = new HashSet<>();
    }

    public int getGroupNum() {
        return groupNum;
    }

    public String getGroupName() {
        return groupName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group)) return false;

        Group group = (Group) o;

        if (getGroupNum() != group.getGroupNum()) return false;
        return getGroupName().equals(group.getGroupName());
    }

    @Override
    public int hashCode() {
        int result = getGroupNum();
        result = 31 * result + getGroupName().hashCode();
        return result;
    }
}
