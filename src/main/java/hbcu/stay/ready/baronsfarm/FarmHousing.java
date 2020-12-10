package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.HashMap;

public class FarmHousing <T>{
    private HashMap<String, ArrayList<T>> stored;

    FarmHousing(String name, ArrayList<T> toStore) {
        this.stored = new HashMap<>();
        stored.put(name, toStore);
    }

    public HashMap<String, ArrayList<T>> getStored() {
        return stored;
    }
}
