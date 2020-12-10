package hbcu.stay.ready.baronsfarm;

import java.util.*;

public class Field {
    private Map<String, CropRow> cropRows;

    Field(String name, CropRow cropRow) {
        this.cropRows = new HashMap<>();
        cropRows.put(name, cropRow);
    }

    public Map<String, CropRow> getCropContainer() {
        return cropRows;
    }
//    Field(Crop name, List<Crop> crops){
//        fillField(name, crops);
//    }


//    public void fillField(Crop name, List<Crop> crops) {
//        cropRows = new HashMap<Crop, CropRow>();
//        CropRow cropRow = new CropRow(crops);
//        Arrays.asList(crops).forEach(crop -> cropRows.put(name, (CropRow) cropRow.getCrops()));
//    }

}