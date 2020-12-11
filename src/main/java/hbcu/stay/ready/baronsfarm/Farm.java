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

    public void setFarmHouse(FarmHouse farmHouse) {
        this.farmHouse = farmHouse;
    }

    public Stables getStables() {
        return stables;
    }

    public void setStables(Stables stables) {
        this.stables = stables;
    }

    public ChickenCoop getChickenCoop() {
        return chickenCoop;
    }

    public void setChickenCoop(ChickenCoop chickenCoop) {
        this.chickenCoop = chickenCoop;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
