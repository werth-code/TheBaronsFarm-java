package hbcu.stay.ready.baronsfarm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Baron extends Farmer  {
    private final Scanner scanner;
    public Baron(String name) {
        super(name);
        scanner = new Scanner(System.in);
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
        mainStable.getEachStable().put("Stable 2", baronStable2);
        mainStable.getEachStable().put("Stable 3", baronStable3);

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


    public void mainMenu() {
        // TODO: 12/14/20 createCharacter which creates a character with different implementations based on user selection... like wants to fly, needs pilot interface.
        System.out.println("\n--- Welcome To Baron Farms! ---");
        System.out.println("You Can Feed Our Animals, Watch Us Fertilize & Harvest Crops Or Take A Tour!");
        System.out.println("(1) To Feed A Chicken.");
        System.out.println("(2) To Feed A Horse.");
        System.out.println("(3) To Watch Baroness Fertilize The Crops.");
        System.out.println("(4) To Take A Tour & See All Of Our Animals.");
        System.out.println("Or (exit) To Exit.\n");
    }

    public void feedChickenMenu() {
        System.out.println("Type (1) To Feed A Random Chicken"); //Add feed by specific chicken name..
        System.out.println("Or [exit] To Exit.");
    }

    public void feedHorseMenu() {
        System.out.println("Type (1) To Feed A Random Horse");
        System.out.println("Or [exit] To Exit.");
    }

    public Chicken getRandomChicken(Farm farm) {
        int mn = 0;
        int mx = farm.getChickenCoop("Chicken Coop 1").size();
        int randomNumber = (int)(Math.random() * (mx - mn) + mn);
        return farm.getChickenCoop("Chicken Coop 1").get(randomNumber);
    }

    public Horse getRandomHorse(Farm farm) {
        int mn = 0;
        int mx = farm.getStable("Stable 1").size();
        int randomNumber = (int)(Math.random() * (mx - mn) + mn);
        return farm.getStable("Stable 1").get(randomNumber);
    }

    public void takeTourMenu(Farm farm) {
        Farmer baron = (Farmer) farm.getPerson("Baron");

        Boolean innerFlag = true;
        String baronInput = "1";

        while(innerFlag) {

            switch (baronInput) {
                case "1":
                    //
                    System.out.println("...Let's Start With Our Horses..");
                    System.out.println("\nHere Is Stable 1.. " + farm.getStable("Stable 1"));
                    farm.getStable("Stable 1").forEach(horse -> System.out.println(horse.getName()));
                    System.out.println("...(Ol BARON Says)...Did You Know BARBER Was Backup To A Stand-In For The Kentucky Derby.. I Believe It Was In 1999..");

                    System.out.println("Continue The Tour? (1) Yes. (2) No.");

                    String input = scanner.next();
                    if(input.equals("1")) {
                        System.out.println("\nHere Is Stable 2.. " + farm.getStable("Stable 2"));
                        farm.getStable("Stable 2").forEach(horse -> System.out.println(horse.getName()));
                        System.out.println("\nHere Is Stable 3.. " + farm.getStable("Stable 3"));
                        farm.getStable("Stable 3").forEach(horse -> System.out.println(horse.getName()));
                    } else {
                        innerFlag = false;
                        break;
                    }

                    System.out.println("Still Having Fun? (1) Yes. (2) Get Me Out Of Here!");

                    input = scanner.next();
                    if(input.equals("1")) {
                        System.out.println("...Next We Have The Chickens...");
                        System.out.println("\nHere Is Chicken Coop 1 "+farm.getChickenCoop("Chicken Coop 1"));
                        farm.getChickenCoop("Chicken Coop 1").forEach(chicken -> System.out.println(chicken.getName()));
                        System.out.println("...(Ol BARON Says)...Funny Story Bout Ol HENNIFERLOPEZ. Fought Off A Fox Once..(story was long and you lost interest...)");
                        System.out.println("\nHere Is Chicken Coop 2 "+farm.getChickenCoop("Chicken Coop 2"));
                        farm.getChickenCoop("Chicken Coop 2").forEach(chicken -> System.out.println(chicken.getName()));
                        System.out.println("\nHere Is Chicken Coop 3 "+farm.getChickenCoop("Chicken Coop 3"));
                        farm.getChickenCoop("Chicken Coop 3").forEach(chicken -> System.out.println(chicken.getName()));
                    } else {
                        innerFlag = false;
                        break;
                    }

                    System.out.println("\nDo You Want To See If We Have Any Eggs?");
                    System.out.println("(1) Yes. (2) Do You Have A Rooster? (3) Please No.. Let Me Off This Tour!!!");
                    String input2 = scanner.next();

                    if(input2.equalsIgnoreCase("1")) {
                        Egg egg = (Egg) farm.getChickenCoop("Chicken Coop 1").get(0).yield();
                        System.out.println("...Ol Baron Picks Up An Egg...");
                        baron.canEat(egg);
                        System.out.println("...(Ol Baron Says)...Probably Should Have Cooked That First...");
                    }

                    else if(input2.equalsIgnoreCase("2")) {
                        Chicken chicken = farm.getChickenCoop("Chicken Coop 1").get(0);
                        addRooster(chicken);
                        System.out.println("...(Ol Baron Says)...Oh Yes, We Do! BoBo Our Rooster Stops By Sometimes...");
                        System.out.println("...(Ol Baron Says)...That Must Be Why This Egg Is Hatching!...");
                        System.out.println("...(Ol Baron Says)...What Should We Name This New Chick?...");
                        input = scanner.next();
                        Chicken newChick = chicken.spawn(input);
                        farm.getChickenCoop("Chicken Coop 1").add(newChick);
                        farm.getChickenCoop("Chicken Coop 1").forEach(ch-> System.out.println(ch.getName()));
                        newChick.makeNoise();
                    }

                    innerFlag = false;
                    playFarm();
                    break;

                default:
                    playFarm();
            }
        }
    }


    public void baronessMenu(Farm farm) {
        Baroness baroness = (Baroness) farm.getPerson("Baroness");
        Farmer baron = (Farmer) farm.getPerson("Baron");

        Boolean innerFlag = true;
        String baronessInput = "1";

        while(innerFlag) {

            switch (baronessInput) {
                case "1":
                    CropRow cropRow1 = farm.getCropRow("Row1");
                    CropRow cropRow2 = farm.getCropRow("Row2");

                    CropDuster cropDuster = (CropDuster) farm.getFarmVehicleShed().get(1);
                    cropDuster.fly(baroness);
                    cropDuster.fertilize(cropRow1);
                    cropDuster.fertilize(cropRow2);
                    cropDuster.land();

                    System.out.println("\nWould You Like To See Baron Harvest The Crops?");
                    System.out.println("(1) Yes. (2) No.");

                    String input = scanner.next();
                    if(input.equalsIgnoreCase("1")) {

                        Tractor tractor = (Tractor) farm.getFarmVehicleShed().get(0);
                        tractor.operate(farm);

                        CropRow harvestedCrops = tractor.harvest(cropRow1);
                        CropRow harvestedCrops2 = tractor.harvest(cropRow2);
                        tractor.turnOff();

                        Corn corn = (Corn) harvestedCrops.getCropRow().get(0);
                        Tomato tomato = (Tomato) harvestedCrops2.getCropRow().get(0);
                        baron.canEat(corn);
                        baroness.canEat(tomato);
                    }

                    playFarm();
                    innerFlag = false;
                    break;

                default:
                    playFarm();
            }
        }
    }


    public void feedAnimalMenu(Farm farm, Animal animal) {
        Animal ourAnimal;
        if(animal.getClass() == Chicken.class) ourAnimal = getRandomChicken(farm);
        else ourAnimal = getRandomHorse(farm);

        Boolean innerFlag = true;
        String animalInput = "1";

        while(innerFlag) {

            switch (animalInput) {
                case "1":
                    System.out.println("Oh Look At This Beautiful " + animal.toString() + "!");
                    animal.makeNoise();
                    System.out.println("Feed "+ "'" + animal.getName() + "'" + " Corn: (1)  Or Tomatoes: (2)");
                    String input = scanner.next();
                    if(input.equalsIgnoreCase("1")) {
                        Corn corn = new Corn();
                        animal.canEat(corn);
                    }
                    else if(input.equalsIgnoreCase("2")) {
                        Tomato tomato = new Tomato();
                        animal.canEat(tomato);
                    }
                        innerFlag = false;
                        break;

                default:
                    playFarm();
            }
        }
    }


    public void playFarm() {
        //set up menu with Scanner and set up default farm.
        Farm farm = buildBaronsFarm();
        boolean flag = true;

        //grab user response
        while(flag) {
            mainMenu();
            String input = scanner.next();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Have A Farmin Great Day!");
                break;
            }

            switch(input) {
                case "1" :
                    feedChickenMenu();
                    input = scanner.next();
                    if(input.equals("1")) {
                        feedAnimalMenu(farm, getRandomChicken(farm));
                    }
                    break;
                case "2" :
                    feedHorseMenu();
                    input = scanner.next();
                    if(input.equals("1")) {
                        feedAnimalMenu(farm, getRandomHorse(farm));
                    }
                    break;
                case "3" :
                    baronessMenu(farm);
                    break;
                case "4" :
                    takeTourMenu(farm);
                    break;
                case "exit" :
                default:
                    System.out.println("Have A Farmin Good Day!!");
                    flag = false;
                    scanner.close();
                    break;
            }
        }
    }

}
