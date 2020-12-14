package hbcu.stay.ready.baronsfarm;

public class Chicken extends Animal implements Produce, NoiseMaker {

    public Chicken(String name) {
        super(name);
    }

    public Boolean hasBeenFertilized = false;

    public void canEat(Edible edible) {
        System.out.println("...cluck...cluck...yum... " + super.getName().toUpperCase() + " likes " + edible.toString());
    }

    public void makeNoise() {
        System.out.println("Cluck.. cluck..");
    }

    public Edible yield() {
        if(!hasBeenFertilized) {
            Egg egg = new Egg();
            return egg;
        }
        return null;
    }

}
