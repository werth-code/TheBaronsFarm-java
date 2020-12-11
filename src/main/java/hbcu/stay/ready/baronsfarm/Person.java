package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;

public class Person extends Animal implements Eater, NoiseMaker {
    public Person(String name) {
        super(name);
    }

    public void canEat(Edible edible) {
        System.out.println(super.getName() + "...MMM good " + edible);
    }

    public void makeNoise() {
    }

    @Override
    public String toString() {
        return super.getName();
    }

}
