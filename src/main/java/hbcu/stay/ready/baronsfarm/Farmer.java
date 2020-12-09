package hbcu.stay.ready.baronsfarm;

public class Farmer extends Person implements Botanist, Eater {

    public Farmer(String name) {
        super(name);
    }

    public CropRow plant(Crop crop) {
        return null;
    }

    public void makeNoise() {

    }
}
