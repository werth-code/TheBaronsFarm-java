package hbcu.stay.ready.baronsfarm;

public class Chicken extends Animal implements Produce{

    public Chicken(String name) {
        super(name);
    }

    public void eat(Edible edible) {

    }

    public void makeNoise() {

    }

    public Edible yield() {
        return null;
    }

    public Boolean hasBeenFertilized() {
        return null;
    }
}
