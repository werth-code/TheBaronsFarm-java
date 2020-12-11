package hbcu.stay.ready.baronsfarm;

public class KalePlant extends Crop {
    private Kale kale;

    public Kale getKale() {
        if(hasBeenFertilized) {
            Kale kale = new Kale();
            return kale;
        }
        return null;
    }

    @Override
    public String toString() {
        return "KalePlant";
    }
}
