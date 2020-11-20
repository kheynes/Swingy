package com.swingy.model.characters;

import com.swingy.model.artifacts.*;
import java.util.Random;

public class Villain_Wraith extends SuperVillain {
    Random rand = new Random();
    int increaseDefense = rand.nextInt(4);
    public Villain_Wraith() {
        villainName = "Wraith";
        artifact = "Upgraded Helm";
        drop = rand.nextInt(2);
        hitPoints = 20;
        attack = 15;
        armor = new Armor(artifact, increaseDefense);
    }
}