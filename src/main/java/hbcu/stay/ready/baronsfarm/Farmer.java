package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.List;

public class Farmer extends Person implements Botanist, Eater, Rider {

    public Farmer(String name) {
        super(name);
    }

    @Override
    public CropRow plant(Crop crop) {
        List<Crop> cropRow = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            cropRow.add(crop);
        }
        return null;
    }

    public CropRow plant(Crop crop, ArrayList<Crop> cropRow) {
        for (int i = 0; i < 20; i++) {
            cropRow.add(crop);
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

    public Chicken getChicken(String name, ArrayList<Chicken> chickens) {
        for(Chicken chicken : chickens) {
            if(chicken.getName() == name) return chicken;
            break;
        }
        return null;
    }

    public void addRooster(Chicken chicken) {
        chicken.hasBeenFertilized = true;
    }

    public void feedHorses (ArrayList<Horse> horses) {
        for (Horse horse : horses) {
            horse.canEat(new Corn());
            horse.canEat(new Corn());
            horse.canEat(new Corn());
        }
    }

    @Override
    public void rideAllHorses(ArrayList<Horse> horses, Rider rider) {
        for (Horse horse : horses) {
            horse.mount(rider);
            horse.disMount();
        }
    }

    public void makeNoise() {
        System.out.println("...YeeeeHaawwwwwww...");
    }

}
