package com.swingy.model.characters;

import com.swingy.model.artifacts.*;
import java.util.Random;

public class Villain_Dragon extends SuperVillain {
    Random rand = new Random();
    int increaseDefense = rand.nextInt(2) + 1;
    public Villain_Dragon() {
        villainName = "Dragon";
        artifact = "Upgraded Armor";
        drop = rand.nextInt(2);
        hitPoints = 30;
        attack = 20;
        experienceDrop = 200;
        armor = new Armor(artifact, increaseDefense);
    }
}