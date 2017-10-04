package ru.clubbreakfast.at_the_lecture.sept29.xmls.MonitoringStudent;

import java.io.Serializable;

public class Student implements Serializable {
    private short num;
    private String firstName;
    private String secondName;
    private String familyName;
    private final long bdate;

    public Student(short num, String fName, String sName, String familyName, long bdate) {
        this.num = num;
        this.firstName = fName;
        this.secondName = sName;
        this.familyName = familyName;
        this.bdate = bdate;
    }

    public short getNum() {
        return num;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public long getBdate() {
        return bdate;
    }

    public void setNum(short num) {
        this.num = num;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public String toString() {
        //return super.toString();
        return this.familyName + " " + this.firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        return getBdate() == student.getBdate();
    }

    @Override
    public int hashCode() {
        return (int) (getBdate() ^ (getBdate() >>> 32));
    }
}
