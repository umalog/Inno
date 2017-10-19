package ru.clubbreakfast.at_the_lecture.patterns.Composite;

import java.util.ArrayList;
import java.util.List;

public class Project {
Orders orders;

    public Project() {
    }

    void changeProduct(Product worker) {
    }

    void changeOrders(Orders manager) {
    }

    void changeDetails(Details vendor) {
    }

    double calculate(Orders ord) {
    return ord.calculateOrder();}
}
