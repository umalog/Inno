package ru.clubbreakfast.at_the_lecture.sept26.task08;

import java.util.*;

public class Journal {
  private Lesson lesson;
  private Set<Student> presentSet = new HashSet<>();
  private Set<Group> groups = new HashSet<>();

  public Set<Group> getGroups() {
    return groups;
  }

  public void setGroups(Set<Group> groups) {
    this.groups = groups;
  }

  public Journal(Lesson lesson, Set<Student> presentSet) {
    this.lesson = lesson;
    this.presentSet = presentSet;
  }

  public Lesson getLesson() {
    return lesson;
  }

  public void setLesson(Lesson lesson) {
    this.lesson = lesson;
  }

  public Set<Student> getPresentSet() {
    return presentSet;
  }

  public void setPresentSet(Set<Student> presentSet) {
    this.presentSet = presentSet;
  }
}
