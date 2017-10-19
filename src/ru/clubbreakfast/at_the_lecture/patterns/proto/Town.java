package ru.clubbreakfast.at_the_lecture.patterns.proto;

public class Town {
    private int people;
    private double money;
    private double area;

    public Town(int people, double money, double area) {
        this.people = people;
        this.money = money;
        this.area = area;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
