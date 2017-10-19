package ru.clubbreakfast.at_the_lecture.patterns.Composite;

import ru.clubbreakfast.at_the_lecture.patterns.Composite.incObj.Vendor;

public class Details {
    Vendor vendor;
    double price;

    public Details(Vendor vendor) {
        this.vendor = vendor;
        this.price = vendor.price + 10000;
    }
}
