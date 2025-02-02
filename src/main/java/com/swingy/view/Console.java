package com.swingy.view;

import com.swingy.model.characters.*;
import com.swingy.model.*;
import com.swingy.controller.GameState;

import java.io.*;
import java.util.Scanner;
import javax.validation.constraints.*;

public class Console {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    static SuperChampion champion;
    static Map map;
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("***************SWINGY***************");
        System.out.println("Would you like to CREATE NEW HERO[new] or LOAD HERO[load]");
        System.out.println("(starting a new game results in loss previous progress)");
        String choice = in.nextLine();
        if (choice.equals("new")) {
            heroSelect();
            map = new Map(champion);
            while(champion.hitPoints > 0) {
                championMove(champion, map);
            }
            if(champion.hitPoints <= 0) {
                System.out.println("GAME OVER");
            }
        } else if(choice.equals("load")) {
                selectOldHero();
        }
    }

    public static void heroSelect() throws IOException {
        Champion_Warrior baseWarrior = new Champion_Warrior();
        Champion_Elf baseElf = new Champion_Elf();
        Champion_Mage baseMage = new Champion_Mage();
        Scanner in = new Scanner(System.in);
        System.out.println("Choose ONE of the following hero classes: Warrior; Elf; Mage");
        System.out.println("Warrior -  atk: " + baseWarrior.attack + "  def: " + baseWarrior.defense + "  HP: " + baseWarrior.hitPoints);
        System.out.println("Elf -  atk: " + baseElf.attack + "  def: " + baseElf.defense + "  HP: " + baseElf.hitPoints);
        System.out.println("Mage -  atk: " + baseMage.attack + "  def: " + baseMage.defense + "  HP: " + baseMage.hitPoints);
        String s = in.nextLine();
        if(s.equals("Warrior")) {
            champion = new Champion_Warrior();
            System.out.println("Enter a name for your champion: ");
            String name = in.nextLine();
            while(name.equals("")) {
                System.out.println("Enter a name for your champion: ");
                name = in.nextLine();
            }
            champion.heroName = name;
            System.out.println("Welcome to the game " + champion.heroName + " the warrior!");
        } else if(s.equals("Elf")) {
            champion = new Champion_Elf();
            System.out.println("Enter a name for your champion: ");
            String name = in.nextLine();
            while(name.equals("")) {
                System.out.println("Enter a name for your champion: ");
                name = in.nextLine();
            }
            champion.heroName = name;
            System.out.println("Welcome to the game " + champion.heroName + " the elf!");
        } else if(s.equals("Mage")) {
            champion = new Champion_Mage();
            System.out.println("Enter a name for your champion: ");
            String name = in.nextLine();
            while(name.equals("")) {
                System.out.println("Enter a name for your champion: ");
                name = in.nextLine();
            }
            champion.heroName = name;
            System.out.println("Welcome to the game " + champion.heroName + " the mage!");
        } else {
            System.out.println(RED + "Please enter a valid champion class" + RESET);
            heroSelect();
            map = new Map(champion);
            while(champion.hitPoints > 0) {
                championMove(champion, map);
            }
            if(champion.hitPoints <= 0) {
                System.out.println("GAME OVER");
            }
        }

        GameState.saveState(champion);
    }

    public static void selectOldHero() throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/swingy/save.txt"));
            String line = null;
            try {
                line = reader.readLine();
                System.out.println("#### SAVED CHAMPION ####");
                while (!line.contains("POSX")) {
                    String stat = line.split(" ")[0];
                    String value = line.split(" ")[1];
                    System.out.print(stat);
                    System.out.print(": ");
                    System.out.print(value);
                    System.out.print("   ");
                    line = reader.readLine();
                }
                System.out.print(("\n"));
                System.out.println("Would you like to play with this champion [yes/no]?");
                String choice = in.nextLine();
                if (choice.equals("no"))
                    System.exit(0);
                else if (choice.equals("yes"))
                    GameState.loadState();
                else
                    System.exit(0);
            } catch (Exception e) {
                System.out.println("You have no progress saved yet! Please make a new champion :).");
                heroSelect();
                map = new Map(champion);
                while(champion.hitPoints > 0) {
                    championMove(champion, map);
                }
                if(champion.hitPoints <= 0) {
                    System.out.println("GAME OVER");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("You have no progress saved yet! Please make a new champion :).");
            heroSelect();
            map = new Map(champion);
            while(champion.hitPoints > 0) {
                championMove(champion, map);
            }
            if(champion.hitPoints <= 0) {
                System.out.println("GAME OVER");
            }
        }
    }

    public static void championMove(SuperChampion champion, Map map) throws IOException{
        System.out.println("Choose a direction to move: north; east; south; west");
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();

        if(s.equals("north")) {
            if(champion.y - 1 < 0) {
                map = new Map(champion);
                System.out.println("######## NEW MAP ########");
            } else {
                champion.storeX = champion.x;
                champion.storeY = champion.y;
                champion.y = champion.y - 1;
            }
            map.encounter(champion, map);
            map.resetMap();
            map.updateMap(champion);
            map.printMap(champion);
        } else if(s.equals("east")) {
            if(champion.x + 1 >= map.size) {
                map = new Map(champion);
                System.out.println("######## NEW MAP ########");
            } else {
                champion.storeX = champion.x;
                champion.storeY = champion.y;
                champion.x = champion.x + 1;
            }
            map.encounter(champion, map);
            map.resetMap();
            map.updateMap(champion);
            map.printMap(champion);
        } else if(s.equals("south")) {
            if(champion.y + 1 >= map.size) {
                map = new Map(champion);
                System.out.println("######## NEW MAP ########");
            } else {
                champion.storeX = champion.x;
                champion.storeY = champion.y;
                champion.y = champion.y + 1;
            }
            map.encounter(champion, map);
            map.resetMap();
            map.updateMap(champion);
            map.printMap(champion);
        } else if(s.equals("west")) {
            if(champion.x - 1 < 0) {
                map = new Map(champion);
                System.out.println("######## NEW MAP ########");
            } else {
                champion.storeX = champion.x;
                champion.storeY = champion.y;
                champion.x = champion.x - 1;
            }
            map.encounter(champion, map);
            map.resetMap();
            map.updateMap(champion);
            map.printMap(champion);
        } else {
            System.out.println(RED + "Please enter a valid direction" + RESET);
            map.resetMap();
            map.updateMap(champion);
            map.printMap(champion);
        }

        GameState.saveState(champion);
    }
}