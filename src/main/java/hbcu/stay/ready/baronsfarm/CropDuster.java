package hbcu.stay.ready.baronsfarm;

public class CropDuster implements AirCraft, FarmVehicle{
    private boolean flying = false;
    private Pilot pilot;

    // TODO: 12/11/20 Working on getting each plant fertilized....

    public void fertilize(CropRow cropRow) {
        if(flying) {
            cropRow.getCropRow().forEach(plant -> plant.setHasBeenFertilized(true));
            System.out.println("Fertilizing... " + cropRow.toString() + " ....Ready For Harvest.");
        }
    }

    public void fly(Pilot pilot) {
        System.out.println("....WHOOOOOOOOSSSSSSSSSSHHHHHHHHHHH.... Crop Duster Is Flying.");
        this.pilot = pilot;
        flying = true;
    }

    public Pilot land() {
        System.out.println("....BUMP...BUmp...bump... Fertilized All Crops & Landed Safely.");
        flying = false;
        return pilot;
    }

    public void operate(Farm farm) {
    }
}


