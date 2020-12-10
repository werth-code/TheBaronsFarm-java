package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class App {

    public static void main(String[] args) {

            //Create our people
            Farmer baron = new Farmer("Baron"); //He can now be a farmer.
            Baroness baroness = new Baroness("Baroness"); //She can now fly.

            //Create Our Farmhouse
            List<Person> baronsFarmHouse = Arrays.asList(baron, baroness);

            //Create Our Barn
        //// TODO: 12/9/20 these need to be one instance..
            List<Horse> baronsBarn1 = new ArrayList<>();
            List<Horse> baronsBarn2 = new ArrayList<>();
            List<Horse> baronsBarn3 = new ArrayList<>();

            String[] horseNames = {"Odi", "Barber", "Oats", "Mia", "Crumbs", "Sally", "Ol Girl", "Whiskers", "Lightning", "Crackle"};
            for (int i = 0; i < horseNames.length; i++) {
                String name = horseNames[i];
                if(i < 3) baronsBarn1.add(new Horse(name));
                else if (i > 3 && i < 7) baronsBarn2.add(new Horse(name));
                else baronsBarn3.add(new Horse(name));
            }

        // TODO: 12/9/20 This is how we can put all of our data into the Stable.. Stable is a map!!!
        //// TODO: 12/9/20 ALSO do this for Chickens, etc.


        // TODO: 12/9/20 WORKING STABLE!!!!!!
            Stables stable1 = new Stables("Stable1", (ArrayList<Horse>) baronsBarn2);
            stable1.getStable().put("Stable2", (ArrayList<Horse>) baronsBarn3);

            System.out.println(stable1.getStable().get("Stable1").get(0).getName());
            System.out.println(stable1.getStable().get("Stable2").get(0).getName());

            HashMap<String, ArrayList<Horse>> stable = new HashMap<>();
            stable.put("Stable1", (ArrayList<Horse>) baronsBarn1);

            System.out.println(stable.get("Stable1").get(0).getName());
            System.out.println(stable.get("Stable1").get(1).getName());
            System.out.println(stable.get("Stable1").get(2).getName());

            //Create Our ChickenCoops
            List<Chicken> chickenCoop1 = new ArrayList<>();
            List<Chicken> chickenCoop2 = new ArrayList<>();
            List<Chicken> chickenCoop3 = new ArrayList<>();
            List<Chicken> chickenCoop4 = new ArrayList<>();

            String[] chickenNames = {"HenniferLopez", "Chip", "Taco", "Henrietta", "Bulbous", "Red One", "Dirty", "Stinky", "Itchy", "Scratchy", "Snowy", "Big O", "Andrea", "SuSu", "FluffyKins"};
            for (int i = 0; i < chickenNames.length; i++) {
                String name = chickenNames[i];
                if(i < 4) chickenCoop1.add(new Chicken(name));
                else if (i > 3 && i < 8) chickenCoop2.add(new Chicken(name));
                else if (i > 8 && i < 13)chickenCoop3.add(new Chicken(name));
                else chickenCoop4.add(new Chicken(name));
            }


            //Farm Vehicles
//            Tractor tractor = new Tractor();
//            CropDuster cropDuster = new CropDuster();
//
//            //Plants
//            TomatoPlant tomatoPlant = new TomatoPlant();
//            Tomato tomato = tomatoPlant.getTomato();
//
//            CornStalk cornStalk = new CornStalk();
//            Corn corn = cornStalk.getCorn();
//
//            List<Crop> cropArrayList = Arrays.asList(tomato, corn);

            //cropArrayList.forEach(System.out::println);

            //CropRow cropRow = new CropRow(cropArrayList);

            //Field field = new Field(cropRow.getCrops());




    }
}
