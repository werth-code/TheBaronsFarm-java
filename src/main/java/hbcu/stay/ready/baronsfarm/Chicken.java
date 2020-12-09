package hbcu.stay.ready.baronsfarm;

public class Chicken extends Animal implements Produce{

    public Chicken(String name) {
        super(name);
    }

    public Boolean hasBeenFertilized() {
        return null;
    }

    public void eat(Edible edible) {
    }

    public void makeNoise() {
    }

    //Needs to return an Edible Egg...
    public Edible yield() {
        return null;
    }

}
