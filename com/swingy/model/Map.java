package com.swingy.model;

import com.swingy.model.characters.*;

public class Map {
    static public int size;
    static public int[][] map;

    public Map(SuperChampion champion) {
        size = (champion.level - 1) * 5 + 10 - (champion.level % 2);
        map = new int[size][size];
        champion.x = (size / 2) + 1;
        champion.y = (size / 2) + 1;
    }

    public villainPosition() {
        private int villainCount = size / 3;
        int counter = 0;
        while(counter < villainCount) {
            
        }
    }
}



// int villains = random thing(5)
// int counter
// while (counter < villains)
// -->xy values
// --> recursive check(xy)
// --> make SuperVillain
// --> superVillain.x and superVillain.y = xy
// --> add to list