package com.swingy.model.characters;

import com.swingy.model.artifacts.*;

public class Champion_Mage extends SuperChampion {
    public Champion_Mage() {
        heroClass = "Mage";
        level = 1;
        experience = 0;
        attack = 6;
        defense = 10;
        hitPoints = 50;
        armor = new Armor("Mage armor", 0);
        helm = new Helm("Mage helm", 0);
        weapon = new Weapon("Staff", 0);
    }
}