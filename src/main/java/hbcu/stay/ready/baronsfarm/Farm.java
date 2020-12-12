package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Farm {

    private String name;
    private FarmHouse farmHouse;
    private Stables stables;
    private ChickenCoop chickenCoop;
    private Field field;
    private List<FarmVehicle> farmVehicleShed;

    Farm(String name) {
        this.name = name;
    }

    Farm(String farmName, FarmHouse farmHouse, Stables stables, ChickenCoop chickenCoop, Field field) {
        this.name = farmName;
        this.farmHouse = farmHouse;
        this.stables = stables;
        this.chickenCoop = chickenCoop;
        this.field = field;
        farmVehicleShed = new ArrayList<>();
    }

    public void listStables() {
        HashMap<String, ArrayList<Horse>> stables = this.stables.getEachStable();
        for(Object horses : stables.entrySet()) {
            System.out.println(horses);
        }
    }

    public Stables getStables() {
        HashMap<String, ArrayList<Horse>> stables = this.stables.getEachStable();
        for(Object horses : stables.entrySet()) {
            return (Stables) horses;
        }
        return null;
    }

    public Horse getHorse(String name, ArrayList<Horse> horses) {
        for(Horse horse : horses) {
            if(horse.getName() == name) return horse;
            break;
        }
        return null;
    }

    public ArrayList<Crop> getCrops(String rowName) {
       return this.getFarmFields().getFields().get(rowName).getCropRow();
    }

    public List<FarmVehicle> getFarmVehicleShed() {
        return farmVehicleShed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FarmHouse getFarmHouse() {
        return farmHouse;
    }

    public Stables getAllFarmStables() {
        return stables;
    }

    public ChickenCoop getAllChickenCoops() {
        return chickenCoop;
    }

    public Field getFarmFields() {
        return field;
    }

}
