package hbcu.stay.ready.baronsfarm;

import org.junit.Assert;
import org.junit.Test;

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
        String actual = cornStalk.getCorn().toString();

        System.out.println(actual);
        Assert.assertEquals(actual, "Corn");
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
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        Chicken chicken = baronsFarmInstance.getAllChickenCoops().getCoop().get("Chicken Coop 1").get(0);
        //baron.addRooster(chicken);
        Egg egg = (Egg) chicken.yield();

        System.out.println(egg);
        Assert.assertNotNull(egg);
    }

    @Test
    public void testFeedBaronBaroness() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        Baroness baroness = (Baroness) baronsFarmInstance.getFarmHouse().getPersons().get(1);

        CornStalk cornStalk = (CornStalk) baronsFarmInstance.getFarmFields().getFields().get("Row1").getCropRow().get(0);
        Corn corn = cornStalk.getCorn();

        TomatoPlant tomatoPlant = (TomatoPlant) baronsFarmInstance.getFarmFields().getFields().get("Row2").getCropRow().get(0);
        Tomato tomato = tomatoPlant.getTomato();

        Chicken chicken = baronsFarmInstance.getAllChickenCoops().getCoop().get("Chicken Coop 1").get(0);
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
        baronsFarmInstance.getFarmFields().getFields().get("Row1").getCropRow().clear();
        baron.plant(new Tomato(), baronsFarmInstance.getFarmFields().getFields().get("Row1").getCropRow());

        String actual = baronsFarmInstance.getFarmFields().getFields().get("Row1").getCropRow().get(19).toString();
        String expected = "Tomato";

        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPlantNewCropRow() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        baronsFarmInstance.getFarmFields().getFields().get("Row1").getCropRow().clear();
        baron.plant(new Tomato(), baronsFarmInstance.getFarmFields().getFields().get("Row1").getCropRow());

        String actual = baronsFarmInstance.getFarmFields().getFields().get("Row1").getCropRow().get(19).toString();
        String expected = "Tomato";

        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSunday() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        baronsFarmInstance.getFarmFields().getFields().get("Row1").getCropRow().clear();
        baronsFarmInstance.getFarmFields().getFields().get("Row2").getCropRow().clear();

        baron.plant(new CornStalk(), baronsFarmInstance.getFarmFields().getFields().get("Row1").getCropRow());
        baron.plant(new TomatoPlant(), baronsFarmInstance.getFarmFields().getFields().get("Row2").getCropRow());

        CropRow kale = new CropRow();
        baronsFarmInstance.getFarmFields().getFields().put("Row3", kale);
        baron.plant(new KalePlant(), baronsFarmInstance.getFarmFields().getFields().get("Row3").getCropRow());

        String actual = baronsFarmInstance.getFarmFields().getFields().get("Row3").getCropRow().get(12).toString();
        String expected = "KalePlant";

        System.out.println(actual);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testMonday() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        Baroness baroness = (Baroness) baronsFarmInstance.getFarmHouse().getPersons().get(1);

        CropDuster cropDuster = (CropDuster) baronsFarmInstance.getFarmVehicleShed().get(1);
        //cropDuster.fly(baroness);

    }




}
