package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
//        //Create our people
//        Farmer baron = new Farmer("Baron"); //He can now be a farmer.
//        Baroness baroness = new Baroness("Baroness"); //She can now fly.
//
//        //Create our Field, CropRows and Crops
//        CropRow cropRow = new CropRow();
//        for(int i = 0; i <= 5; i++) {
//            cropRow.getCropRow().add(new CornStalk());
//        }
//
//        CropRow cropRow2 = new CropRow();
//        for(int i = 0; i <= 5; i++) {
//            cropRow2.getCropRow().add(new TomatoPlant());
//        }
//
//        Field field = new Field("Row1", cropRow);
//        field.getField().put("Row2", cropRow2);
//
//        CornStalk cornStalk = (CornStalk) field.getField().get("Row1").getCropRow().get(0);
//        //Corn corn = cornStalk.getCorn();
//
//        TomatoPlant tomatoPlant = (TomatoPlant) field.getField().get("Row2").getCropRow().get(3);
//        //Tomato tomato = tomatoPlant.getTomato();
//
//        //System.out.println(corn);
//        System.out.println(cornStalk);
//
//        //System.out.println(tomato);
//        System.out.println(tomatoPlant);
//
//        //Create FarmHouse
//        List<Person> baronsFarmHouse = Arrays.asList(baron, baroness);
//        FarmHouse farmHouse = new FarmHouse(baronsFarmHouse);
//        System.out.println(farmHouse.getPersons().get(0).getName());
//
//        //Create Our Stables
//        ArrayList<Horse> baronStable1 = new ArrayList<>();
//        ArrayList<Horse> baronStable2 = new ArrayList<>();
//        ArrayList<Horse> baronStable3 = new ArrayList<>();
//
//        String[] horseNames = {"Odi", "Barber", "Oats", "Mia", "Crumbs", "Sally", "Ol Girl", "Whiskers", "Lightning", "Crackle"};
//        for (int i = 0; i < horseNames.length; i++) {
//            String name = horseNames[i];
//            if (i < 3) baronStable1.add(new Horse(name));
//            else if (i > 3 && i < 7) baronStable2.add(new Horse(name));
//            else baronStable3.add(new Horse(name));
//        }
//
//        Stables mainStable = new Stables("Stable 1", baronStable1);
//        mainStable.getStable().put("Stable 2", baronStable2);
//        mainStable.getStable().put("Stable 3", baronStable3);
//        //How we access this stable
//        System.out.println(mainStable.getStable().get("Stable 1").get(0).getName());
//
//        //Create Our ChickenCoops
//        ArrayList<Chicken> chickenCoop1 = new ArrayList<>();
//        ArrayList<Chicken> chickenCoop2 = new ArrayList<>();
//        ArrayList<Chicken> chickenCoop3 = new ArrayList<>();
//        ArrayList<Chicken> chickenCoop4 = new ArrayList<>();
//
//        String[] chickenNames = {"HenniferLopez", "Chip", "Taco", "Henrietta", "Bulbous", "Red One", "Dirty", "Stinky", "Itchy", "Scratchy", "Snowy", "Big O", "Andrea", "SuSu", "FluffyKins"};
//        for (int i = 0; i < chickenNames.length; i++) {
//            String name = chickenNames[i];
//            if (i < 4) chickenCoop1.add(new Chicken(name));
//            else if (i < 8) chickenCoop2.add(new Chicken(name));
//            else if (i < 13) chickenCoop3.add(new Chicken(name));
//            else chickenCoop4.add(new Chicken(name));
//        }
//
//        ChickenCoop baronsChickenCoop = new ChickenCoop("Barons Chicken Coop 1", chickenCoop1);
//        baronsChickenCoop.getCoop().put("Barons Chicken Coop 2", chickenCoop2);
//        baronsChickenCoop.getCoop().put("Barons Chicken Coop 3", chickenCoop3);
//        baronsChickenCoop.getCoop().put("Barons Chicken Coop 4", chickenCoop4);
//
//        System.out.println(baronsChickenCoop.getCoop().get("Barons Chicken Coop 2").get(2).getName());
//
//        //Farm Vehicles
//        Tractor tractor = new Tractor();
//        CropDuster cropDuster = new CropDuster();
//
//        Farm farm = new Farm("Baron Farms", farmHouse, mainStable, baronsChickenCoop, field);
//        farm.getFarmVehicleShed().add(tractor);
//        farm.getFarmVehicleShed().add(cropDuster);
//
//        System.out.println(farm.getChickenCoop().getCoop().get("Barons Chicken Coop 1").get(0).getName()); //this gets the chicken from coop1 and returns her name.
//        System.out.println(farm.getFarmHouse().getPersons().get(0).getName());

        Farm baronsFarm = Baron.buildBaronsFarm();
        System.out.println(baronsFarm.getFarmHouse().getPersons().get(0).getName());
        System.out.println(baronsFarm.getFarmVehicleShed().get(0));
        System.out.println(baronsFarm.getChickenCoop().getCoop().get("Barons Chicken Coop 1").get(0).getName());
        System.out.println(baronsFarm.getStables().getStable().get("Stable 1").get(0).getName());

    }
}
