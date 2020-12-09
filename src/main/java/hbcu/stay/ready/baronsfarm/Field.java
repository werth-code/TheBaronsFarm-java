package hbcu.stay.ready.baronsfarm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: 12/9/20 This should only be accessable to a farmer who is a botanist...

public class Field {
    private Map<Crop, CropRow> cropRows;

    Field(Crop name, List<Crop> crops){
        fillField(name, crops);
    }

    //// TODO: 12/9/20 Just want to get the right name from the crop to make it the key for k/v pair...
    public void fillField(Crop name, List<Crop> crops) {
        cropRows = new HashMap<Crop, CropRow>();
        CropRow cropRow = new CropRow(crops);
        Arrays.asList(crops).forEach(crop -> cropRows.put(name, (CropRow) cropRow.getCrops()));
    }

    public Map<Crop, CropRow> getCropRows() {
        return cropRows;
    }
}

//// TODO: 12/9/20 a = new Field, a.getCropRows.
