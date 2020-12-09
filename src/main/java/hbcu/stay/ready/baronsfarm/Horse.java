package hbcu.stay.ready.baronsfarm;

public class Horse extends Animal implements Rideable{

    Horse(String name) {
        super(name);
    }

    public void mount(Rider rider) {

    }

    public Rider disMount() {
        return null;
    }

    @Override
    public void eat(Edible edible) {

    }

    @Override
    public void makeNoise() {

    }
}
