package hbcu.stay.ready.baronsfarm;

//// TODO: 12/9/20 this extends crop which has the yield method.. should return Edible of type EarCorn
public class CornStalk extends Crop {
    private Corn corn;

    CornStalk() {
        this.corn = new Corn();
    }

    public Corn getCorn() {
        return corn;
    }
}
