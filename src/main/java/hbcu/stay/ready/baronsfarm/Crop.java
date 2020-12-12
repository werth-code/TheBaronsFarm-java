package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.List;

public class Crop implements Produce {
    public Boolean hasBeenFertilized = false;
    public Boolean hasBeenHarvested = false;


    public Crop yield() {
        if(hasBeenFertilized) {
            Crop crop;
            if(this.getClass().equals(CornStalk.class)) crop = new Corn();
            else if(this.getClass().equals(TomatoPlant.class)) crop = new Tomato();
            else crop = new Kale();
            hasBeenHarvested = true;
            System.out.println(crop.toString());
            return crop;
        }
        return null;
    }


    public Boolean getHasBeenFertilized() {
        return hasBeenFertilized;
    }

    public void setHasBeenFertilized(Boolean hasBeenFertilized) {
        this.hasBeenFertilized = hasBeenFertilized;
    }

    public Boolean getHasBeenHarvested() {
        return hasBeenHarvested;
    }

    public void setHasBeenHarvested(Boolean hasBeenHarvested) {
        this.hasBeenHarvested = hasBeenHarvested;
    }
}
