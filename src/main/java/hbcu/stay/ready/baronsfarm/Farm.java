package hbcu.stay.ready.baronsfarm;

import java.util.List;
import java.util.Map;

public class Farm {
    //// TODO: 12/9/20 Farm error, Baron needs to finish constructor.

    private List<Person> farmHouse;
    private List<Horse> stables;
    private List<Chicken> chickenCoop;
    private Map<Crop, CropRow> cropRows;
    private String name;

    Farm(String name) {
        this.name = name;
    }

    Farm(String name, List<Person> people, List<Horse> horses, List<Chicken> chickens, Field field, List<Crop> crops) {
        this.name = name;
        this.farmHouse = people; //new arraylist of these...
        this.stables = horses;
        this.chickenCoop = chickens;
        this.cropRows = (Map<Crop, CropRow>) new CropRow(crops).getCrops();
    }

}
