package hbcu.stay.ready.baronsfarm;

public class Chicken extends Animal implements Produce, NoiseMaker{

    public Chicken(String name) {
        super(name);
    }

    public Boolean hasBeenFertilized() {
        //if some function in botanist.. return true
        return false;
    }

    public void eat(Edible edible) {
    }

    public void makeNoise() {
        System.out.println("Cluck.. cluck..");
    }

    //Needs to return an Edible Egg...
    public Edible yield() {
        if(hasBeenFertilized()) {
            Egg egg = new Egg();
            return egg;
        }
        return null;
    }

}
