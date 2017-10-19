package ru.clubbreakfast.at_the_lecture.patterns.proto;

public abstract class DestrictProto {
    int people;
    double money;

    public DestrictProto(DestrictProto target) {
        if (target != null) {
            this.people = target.people;
        }
    }

    public DestrictProto() {
    }

    public abstract DestrictProto clone();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DestrictProto)) return false;
        DestrictProto DestrictProto2 = (DestrictProto) o;
        return DestrictProto2.people == people;
    }


}
