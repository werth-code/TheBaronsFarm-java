package hbcu.stay.ready.baronsfarm;

import java.util.List;

public class Crop implements Produce {
    public Boolean hasBeenFertilized = false;
    public Boolean hasBeenHarvested = false;
    public List<Edible> edibleList;

    public Edible yield() {
        if(hasBeenFertilized) {
            Crop crop = new Crop();
            hasBeenHarvested = true;
            edibleList.add((Edible) crop);
            return (Edible) crop;
        }
        return null;
    }

    public List<Edible> getEdibleList() {
        return edibleList;
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
