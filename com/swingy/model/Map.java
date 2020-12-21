package com.swingy.model;

import com.swingy.model.characters.*;
import com.swingy.model.battle.*;
import java.util.ArrayList;
import java.util.Random;

public class Map {
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_RESET = "\u001B[0m";
    static public int size;
    static public int[][] map;
    static SuperVillain villain;
    static VillainEncounter encounter;
    ArrayList<SuperVillain> villains = new ArrayList<SuperVillain>();
    ArrayList<SuperVillain> toRemove = new ArrayList<SuperVillain>();

    public Map(SuperChampion champion) {
        size = (champion.level - 1) * 5 + 10 - (champion.level % 2);
        map = new int[size][size];
        champion.x = (size / 2);
        champion.y = (size / 2);
        villainPosition(champion);
    }

    public void villainPosition(SuperChampion champion) {
        Random rand = new Random();
        int villainCount = 3*size;
        int counter = 0;
        int typeCount = 0;
        int x;
        int y;
        while(counter < villainCount) {
            x = rand.nextInt(size);
            y = rand.nextInt(size);
            while (x == champion.x && y == champion.y) {
                x = rand.nextInt(size);
                y = rand.nextInt(size);
            }
            for (SuperVillain vil : villains) {
                while (x == vil.x && y == vil.y) {
                    x = rand.nextInt(size);
                    y = rand.nextInt(size);
                    while (x == champion.x && y == champion.y) {
                        x = rand.nextInt(size);
                        y = rand.nextInt(size);
                    }
                }
            }
            if ((typeCount < villainCount/3)) {
                villain = new Villain_Slime();
                villain.x = x;
                villain.y = y;
                villains.add(villain);
                typeCount++;
            }else if ((typeCount >= villainCount/3) && (typeCount < (villainCount/3 + villainCount/3))) {
                villain = new Villain_Wraith();
                villain.x = x;
                villain.y = y;
                villains.add(villain);
                typeCount++;
            }else if ((typeCount >= (villainCount/3 + villainCount/3)) && (typeCount < villainCount)) {
                villain = new Villain_Dragon();
                villain.x = x;
                villain.y = y;
                villains.add(villain);
                typeCount++;
            }
             counter++;
        }
        updateMap(champion);
        printMap(champion);
    }

    public void updateMap(SuperChampion champion){
        for (int i=0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == champion.y && j == champion.x) {
                    map[i][j] = 2;
                }
                for (SuperVillain vil : villains) {
                    if (i == vil.y && j == vil.x) {
                        if(map[i][j] == 2) {

                        } else {
                            map[i][j] = 1;
                        }
                    } else if (map[i][j] == 1 || map[i][j] == 2) {
                    } else {
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    public void printMap(SuperChampion champion) {
        System.out.println("\n");
        System.out.println(champion.heroName + "(" + champion.heroClass + ")" + "\t\t\t" + "HP: " + champion.hitPoints);
        System.out.println("Level " + champion.level +  "\t\t\t" + "Def: " + champion.defense);
        System.out.println("Xp: " + champion.experience + "\t\t\t" + "Atk: " + champion.attack);
        System.out.println("\n");
        for (int i=0; i < size; i++) {
            for (int j=0; j < size ; j++) {
                if (map[i][j] == 1) {
                    System.out.print(TEXT_RED + map[i][j] + TEXT_RESET + " ");
                } else if (map[i][j] == 2) {
                    System.out.print(TEXT_GREEN + map[i][j] + TEXT_RESET + " ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println("\n");
        }
    }

    public void resetMap() {
        for (int i=0; i < size; i++) {
            for (int j=0; j < size ; j++) {
                map[i][j] = 0;
            }
        }
    }

    public void encounter(SuperChampion champion, Map runMap) {
        if (map[champion.y][champion.x] == 1){
            for (SuperVillain vil: villains) {
                if(vil.y == champion.y && vil.x == champion.x) {
                    encounter = new VillainEncounter(champion, vil, runMap);
                    if(vil.hitPoints <= 0){
                        toRemove.add(vil);
                    }
                }
            }
            villains.removeAll(toRemove);
        }
    }
}