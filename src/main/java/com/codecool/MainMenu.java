package com.codecool;

import java.util.Scanner;

public class MainMenu {
    private Scanner reader = new Scanner(System.in);
    private Wardrobe wardrobe;

    public MainMenu() {
        wardrobe = new Wardrobe(20);
    }


    public void start() {
        String[] options = {"Cloth menu", "Hanger Menu", "Wardrobe menu", "Exit"};
        while (true) {
            show(options);
            String chosen = reader.nextLine();
            switch (chosen) {
                case "1":   clothMenu();
                            break;
                case "2":   hangerMenu();
                            break;
                case "3":   wardrobeMenu();
                            break;
                case "0":
                            break;
            }
        }

    }

    public void show(String[] options) {
        System.out.println("  ");
        for (int i = 0; i < options.length - 1; i++ ) {
            int num = i + 1;
            System.out.println(num + ". " + options[i]);
        }
        System.out.println(0 + ". " + options[options.length-1]);
    }

    public void clothMenu() {
        String[] options = {"List all clothes", "Add clothes to wardrobe", "Remove clothes from hanger", "Exit"};
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
                    wardrobeMenu();
                    break;
                case "0":
                    break;
            }
        }
    }

    public  void listAllClothes() {
        for (Hanger element : wardrobe.getHangers()) {
            for (Cloth element2 : element.getCloths() ) {
                System.out.println(element2.toString());
            }
        }
    }

    public Cloth FindClothe(String name) {
        Cloth cloth = null;
        for (Hanger element : wardrobe.getHangers()) {
            for (Cloth element2 : element.getCloths() ) {
                if (element2.getBrand().equals(name)) {
                    cloth = element2;
                }
            }
        }
        return cloth;
    }

    private Cloth createCloth() {
        System.out.println("Choose a type: ");
        System.out.println("1. Blouse,\n 2. Blouse,\n 3. Trousers,\n 4. Skirt,\n  ");
        Cloth newCloth;
        System.out.println("Choose a brand: ");
        String label = reader.nextLine();
        while (true) {
            String chosen = reader.nextLine();
            switch (chosen) {
                case "1": newCloth = new Cloth(label, BottomType.SHIRT);
                    return newCloth;
                case "2": newCloth = new Cloth(label, BottomType.BLOUSE);
                    return newCloth;

                case "3": newCloth = new Cloth(label, BottomType.TROUSERS);
                    return newCloth;

                case "4": newCloth = new Cloth(label, BottomType.SKIRT);
                    return newCloth;

            }
        }

    }
    private void putClothesToWardrobe(Cloth cloth) {

    }

    public void hangerMenu() {

    }

    public void wardrobeMenu() {

    }
}
