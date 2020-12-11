package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.HashMap;

//// TODO: 12/9/20 this extends crop which has the yield method.. should return Edible of type EarCorn
public class CornStalk extends Crop implements Produce {

    public Corn getCorn() {
        Corn corn = new Corn();
        return corn;
    }
}
