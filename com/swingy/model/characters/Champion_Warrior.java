package com.swingy.model.characters;

import com.swingy.model.artifacts.*;

public class Champion_Warrior extends SuperChampion {
    public Champion_Warrior() {
        heroClass = "Warrior";
        level = 1;
        experience = 0;
        attack = 8;
        defense = 8;
        hitPoints = 50;
        armor = new Armor("Warrior armor", 0);
        helm = new Helm("Warrior helm", 0);
        weapon = new Weapon("Long Sword", 0);
    }
}