package hbcu.stay.ready.baronsfarm;

import java.util.Arrays;
import java.util.List;

public class FarmHouse {
    private List<Person> persons;

    FarmHouse(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }
}
