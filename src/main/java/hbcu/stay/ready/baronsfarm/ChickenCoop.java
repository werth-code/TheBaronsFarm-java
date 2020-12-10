package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.HashMap;

public class ChickenCoop {
    private HashMap<String, ArrayList<Chicken>> coop;

    ChickenCoop(String name, ArrayList<Chicken> chickens) {
        this.coop = new HashMap<>();
        coop.put(name, chickens);
    }

    public HashMap<String, ArrayList<Chicken>> getCoop() {
        return coop;
    }
}
