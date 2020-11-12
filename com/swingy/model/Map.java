package com.swingy.model;

import com.swingy.model.characters.*;
import java.util.ArrayList;
import java.util.Random;

public class Map {
    static public int size;
    static public int[][] map;
    static SuperVillain villain;

    public Map(SuperChampion champion) {
        size = (champion.level - 1) * 5 + 10 - (champion.level % 2);
        map = new int[size][size];
        champion.x = (size / 2) + 1;
        champion.y = (size / 2) + 1;
        villainPosition(champion);
    }

    public void villainPosition(SuperChampion champion) {
        Random rand = new Random();
        ArrayList<SuperVillain> villains = new ArrayList<SuperVillain>();
        int villainCount = 3*size;
        System.out.println(villainCount);
        int counter = 0;
        int typeCount = 0;
        int x;
        int y;
        int randomGen = size*size;
        while(counter < villainCount) {
            x = rand.nextInt(randomGen);
            y = rand.nextInt(randomGen);
            while (x == champion.x && y == champion.y) {
                x = rand.nextInt(size);
                y = rand.nextInt(size);
            }
            for (SuperVillain vil : villains) {
                if (x == vil.x && y == vil.y) {
                    x = rand.nextInt(randomGen);
                    y = rand.nextInt(randomGen);
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
        for (SuperVillain vil: villains) {
            System.out.println(vil.villainName + " " + vil.x + " " + vil.y);
        }
    }
}
