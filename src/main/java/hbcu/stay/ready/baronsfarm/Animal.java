package hbcu.stay.ready.baronsfarm;

public abstract class Animal implements Eater, NoiseMaker {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
