package ru.clubbreakfast.at_the_lecture.patterns.Composite;

import ru.clubbreakfast.at_the_lecture.patterns.Composite.incObj.Manager;
import ru.clubbreakfast.at_the_lecture.patterns.Composite.incObj.Vendor;
import ru.clubbreakfast.at_the_lecture.patterns.Composite.incObj.Worker;

public class Composit {
    public static void main(String[] args) {
        Vendor Cisco = new Vendor("Cisco", 10000);
        Vendor Juniper = new Vendor("Juniper", 20000);
        Details a = new Details(Cisco);
        Details b = new Details(Juniper);

        Worker vasya = new Worker("vasya");
        Product router = new Product(vasya);
        router.details.add(a);
        router.details.add(b);

        Worker kolya = new Worker("kolya");
        Product commuttr = new Product(kolya);
        commuttr.details.add(a);

        Manager superMan = new Manager("superMan");
        Orders ordrs=new Orders(superMan);
        ordrs.products.add(router);
        ordrs.products.add(commuttr);

        Project ww = new Project();
        System.out.println(ww.calculate(ordrs));
    }
}
