package hbcu.stay.ready.baronsfarm;

public class CropDuster implements AirCraft, FarmVehicle{
    private boolean flying = false;
    private Pilot pilot;

    public void fertilize(CropRow cropRow) {
        if(flying) {
            cropRow.getCropRow().forEach(plant -> plant.setHasBeenFertilized(true));
            System.out.println("Your Crops Have Been Fertilized & Are Ready For Harvest.");
        }
    }

    public void fly(Pilot pilot) {
        System.out.println("....WHOOOOOOOOSSSSSSSSSSHHHHHHHHHHH....");
        this.pilot = pilot;
        flying = true;
    }

    public Pilot land() {
        System.out.println("....BUMP...BUmp...bump...");
        flying = false;
        return pilot;
    }

    public void operate(Farm farm) {
    }
}


