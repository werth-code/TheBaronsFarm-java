package hbcu.stay.ready.baronsfarm;

import java.util.*;

public class Field {
    private Map<String, CropRow> cropRows;

    Field(String name, CropRow cropRow) {
        this.cropRows = new HashMap<>();
        cropRows.put(name, cropRow);
    }

    public Map<String, CropRow> getField() {
        return cropRows;
    }

}