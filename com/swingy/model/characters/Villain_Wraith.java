package com.swingy.model.characters;

import com.swingy.model.artifacts.*;
import java.util.Random;

public class Villain_Wraith extends SuperVillain {
    Random rand = new Random();
    int increaseHP = rand.nextInt(10) + 1;
    public Villain_Wraith() {
        villainName = "Wraith";
        artifact = "Upgraded Helm";
        drop = rand.nextInt(2);
        hitPoints = 20;
        attack = 15;
        helm = new Helm (artifact, increaseHP);
    }
}