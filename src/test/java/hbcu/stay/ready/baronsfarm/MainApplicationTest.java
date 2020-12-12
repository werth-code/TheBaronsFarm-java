package hbcu.stay.ready.baronsfarm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.function.ToDoubleBiFunction;

public class MainApplicationTest {
    Farm baronsFarmInstance = Baron.buildBaronsFarm();

    @Test
    public void testGetBaronsFarmInstance() {
        String actual = baronsFarmInstance.getFarmHouse().getPersons().get(0).getName();
        System.out.println(actual);
        String expected = "Baron";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetChicken() {
        String actual = baronsFarmInstance.getAllChickenCoops().getCoop().get("Chicken Coop 1").get(0).getName();
        System.out.println(actual);
        String expected = "HenniferLopez";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHorse() {
        String actual = baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 1").get(0).getName();
        System.out.println(actual);
        String expected = "Odi";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testMountHorse() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 1").get(0).mount(baron);

        Rider actual = baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 1").get(0).disMount();

        Assert.assertEquals(baron, actual);
    }

    @Test
    public void testMountHorseAlreadyMounted() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 1").get(0).mount(baron);
        baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 1").get(0).mount(baron);
    }

    @Test
    public void testDismount() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 1").get(0).mount(baron);
        baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 1").get(0).disMount();
    }

    @Test
    public void testDismountAlreadyDismounted() {
        Baroness baroness = (Baroness) baronsFarmInstance.getFarmHouse().getPersons().get(1);
        baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 1").get(0).mount(baroness);

        baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 1").get(0).disMount();
        baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 1").get(0).disMount();
    }

    @Test
    public void rideAllHorses() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        baron.rideAllHorses(baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 1"), baron);

        Baroness baroness = (Baroness) baronsFarmInstance.getFarmHouse().getPersons().get(1);
        baroness.rideAllHorses(baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 2"), baroness);

        baron.rideAllHorses(baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 3"), baron);
    }

    @Test
    public void testFeedHorses() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);

        baron.feedHorses(baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 1"));
        baron.feedHorses(baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 2"));
        baron.feedHorses(baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 3"));

    }

    @Test
    public void testGetHorseFunction() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);

        String actual = baron.getHorse("Odi", baronsFarmInstance.getAllFarmStables().getEachStable().get("Stable 1")).getName();
        System.out.println(actual);
        String expected = "Odi";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCropsFromFields() {
        CornStalk cornStalk = (CornStalk) baronsFarmInstance.getFarmFields().getFields().get("Row1").getCropRow().get(0);
        String actual = cornStalk.toString();

        System.out.println(actual);
        Assert.assertEquals(actual, "CornStalk");
    }

    @Test
    public void testGetEggFAIL() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        Chicken chicken = baronsFarmInstance.getAllChickenCoops().getCoop().get("Chicken Coop 1").get(0);
        baron.addRooster(chicken);
        Egg actual = (Egg) chicken.yield();

        System.out.println(actual);
        Assert.assertEquals(actual, null);
    }

    @Test
    public void testGetEgg() {
        Chicken chicken = baronsFarmInstance.getAllChickenCoops().getCoop().get("Chicken Coop 1").get(0);
        Egg egg = (Egg) chicken.yield();

        System.out.println(egg);
        Assert.assertNotNull(egg);
    }

    @Test
    public void testChickenMakeNoise() {
        baronsFarmInstance.getChickenCoop("Chicken Coop 1").get(0).makeNoise();
    }

    @Test
    public void testFeedBaronBaroness() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        Baroness baroness = (Baroness) baronsFarmInstance.getFarmHouse().getPersons().get(1);

        CropRow cropRow1 = baronsFarmInstance.getFarmFields().getFields().get("Row1");
        CropRow cropRow2 = baronsFarmInstance.getFarmFields().getFields().get("Row2");

        CropDuster cropDuster = (CropDuster) baronsFarmInstance.getFarmVehicleShed().get(1);
        cropDuster.fly(baroness);
        cropDuster.fertilize(cropRow1);
        cropDuster.fertilize(cropRow2);
        cropDuster.land();

        Tractor tractor = (Tractor) baronsFarmInstance.getFarmVehicleShed().get(0);
        ArrayList<Crop> crops1 = baronsFarmInstance.getCrops("Row1");
        ArrayList<Crop> crops2 = baronsFarmInstance.getCrops("Row2");

        tractor.operate(baronsFarmInstance);

        ArrayList<Crop> harvestedCrops = (ArrayList<Crop>) tractor.harvest(crops1);
        ArrayList<Crop> harvestedCrops2 = (ArrayList<Crop>) tractor.harvest(crops2);
        tractor.turnOff();

        Corn corn = (Corn) harvestedCrops.get(0);
        Tomato tomato = (Tomato) harvestedCrops2.get(0);

        Chicken chicken = baronsFarmInstance.getChickenCoop("Chicken Coop 1").get(0);
        Egg egg = (Egg) chicken.yield();

        baron.canEat(corn);
        baron.canEat(tomato);
        baron.canEat(egg);

        baroness.canEat(corn);
        baroness.canEat(tomato);
        baroness.canEat(egg);

        System.out.println(egg.getClass());
        System.out.println(Egg.class);
        Assert.assertEquals(egg.getClass(), Egg.class);
    }

