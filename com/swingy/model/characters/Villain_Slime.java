package com.swingy.model.characters;

import com.swingy.model.artifacts.*;
import java.util.Random;

public class Villain_Slime extends SuperVillain {
    Random rand = new Random();
    int increaseAttack = rand.nextInt(4) + 1;
    public Villain_Slime() {
        villainName = "slime";
        artifact = "Upgraded Weapon";
        drop = rand.nextInt(2);
        hitPoints = 10;
        attack = 7;
        weapon = new Weapon(artifact, increaseAttack);
    }
}