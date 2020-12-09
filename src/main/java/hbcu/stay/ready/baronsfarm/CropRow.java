package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.List;

public class CropRow {
    private List<Crop> crops;

    CropRow(List<Crop> crops){
        this.crops = new ArrayList<>();
    }

    public List<Crop> getCrops() {
        return crops;
    }
}
