package hbcu.stay.ready.baronsfarm;

import org.junit.Assert;
import org.junit.Test;

public class MainApplicationTest {
    Farm baronsFarmInstance = Baron.buildBaronsFarm();

    @Test
    public void testGetBaronsFarmInstance() {
        String actual = baronsFarmInstance.getPerson("Baron").getName();
        System.out.println(actual);
        String expected = "Baron";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetChicken() {
        String actual = baronsFarmInstance.getChickenCoop("Chicken Coop 1").get(0).getName();
        System.out.println(actual);
        String expected = "HenniferLopez";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHorse() {
        String actual = baronsFarmInstance.getStable("Stable 1").get(0).getName();
        System.out.println(actual);
        String expected = "Odi";
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testMountHorse() {
        Farmer baron = (Farmer) baronsFarmInstance.getPerson("Baron");
        baronsFarmInstance.getStable("Stable 1").get(0).mount(baron);

        Rider actual = baronsFarmInstance.getStable("Stable 1").get(0).disMount();

        Assert.assertEquals(baron, actual);
    }

    @Test
    public void testMountHorseAlreadyMounted() {
        Farmer baron = (Farmer) baronsFarmInstance.getPerson("Baron");
        Horse horse = baronsFarmInstance.getStable("Stable 1").get(0);

        horse.mount(baron);

        Assert.assertTrue(horse.getBeingRidden());
    }

    @Test
    public void testDismountHorse() {
        Farmer baron = (Farmer) baronsFarmInstance.getPerson("Baron");
        baronsFarmInstance.getStable("Stable 1").get(0).mount(baron);
        baronsFarmInstance.getStable("Stable 1").get(0).disMount();
    }

    @Test
    public void testDismountAlreadyDismounted() {
        Baroness baroness = (Baroness) baronsFarmInstance.getPerson("Baroness");
        baronsFarmInstance.getStable("Stable 1").get(0).mount(baroness);

        baronsFarmInstance.getStable("Stable 1").get(0).disMount();
        baronsFarmInstance.getStable("Stable 1").get(0).disMount();
    }

    @Test
    public void rideAllHorses() {
        Farmer baron = (Farmer) baronsFarmInstance.getPerson("Baron");
        baron.rideAllHorses(baronsFarmInstance.getStable("Stable 1"), baron);

        Baroness baroness = (Baroness) baronsFarmInstance.getPerson("Baroness");
        baroness.rideAllHorses(baronsFarmInstance.getStable("Stable 2"), baroness);

        baron.rideAllHorses(baronsFarmInstance.getStable("Stable 3"), baron);
    }

    @Test
    public void testFeedHorses() {
        Farmer baron = (Farmer) baronsFarmInstance.getPerson("Baron");

        baron.feedHorses(baronsFarmInstance.getStable("Stable 1"));
        baron.feedHorses(baronsFarmInstance.getStable("Stable 2"));
        baron.feedHorses(baronsFarmInstance.getStable("Stable 3"));

    }

    @Test
    public void testGetHorseFunction() {
        Farmer baron = (Farmer) baronsFarmInstance.getPerson("Baron");

        String actual = baron.getHorse("Odi", baronsFarmInstance.getStable("Stable 1")).getName();
        System.out.println(actual);
        String expected = "Odi";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCropsFromFields() {
        CornStalk cornStalk = (CornStalk) baronsFarmInstance.getCrops("Row1").get(0);
        String actual = cornStalk.toString();

        System.out.println(actual);
        Assert.assertEquals(actual, "CornStalk");
    }

    @Test
    public void testGetEggFAIL() {
        Farmer baron = (Farmer) baronsFarmInstance.getPerson("Baron");
        Chicken chicken = baronsFarmInstance.getChickenCoop("Chicken Coop 1").get(0);
        baron.addRooster(chicken);
        Egg actual = (Egg) chicken.yield();

        System.out.println(actual);
        Assert.assertEquals(actual, null);
    }

    @Test
    public void testGetEgg() {
        Chicken chicken = baronsFarmInstance.getChickenCoop("Chicken Coop 1").get(0);
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
        Farmer baron = (Farmer) baronsFarmInstance.getPerson("Baron");
        Baroness baroness = (Baroness) baronsFarmInstance.getPerson("Baroness");

        CropRow cropRow1 = baronsFarmInstance.getCropRow("Row1");
        CropRow cropRow2 = baronsFarmInstance.getCropRow("Row2");

        CropDuster cropDuster = (CropDuster) baronsFarmInstance.getFarmVehicleShed().get(1);
        cropDuster.fly(baroness);
        cropDuster.fertilize(cropRow1);
        cropDuster.fertilize(cropRow2);
        cropDuster.land();

        Tractor tractor = (Tractor) baronsFarmInstance.getFarmVehicleShed().get(0);

        tractor.operate(baronsFarmInstance);

        CropRow harvestedCrops = tractor.harvest(cropRow1);
        CropRow harvestedCrops2 = tractor.harvest(cropRow2);
        tractor.turnOff();

        Corn corn = (Corn) harvestedCrops.getCropRow().get(0);
        Tomato tomato = (Tomato) harvestedCrops2.getCropRow().get(0);

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
        Farmer baron = (Farmer) baronsFarmInstance.getPerson("Baron");
        baronsFarmInstance.getCrops("Row1").clear();
        baron.plant(new Tomato(), baronsFarmInstance.getCrops("Row1"));

        String actual = baronsFarmInstance.getCrops("Row1").get(19).toString();
        String expected = "Tomato";

        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlantNewCropRow() {
        Farmer baron = (Farmer) baronsFarmInstance.getPerson("Baron");
        baronsFarmInstance.getCrops("Row1").clear();
        baron.plant(new Tomato(), baronsFarmInstance.getCrops("Row1"));

        String actual = baronsFarmInstance.getCrops("Row1").get(19).toString();
        String expected = "Tomato";

        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSunday() {
        Farmer baron = (Farmer) baronsFarmInstance.getPerson("Baron");
        baronsFarmInstance.getCrops("Row1").clear();
        baronsFarmInstance.getCrops("Row2").clear();

        baron.plant(new CornStalk(), baronsFarmInstance.getCrops("Row1"));
        baron.plant(new TomatoPlant(), baronsFarmInstance.getCrops("Row2"));

        CropRow kale = new CropRow();
        baronsFarmInstance.getFarmFields().getField().put("Row3", kale);
        baron.plant(new KalePlant(), baronsFarmInstance.getCrops("Row3"));

        String actual = baronsFarmInstance.getCrops("Row3").get(12).toString();
        String expected = "KalePlant";

        System.out.println(actual);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFlyAndLandCropDuster() {
        Baroness baroness = (Baroness) baronsFarmInstance.getPerson("Baroness");
        CropDuster cropDuster = (CropDuster) baronsFarmInstance.getFarmVehicleShed().get(1);
        cropDuster.fly(baroness);

        Pilot actual = cropDuster.land();
        Pilot expected = baroness;

        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testFlyWhenNotPilot(){
        Farmer farmer = new Farmer("Jake");
        CropDuster cropDuster = new CropDuster();
        System.out.println("Uncomment to see error");
        //cropDuster.fly((Pilot) farmer);
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
        Baroness baroness = (Baroness) baronsFarmInstance.getPerson("Baroness");

        CropRow cropRow2 = baronsFarmInstance.getCropRow("Row2");

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
        Farmer baron = (Farmer) baronsFarmInstance.getPerson("Baron");
        baronsFarmInstance.getCrops("Row1").clear();
        baronsFarmInstance.getCrops("Row2").clear();

        baron.plant(new CornStalk(), baronsFarmInstance.getCrops("Row1"));
        baron.plant(new TomatoPlant(), baronsFarmInstance.getCrops("Row2"));

        CropRow kale = new CropRow();
        baronsFarmInstance.getFarmFields().getField().put("Row3", kale);
        baron.plant(new KalePlant(), baronsFarmInstance.getCrops("Row3"));

        //Monday
        Baroness baroness = (Baroness) baronsFarmInstance.getPerson("Baroness");

        CropRow cropRow1 = baronsFarmInstance.getCropRow("Row1");
        CropRow cropRow2 = baronsFarmInstance.getCropRow("Row2");
        CropRow cropRow3 = baronsFarmInstance.getCropRow("Row3");

        CropDuster cropDuster = (CropDuster) baronsFarmInstance.getFarmVehicleShed().get(1);
        cropDuster.fly(baroness);
        cropDuster.fertilize(cropRow1);
        cropDuster.fertilize(cropRow2);
        cropDuster.fertilize(cropRow3);
        cropDuster.land();

        //Tuesday
        Tractor tractor = (Tractor) baronsFarmInstance.getFarmVehicleShed().get(0);

        tractor.operate(baronsFarmInstance);
        // TODO: 12/12/20
        CropRow harvestedCrops = tractor.harvest(cropRow1);
        CropRow harvestedCrops2 =  tractor.harvest(cropRow2);
        CropRow harvestedCrops3 = tractor.harvest(cropRow3);
        tractor.turnOff();

        Assert.assertNotNull(harvestedCrops);
    }

    @Test
    public void testHasBeenHarvested() {
        Baroness baroness = (Baroness) baronsFarmInstance.getPerson("Baroness");

        CropRow cropRow1 = baronsFarmInstance.getCropRow("Row1");
        CropRow cropRow2 = baronsFarmInstance.getCropRow("Row2");

        CropDuster cropDuster = (CropDuster) baronsFarmInstance.getFarmVehicleShed().get(1);
        cropDuster.fly(baroness);
        cropDuster.fertilize(cropRow1);
        cropDuster.fertilize(cropRow2);
        cropDuster.land();

        //Tuesday
        Tractor tractor = (Tractor) baronsFarmInstance.getFarmVehicleShed().get(0);

        tractor.operate(baronsFarmInstance);
        tractor.harvest(cropRow1);
        tractor.harvest(cropRow2);
        tractor.turnOff();

        Boolean actual = cropRow1.getCropRow().get(0).getHasBeenHarvested();
        System.out.println(actual);

        Assert.assertEquals(true, actual);
    }


    @Test
    public void testPlayFarm() {
        Baron baron = new Baron("User");
        baron.playFarm();
    }

}
