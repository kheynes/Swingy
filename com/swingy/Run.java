package com.swingy;

import com.swingy.model.artifacts.*;
import com.swingy.model.characters.*;
import java.util.Scanner;

public class Run {
    // for now just running scripts to test classes

    static SuperChampion champion;
    public static void main(String[] args) {
        heroSelect();

        // testing code for the main menu

    }

    // this method allows the user to create their champion [might add this to a separate input class].
    public static void heroSelect() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose ONE of the following hero classes: Warrior; Elf; Mage");
        String s = in.nextLine();
        if(s.equals("Warrior")) {
            champion = new Champion_Warrior();
            System.out.println("Enter a name for your champion: ");
            champion.heroName = in.nextLine();
            System.out.println("Welcome to the game " + champion.heroName + " the warrior!");
            System.out.println("Your armour stats are: " + champion.armor.name + " " + champion.armor.defenseBoost + " stat boost");
            System.out.println("Your helm stats are: " + champion.helm.name + " " + champion.helm.hitPointsBoost + " stat boost");
            System.out.println("Your weapon stats are: " + champion.weapon.name + " " + champion.weapon.attackBoost + " stat boost");
        } else if(s.equals("Elf")) {
            champion = new Champion_Elf();
            System.out.println("Enter a name for your champion: ");
            champion.heroName = in.nextLine();
            System.out.println("Welcome to the game " + champion.heroName + " the elf!");
            System.out.println("Your armour stats are: " + champion.armor.name + " " + champion.armor.defenseBoost + " stat boost");
            System.out.println("Your helm stats are: " + champion.helm.name + " " + champion.helm.hitPointsBoost + " stat boost");
            System.out.println("Your weapon stats are: " + champion.weapon.name + " " + champion.weapon.attackBoost + " stat boost");
        } else if(s.equals("Mage")) {
            champion = new Champion_Mage();
            System.out.println("Enter a name for your champion: ");
            champion.heroName = in.nextLine();
            System.out.println("Welcome to the game " + champion.heroName + " the mage!");
            System.out.println("Your armour stats are: " + champion.armor.name + " " + champion.armor.defenseBoost + " stat boost");
            System.out.println("Your helm stats are: " + champion.helm.name + " " + champion.helm.hitPointsBoost + " stat boost");
            System.out.println("Your weapon stats are: " + champion.weapon.name + " " + champion.weapon.attackBoost + " stat boost");
        }
    }
}