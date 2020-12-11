package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;

public class Baroness extends Person implements Pilot, Rider{
    public Baroness(String name) {
        super(name);
    }

    @Override
    public void rideAllHorses(ArrayList<Horse> horses, Rider rider) {
        for (Horse horse : horses) {
            horse.mount(rider);
            horse.disMount();
        }
    }

    @Override
    public void fertilize() {

    }
}
