package hbcu.stay.ready.baronsfarm;

//// TODO: 12/9/20 this extends crop which has the yield method.. should return Edible of type Tomato
//// TODO: 12/10/20 Issue is we need to only return if it has been fertilized and then mark as has been harvested. 

public class TomatoPlant extends Crop {
    private Tomato tomato;

    public Tomato getTomato() {
            Tomato tomato = new Tomato();
            return tomato;
    }
}
