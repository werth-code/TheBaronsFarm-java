package hbcu.stay.ready.baronsfarm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

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
        String actual = baronsFarmInstance.getChickenCoop().getCoop().get("Chicken Coop 1").get(0).getName();
        System.out.println(actual);
        String expected = "HenniferLopez";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHorse() {
        String actual = baronsFarmInstance.getStables().getStable().get("Stable 1").get(0).getName();
        System.out.println(actual);
        String expected = "Odi";
        Assert.assertEquals(expected, actual);
    }

    // TODO: 12/11/20 Is there anyway to access the Farmers name here?..

    @Test
    public void testMountHorse() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        baronsFarmInstance.getStables().getStable().get("Stable 1").get(0).mount(baron);
    }

    @Test
    public void testMountHorseAlreadyMounted() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        baronsFarmInstance.getStables().getStable().get("Stable 1").get(0).mount(baron);
        baronsFarmInstance.getStables().getStable().get("Stable 1").get(0).mount(baron);
    }

    @Test
    public void testDismount() {
        Farmer baron = (Farmer) baronsFarmInstance.getFarmHouse().getPersons().get(0);
        baronsFarmInstance.getStables().getStable().get("Stable 1").get(0).mount(baron);
        baronsFarmInstance.getStables().getStable().get("Stable 1").get(0).disMount();
    }

    @Test
    public void testDismountAlreadyDismounted() {
        Baroness baroness = (Baroness) baronsFarmInstance.getFarmHouse().getPersons().get(1);
        baronsFarmInstance.getStables().getStable().get("Stable 1").get(0).mount(baroness);

        baronsFarmInstance.getStables().getStable().get("Stable 1").get(0).disMount();
        baronsFarmInstance.getStables().getStable().get("Stable 1").get(0).disMount();
    }

    @Test
    public void testFeedHorses() {
        ArrayList<Horse> stable1 = baronsFarmInstance.getStables().getStable().get("Stable 1");
        ArrayList<Horse> stable2 = baronsFarmInstance.getStables().getStable().get("Stable 2");
        ArrayList<Horse> stable3 = baronsFarmInstance.getStables().getStable().get("Stable 3");

        stable1.forEach(horse -> horse.eat(new Corn()));
        stable2.forEach(horse -> horse.eat(new Corn()));
        stable3.forEach(horse -> horse.eat(new Corn()));

    }




}
