package com.swingy.model.characters;

import com.swingy.model.artifacts.*;
import java.util.Random;

public class Villain_Slime extends SuperVillain {
    Random rand = new Random();
    int increaseDefense = rand.nextInt(4);
    public Villain_Slime() {
        villainName = "slime";
        artifact = "Upgraded Weapon";
        drop = rand.nextInt(2);
        hitPoints = 10;
        attack = 7;
        armor = new Armor(artifact, increaseDefense);
    }
}