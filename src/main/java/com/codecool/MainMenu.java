package com.codecool;

import java.util.Arrays;
import java.util.List;
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
        String[] options = {"List all clothes", "Add clothes to wardrobe", "Create cloth", "Find Clothing by name", "Back to main menu"};
        while (true) {
            show(options);
            String chosen = reader.nextLine();
            switch (chosen) {
                case "1":
                    listCreatedClothes();
                    break;
                case "2":
                    putClothesToWardrobe();
                    break;
                case "3":
                    wardrobe.createdList(createCloth());
                    break;
                case "4":
                    System.out.println("Find cloth by name:");
                    String name = reader.nextLine();
                    try {
                        System.out.println(findClothing(name).toString());
                    } catch (NoSuchCloth ex) {
                        System.out.println(ex.getMessage());
                    }

                case "0":
                    start();
                    break;
            }
        }
    }

    public void hangerMenu() {
        String[] options = {"List all hangers (with the clothes on them)", "Add hanger", "Remove clothing from hanger", "Remove all cloth from hanger", "Add clothing to hanger", "Back to main menu"};
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
                case "3":
                    removeClothingFromHanger();
                    break;
                case "4":
                    removeAllClothingFromHanger();
                    break;
                case "5":
                    addClothingToHanger();
                    break;
                case "0":
                    start();
                    break;
            }
        }
    }

    private void addClothingToHanger() {
        System.out.println("Clothing's brand name: ");
        try {
            Cloth cloth = findClothing(reader.nextLine());
            System.out.println("Hanger's idendifier: ");
            Hanger hanger = wardrobe.findHangerByName(reader.nextLine());
            hanger.addSingleCloth(cloth);
        } catch (NoSuchCloth | HangerIsFull | NoSuchHanger ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void removeClothingFromHanger() {
        System.out.println("Clothing's brand name: ");
        try {
            Cloth cloth = findClothing(reader.nextLine());
            Hanger hanger = wardrobe.findHanger(cloth);
            hanger.removeSingleCloth(cloth);
            cloth.removeFromHanger();
        } catch (NoSuchCloth | NotOnHangerException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void removeAllClothingFromHanger() {
        System.out.println("Hanger's identifier: ");
        try {
            Hanger hanger = wardrobe.findHangerByName(reader.nextLine());
            List<Cloth> clothes = hanger.getCloths();
            for (Cloth cloth : clothes) {
                cloth.removeFromHanger();
            }
            hanger.removeAllClothes();
        } catch (NoSuchHanger ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void wardrobeMenu() {
        String[] options = {"List contents", "Back to main menu"};
        while (true) {
            show(options);
            String chosen = reader.nextLine();
            switch (chosen) {
                case "1":
                    listAllClothes();
                    break;
                case "0": start();
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

    public void listCreatedClothes() {
        for (Cloth element : wardrobe.getCreatedClothes()) {
            System.out.println(element.toString());
        }
    }

    public Cloth findClothing(String name) throws NoSuchCloth {
        Cloth cloth = null;
        for (Cloth element : wardrobe.getCreatedClothes()) {
            if (element.getBrand().equals(name)) {
                cloth = element;
            }
        }
        if (cloth == null) {
            throw new NoSuchCloth("No cloth that is called like: " + name);
        }
        return cloth;
    }
    /*

    public Cloth findClothing(String name) throws NoSuchCloth {
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
    }  */

    private Cloth createCloth() {
        System.out.println("Choose a type: ");
        System.out.println(" 1. Top cloth,\n 2. Bottom cloth,\n 0. Back to main menu. ");
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
                BottomType chosenType = BottomType.valueOf(reader.nextLine());
                if (Arrays.asList(bottomEnum).contains(chosenType)) {
                    bottomType = chosenType;
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
            cloth = findClothing(brand);
            if (cloth.onHanger() == true) {
                wardrobe.addHanger(wardrobe.findHanger(cloth));
            } else {
                System.out.println("Cloth is not on hanger yet");
            }
        } catch (NoSuchCloth | NotOnHangerException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addHanger() {
        System.out.println("Hanger's identifier:");
        String name = reader.nextLine();
        Hanger hanger = null;
        System.out.println("Hanger's type: \n 1. Single \n 2. Double");
        while (true) {
            String chosen = reader.nextLine();
            if (chosen.equals("1")) {
                hanger = new Hanger(name, HangerType.SINGLE);
                wardrobe.addHanger(hanger);
                break;
            } else if (chosen.equals("2")) {
                hanger = new Hanger(name, HangerType.DOUBLE);
                wardrobe.addHanger(hanger);
                break;
            }
        }

    }


}
