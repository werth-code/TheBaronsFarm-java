package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.List;

public class Tractor implements FarmVehicle {
    private Boolean isOperating = false;

    public void operate(Farm farm) {
        System.out.println("...chug...chug...Vrooommmmmmmm... Tractor has been started on " + farm.getName());
        isOperating = true;
    }

    public List<Crop> harvest(ArrayList<Crop> crops) {
        if(!isOperating) {
            System.out.println("Turn On Tractor First.");
            return null;
        }
        ArrayList<Crop> harvestedCrops = new ArrayList<>();
        for(Crop crop : crops) {
            harvestedCrops.add(crop.yield());
        }
        return harvestedCrops;
    }

    public void turnOff() {
        System.out.println("Turned Off Tractor... Should Probably Change Oil Soon..");
        isOperating = false;
    }


}