    @Test
    public void testPlantExisting() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        baronsFarmInstance.getCrops("Row1").clear();
        baron.plant(new Tomato(), baronsFarmInstance.getCrops("Row1"));

        String actual = baronsFarmInstance.getCrops("Row1").get(19).toString();
        String expected = "Tomato";

        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlantNewCropRow() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        baronsFarmInstance.getCrops("Row1").clear();
        baron.plant(new Tomato(), baronsFarmInstance.getCrops("Row1"));

        String actual = baronsFarmInstance.getCrops("Row1").get(19).toString();
        String expected = "Tomato";

        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSunday() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        baronsFarmInstance.getCrops("Row1").clear();
        baronsFarmInstance.getCrops("Row2").clear();

        baron.plant(new CornStalk(), baronsFarmInstance.getCrops("Row1"));
        baron.plant(new TomatoPlant(), baronsFarmInstance.getCrops("Row2"));

        CropRow kale = new CropRow();
        baronsFarmInstance.getFarmFields().getFields().put("Row3", kale);
        baron.plant(new KalePlant(), baronsFarmInstance.getCrops("Row3"));

        String actual = baronsFarmInstance.getCrops("Row3").get(12).toString();
        String expected = "KalePlant";

        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFlyAndLandCropDuster() {
        Baroness baroness = (Baroness) baronsFarmInstance.getFarmHouse().getPersons().get(1);
        CropDuster cropDuster = (CropDuster) baronsFarmInstance.getFarmVehicleShed().get(1);
        cropDuster.fly(baroness);

        Pilot actual = cropDuster.land();
        Pilot expected = baroness;

        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsFertilized() {
        TomatoPlant tomatoPlant = (TomatoPlant) baronsFarmInstance.getCrops("Row2").get(0);

        Boolean actual = tomatoPlant.getHasBeenFertilized();

        System.out.println(actual);
        Assert.assertEquals(false, actual);
    }

    @Test
    public void testMonday() {
        Baroness baroness = (Baroness) baronsFarmInstance.getFarmHouse().getPersons().get(1);

        CropRow cropRow2 = baronsFarmInstance.getFarmFields().getFields().get("Row2");

        CropDuster cropDuster = (CropDuster) baronsFarmInstance.getFarmVehicleShed().get(1);
        cropDuster.fly(baroness);
        cropDuster.fertilize(cropRow2);

        Boolean actual = cropRow2.getCropRow().get(5).getHasBeenFertilized();

        System.out.println(actual);
        Assert.assertEquals(true, actual);
        
    }

    @Test
    public void testCannotHarvestWithoutFertilizing(){
        CornStalk cornStalk = (CornStalk) baronsFarmInstance.getCrops("Row1").get(0);
        System.out.println(cornStalk.hasBeenFertilized);
        System.out.println(cornStalk.getCorn());
        Assert.assertNull(cornStalk.getCorn());
    }

    @Test
    public void testTuesday() {
        //Sunday
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        baronsFarmInstance.getCrops("Row1").clear();
        baronsFarmInstance.getCrops("Row2").clear();

        baron.plant(new CornStalk(), baronsFarmInstance.getCrops("Row1"));
        baron.plant(new TomatoPlant(), baronsFarmInstance.getCrops("Row2"));

        CropRow kale = new CropRow();
        baronsFarmInstance.getFarmFields().getFields().put("Row3", kale);
        baron.plant(new KalePlant(), baronsFarmInstance.getCrops("Row3"));

        //Monday
        Baroness baroness = (Baroness) baronsFarmInstance.getFarmHouse().getPersons().get(1);

        CropRow cropRow1 = baronsFarmInstance.getFarmFields().getFields().get("Row1");
        CropRow cropRow2 = baronsFarmInstance.getFarmFields().getFields().get("Row2");

        CropDuster cropDuster = (CropDuster) baronsFarmInstance.getFarmVehicleShed().get(1);
        cropDuster.fly(baroness);
        cropDuster.fertilize(cropRow1);
        cropDuster.fertilize(cropRow2);
        cropDuster.land();

        //Tuesday
        Tractor tractor = (Tractor) baronsFarmInstance.getFarmVehicleShed().get(0);

        // TODO: 12/12/20 commandLine game out of this...
        //TODO Add a chicken when BoBo the rooster visits a Chicken.

        ArrayList<Crop> crops1 = baronsFarmInstance.getCrops("Row1");
        ArrayList<Crop> crops2 = baronsFarmInstance.getCrops("Row2");

        tractor.operate(baronsFarmInstance);
        ArrayList<Crop> harvestedCrops = (ArrayList<Crop>) tractor.harvest(crops1);
        ArrayList<Crop> harvestedCrops2 = (ArrayList<Crop>) tractor.harvest(crops2);
        tractor.turnOff();

        Assert.assertNotNull(harvestedCrops);
    }


}
