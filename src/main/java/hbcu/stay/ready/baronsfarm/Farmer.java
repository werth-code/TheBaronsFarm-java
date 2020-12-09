package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.List;

public class Farmer extends Person implements Botanist, Eater {

    public Farmer(String name) {
        super(name);
    }

    public CropRow plant(Crop crop) {
        List<Crop> cropRow = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cropRow.add(crop);
        }

        return null;
    }

    public void makeNoise() {

    }
}
