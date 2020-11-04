package com.swingy.model.characters;

import com.swingy.model.artifacts.*;

public class Champion_Elf extends SuperChampion {

    public Champion_Elf() {
        heroClass = "Elf";
        level = 1;
        experience = 0;
        attack = 5;
        defense = 2;
        hitPoints = 10;
        armor = new Armor("Elf armor", 0);
        helm = new Helm("Elf helm", 0);
        weapon = new Weapon("Bow and Arrow", 0);
    }
}