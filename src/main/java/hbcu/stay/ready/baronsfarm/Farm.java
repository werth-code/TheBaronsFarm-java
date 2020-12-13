package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.List;

public class Farm {

    private String name;
    private FarmHouse farmHouse;
    private Stables stables;
    private ChickenCoop chickenCoop;
    private Field field;
    private List<FarmVehicle> farmVehicleShed;

    Farm(){};

    Farm(String farmName, FarmHouse farmHouse, Stables stables, ChickenCoop chickenCoop, Field field) {
        this.name = farmName;
        this.farmHouse = farmHouse;
        this.stables = stables;
        this.chickenCoop = chickenCoop;
        this.field = field;
        farmVehicleShed = new ArrayList<>();
    }

    public CropRow getCropRow(String rowName) {
       return this.getFarmFields().getField().get(rowName);
    }

    public ArrayList<Crop> getCrops(String rowName) {
       return this.getFarmFields().getField().get(rowName).getCropRow();
    }

    public ArrayList<Chicken> getChickenCoop(String coopName) {
        return this.getAllChickenCoops().getCoop().get(coopName);
    }

    public ArrayList<Horse> getStable(String stableName) {
        return this.getAllFarmStables().getEachStable().get(stableName);
    }

    public Person getPerson(String name){
        List<Person> getIndex = this.getFarmHouse().getPersons();
        for(Person person : getIndex) {
            if(person.getName() == name) return person;
        }
       return null;
    }

    public Field getFarmFields() {
        return field;
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

}
