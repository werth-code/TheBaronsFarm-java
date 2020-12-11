package hbcu.stay.ready.baronsfarm;

//// TODO: 12/10/20 we need to return if has been fertilized and then mark as has been harvested..

public class TomatoPlant extends Crop {
    private Tomato tomato;

    public Tomato getTomato() {
        if(hasBeenFertilized) {
            Tomato tomato = new Tomato();
            hasBeenHarvested = true;
            return tomato;
        }
        return null;
    }

    @Override
    public String toString() {
        return "TomatoPlant";
    }
}
