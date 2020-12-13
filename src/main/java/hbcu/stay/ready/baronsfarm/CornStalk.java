package hbcu.stay.ready.baronsfarm;

public class CornStalk extends Crop implements Produce {

    public Corn getCorn() {
        if(hasBeenFertilized) {
            Corn corn = new Corn();
            hasBeenHarvested = true;
            return corn;
        }
        return null;
    }

    @Override
    public String toString() {
        return "CornStalk";
    }
}
