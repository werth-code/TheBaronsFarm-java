package hbcu.stay.ready.baronsfarm;

public class Horse extends Animal implements Rideable {
    private Boolean isBeingRidden = false;
    private Rider currentRider;

    Horse(String name) {
        super(name);
    }

    public void mount(Rider rider) {
        if(!isBeingRidden) {
            System.out.println(rider + " has mounted " + super.getName().toUpperCase() + " our faithful and trusty horse!");
            makeNoise();
            currentRider = rider;
            isBeingRidden = true;
        }
        else System.out.println(super.getName() + " ...is already out...");
    }

    public Rider disMount() {
        if(isBeingRidden) {
            System.out.println(currentRider + " ..has returned.. " + super.getName());
            isBeingRidden = false;
            return currentRider;
        }
        else System.out.println(super.getName() + " ..is available to ride..");
        return null;
    }


    @Override
    public void eat(Edible edible) {
        System.out.println(super.getName().toUpperCase() +  "...chomp...crunch...num... likes " + edible.getClass());
    }

    @Override
    public void makeNoise() {
        System.out.println("...Naaaayyyyyyyyy!");
    }

}
