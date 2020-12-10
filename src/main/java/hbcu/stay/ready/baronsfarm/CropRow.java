package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;

public class CropRow {
    private ArrayList<CropRow> cropRows;

    CropRow(ArrayList<Crop> crop) {
        this.cropRows = new ArrayList<>();
    }

    public ArrayList<CropRow> getCropRow() {
        return cropRows;
    }
}
