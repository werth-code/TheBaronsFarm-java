package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.HashMap;

public class Stables {
    private HashMap<String, ArrayList<Horse>> stable;

    Stables(String name, ArrayList<Horse> horses) {
        this.stable = new HashMap<>();
        stable.put(name, horses);
    }

    public HashMap<String, ArrayList<Horse>> getEachStable() {
        return stable;
    }
}
