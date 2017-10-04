package ru.clubbreakfast.at_the_lecture.sept29.xmls.MonitoringStudent;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name="Journal")
@XmlAccessorType(XmlAccessType.FIELD)
public class Journal implements Serializable {
    //@XmlSeeAlso(Lesson )
    @XmlElement(name = "Lekciya", required = true)
    private Lesson lesson;
    @XmlElement
    @XmlElementWrapper(name = "Students", required = true)
    private Set<Student> presentSet = new HashSet<>();
    @XmlElement
    @XmlElementWrapper(name = "Groups", required = true)
    private Set<Group> groups = new HashSet<>();

    public Journal(Lesson lesson) {
        this.lesson = lesson;
        this.presentSet = new HashSet<>();
        this.groups = new HashSet<>();
    }

    public Journal() {
    }

    public Lesson getLesson() {
        return lesson;
    }

    Set<Student> getPresentSet() {
        return presentSet;
    }

    private Set<Group> getGroups() {
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

    void addGroup(Group group) {
        groups.add(group);
    }
    void addPresentSet(Student student) {
        presentSet.add(student);
    }
}
