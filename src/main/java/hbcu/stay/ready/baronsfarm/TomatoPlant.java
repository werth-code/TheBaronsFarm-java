package hbcu.stay.ready.baronsfarm;

//// TODO: 12/9/20 this extends crop which has the yield method.. should return Edible of type Tomato

public class TomatoPlant extends Crop {
    private Tomato tomato;

    TomatoPlant(){
        this.tomato = new Tomato();
    }

    public Tomato getTomato() {
        return tomato;
    }

    public String getPlantName() {
        return "Tomato";
    }
}
