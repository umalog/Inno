package ru.clubbreakfast.at_the_lecture.patterns.proto;

public class Destrict extends DestrictProto{
    private int people;
    private double money;

    public Destrict() {
    }

    public Destrict(Destrict some) {
        super(some);
        if (some != null) {
            this.money = some.money;
        }
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

    @Override
    public DestrictProto clone() {
        return new Destrict(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Destrict) || !super.equals(object2)) return false;
        Destrict destrictProto2 = (Destrict) object2;
        return destrictProto2.money == money;
    }
}
