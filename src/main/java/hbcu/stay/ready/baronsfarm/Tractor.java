package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.List;

public class Tractor implements FarmVehicle {
    private Boolean isOperating = false;

    public void operate(Farm farm) {
        if(!isOperating) {
            System.out.println("...chug...chug...Vrooommmmmmmm... Tractor has been started on " + farm.getName());
            isOperating = true;
        }
        else System.out.println("You Are Using The Tractor... Are You Okay!?");
    }

    public List<Crop> harvest(ArrayList<Crop> crops) {
        if(isOperating == false) {
            System.out.println("Turn On Tractor First.");
            return null;
        }
        ArrayList<Crop> harvestedCrops = new ArrayList<>();
        for(Crop crop : crops) {
            harvestedCrops.add(crop.yield());
        }
        System.out.println("Harvesting... Vegetables" + harvestedCrops.toString());
        return harvestedCrops;
    }

    public void turnOff() {
        if(isOperating) {
            System.out.println("Turned Off Tractor... Should Probably Change Oil Soon..");
            isOperating = false;
        }
        else System.out.println("It's Already Off.. Do You Need More Coffee?");
    }


}
