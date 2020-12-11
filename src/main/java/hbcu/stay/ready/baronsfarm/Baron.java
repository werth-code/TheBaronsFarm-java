package hbcu.stay.ready.baronsfarm;

//// TODO: 12/9/20 already inherits rider from Farmer->Person

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baron extends Farmer  {

    public Baron(String name) {
        super(name);
    }

    public static Farm buildBaronsFarm(){
        Farmer baron = new Farmer("Baron");
        Baroness baroness = new Baroness("Baroness");

        //Create our Field, CropRows and Crops
        CropRow cropRow = new CropRow();
        for(int i = 0; i <= 5; i++) {
            cropRow.getCropRow().add(new CornStalk());
        }

        CropRow cropRow2 = new CropRow();
        for(int i = 0; i <= 5; i++) {
            cropRow2.getCropRow().add(new TomatoPlant());
        }

        Field field = new Field("Row1", cropRow);
        field.getField().put("Row2", cropRow2);

        //Create FarmHouse
        List<Person> baronsFarmHouse = Arrays.asList(baron, baroness);
        FarmHouse farmHouse = new FarmHouse(baronsFarmHouse);

        //Create Our Stables
        ArrayList<Horse> baronStable1 = new ArrayList<>();
        ArrayList<Horse> baronStable2 = new ArrayList<>();
        ArrayList<Horse> baronStable3 = new ArrayList<>();

        String[] horseNames = {"Odi", "Barber", "Oats", "Mia", "Crumbs", "Sally", "Ol Girl", "Whiskers", "Lightning", "Crackle"};
        for (int i = 0; i < horseNames.length; i++) {
            String name = horseNames[i];
            if (i < 3) baronStable1.add(new Horse(name));
            else if (i > 3 && i < 7) baronStable2.add(new Horse(name));
            else baronStable3.add(new Horse(name));
        }

        Stables mainStable = new Stables("Stable 1", baronStable1);
        mainStable.getStable().put("Stable 2", baronStable2);
        mainStable.getStable().put("Stable 3", baronStable3);

        //Create Our ChickenCoops
        ArrayList<Chicken> chickenCoop1 = new ArrayList<>();
        ArrayList<Chicken> chickenCoop2 = new ArrayList<>();
        ArrayList<Chicken> chickenCoop3 = new ArrayList<>();
        ArrayList<Chicken> chickenCoop4 = new ArrayList<>();

        String[] chickenNames = {"HenniferLopez", "Chip", "Taco", "Henrietta", "Bulbous", "Red One", "Dirty", "Stinky", "Itchy", "Scratchy", "Snowy", "Big O", "Andrea", "SuSu", "FluffyKins"};
        for (int i = 0; i < chickenNames.length; i++) {
            String name = chickenNames[i];
            if (i < 4) chickenCoop1.add(new Chicken(name));
            else if (i < 8) chickenCoop2.add(new Chicken(name));
            else if (i < 13) chickenCoop3.add(new Chicken(name));
            else chickenCoop4.add(new Chicken(name));
        }

        ChickenCoop baronsChickenCoop = new ChickenCoop("Chicken Coop 1", chickenCoop1);
        baronsChickenCoop.getCoop().put("Chicken Coop 2", chickenCoop2);
        baronsChickenCoop.getCoop().put("Chicken Coop 3", chickenCoop3);
        baronsChickenCoop.getCoop().put("Chicken Coop 4", chickenCoop4);

        //Farm Vehicles
        Tractor tractor = new Tractor();
        CropDuster cropDuster = new CropDuster();

        Farm farm = new Farm("Baron Farms", farmHouse, mainStable, baronsChickenCoop, field);
        farm.getFarmVehicleShed().add(tractor);
        farm.getFarmVehicleShed().add(cropDuster);

        return farm;
    }

}
