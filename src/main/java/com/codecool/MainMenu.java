package com.codecool;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class MainMenu {
    private Scanner reader = new Scanner(System.in);
    private Wardrobe wardrobe;

    public MainMenu() {
        wardrobe = createWardrobe();
    }

    public Wardrobe createWardrobe() {
        System.out.println("To start the program you need to create a wardrobe.");
        System.out.println("Give the size of the wardrobe: ");
        Wardrobe wardrobe = new Wardrobe(Integer.parseInt(reader.nextLine()));
        return wardrobe;
    }


    public void start() {
        String[] options = {"Clothing menu", "Hanger Menu", "Wardrobe menu", "Exit"};
        while (true) {
            show(options);
            String chosen = reader.nextLine();
            switch (chosen) {
                case "1":
                    clothMenu();
                    break;
                case "2":
                    hangerMenu();
                    break;
                case "3":
                    wardrobeMenu();
                    break;
                case "0":
                    System.exit(0);
                    break;
            }
        }

    }

    public void show(String[] options) {
        System.out.println("  ");
        for (int i = 0; i < options.length - 1; i++) {
            int num = i + 1;
            System.out.println(num + ". " + options[i]);
        }
        System.out.println(0 + ". " + options[options.length - 1]);
    }

    public void clothMenu() {
        String[] options = {"List all clothes", "Add clothes to wardrobe", "Create cloth", "Find Clothing by name", "Exit"};
        while (true) {
            show(options);
            String chosen = reader.nextLine();
            switch (chosen) {
                case "1":
                    listAllClothes();
                    break;
                case "2":
                    putClothesToWardrobe();
                    break;
                case "3":
                    createCloth();
                    break;
                case "4":
                    System.out.println("Find cloth by name:");
                    String name = reader.nextLine();
                    try {
                        System.out.println(findClothe(name).toString());
                    } catch (NoSuchCloth ex) {
                        System.out.println(ex.getMessage());
                    }

                case "0":
                    start();
                    break;
            }
        }
    }

    public void listAllClothes() {
        for (Hanger element : wardrobe.getHangers()) {
            System.out.println("Hanger: " + element.getName());
            for (Cloth element2 : element.getCloths()) {
                System.out.println(element2.toString());
            }
            System.out.println("-----------------------");
        }
    }

    public Cloth findClothe(String name) throws NoSuchCloth {
        Cloth cloth = null;
        for (Hanger element : wardrobe.getHangers()) {
            for (Cloth element2 : element.getCloths()) {
                if (element2.getBrand().equals(name)) {
                    cloth = element2;
                }
            }
        }
        if (cloth == null) {
            throw new NoSuchCloth("No cloth that is called like: " + name);
        }
        return cloth;
    }

    private Cloth createCloth() {
        System.out.println("Choose a type: ");
        System.out.println("1. Bottom cloth,\n 2. Top cloth,\n 0. Back to main menu. ");
        Cloth newCloth = null;
        while (true) {
            String chosen = reader.nextLine();
            switch (chosen) {
                case "1":
                    return createAnyCloth("top");

                case "2":
                    return createAnyCloth("bottom");

                case "0":
                    start();
                    break;
            }
        }
    }

    public Cloth createAnyCloth(String type) {
        System.out.println("Give the brand name: ");
        String brand = reader.nextLine();
        Cloth cloth = null;
        System.out.println("Choose a type:");
        if (type.equals("top")) {
            TopType topType;
            TopType[] topEnum = TopType.values();
            int count = 0;
            for (TopType element : topEnum) {
                System.out.println(count + 1 + ". " + element);
                count++;
            }
            while (true) {
                TopType chosenType = TopType.valueOf(reader.nextLine());
                if (Arrays.asList(topEnum).contains(chosenType)) {
                    topType = chosenType;
                    break;
                }
            }
            cloth = new TopCloth(brand, topType);
        } else if (type.equals("bottom")) {
            BottomType bottomType;
            BottomType[] bottomEnum = BottomType.values();
            int count = 0;
            for (BottomType element : bottomEnum) {
                System.out.println(count + 1 + ". " + element);
                count++;
            }
            while (true) {
                String chosenType = reader.nextLine();
                if (Arrays.asList(bottomEnum).contains(chosenType)) {
                    bottomType = BottomType.valueOf(chosenType);
                    break;
                }
            }
            cloth = new BottomCloth(brand, bottomType);
        } else {
            System.out.println("Invalid type");
            //System.exit(0);
        }
        return cloth;
    }

    private void putClothesToWardrobe() {
        Cloth cloth;
        System.out.println("Clothing's brand: ");
        String brand = reader.nextLine();
        try {
            cloth = findClothe(brand);
            if (cloth.onHanger() == true) {
                wardrobe.addHanger(findHanger(cloth));
            }
        } catch (NoSuchCloth ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Hanger findHanger(Cloth cloth) {
        Hanger hanger = null;
        for (Hanger element : wardrobe.getHangers()) {
            for (Cloth element2 : element.getCloths()) {
                if (element2.getBrand().equals(cloth.getBrand())) {
                    hanger = element;
                }
            }
        }
        if (hanger == null) {
            System.out.println("Clothing is not on a hanger.");
        }
        return hanger;
    }


    public Hanger findHanger(String hanger) throws NoSuchHanger {
        Hanger hanger1 = null;
        for (Hanger element : wardrobe.getHangers()) {
            if (element.getName().equals(hanger)) {
                hanger1 = element;
            }
        }
        if (hanger1 == null) {
            throw new NoSuchHanger();
        }
        return hanger1;
    }

    public void hangerMenu() {
        String[] options = {"List all hangers (with the clothes on them)", "Add hanger", "Exit"};
        while (true) {
            show(options);
            String chosen = reader.nextLine();
            switch (chosen) {
                case "1":
                    listAllClothes();
                    break;
                case "2":
                    addHanger();
                    break;

                case "0":
                    break;
            }
        }
    }

    public Hanger addHanger() {
        System.out.println("Hanger's name:");
        String name = reader.nextLine();
        Hanger hanger = null;
        System.out.println("Hanger's type: \n 1. Single \n 2. Double");
        while (true) {
            String chosen = reader.nextLine();
            if (chosen.equals("1")) {
                hanger = new Hanger(name, HangerType.SINGLE);
                break;
            } else if (chosen.equals("2")) {
                hanger = new Hanger(name, HangerType.DOUBLE);
                break;
            }
        }
        return hanger;
    }

    public void wardrobeMenu() {
        String[] options = {"List contents", "Puth clothing to wardrobe", "Exit"};
        while (true) {
            show(options);
            String chosen = reader.nextLine();
            switch (chosen) {
                case "1":
                    listAllClothes();
                    break;
                case "2":
                    putClothesToWardrobe();
                    break;
                case "0":
                    break;
            }
        }
    }
}
