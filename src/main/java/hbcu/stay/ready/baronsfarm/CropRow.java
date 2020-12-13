package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;

public class CropRow {
    private ArrayList<Crop> cropRow;

    CropRow() {
        this.cropRow = new ArrayList<>();
    }

    public ArrayList<Crop> getCropRow() {
        return cropRow;
    }

    public void addCrop(Crop crop) {
        cropRow.add(crop);
    }

    @Override
    public String toString() {
        return "Crops" + cropRow;
    }
}

