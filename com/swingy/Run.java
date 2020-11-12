package com.swingy;

import com.swingy.model.artifacts.*;
import com.swingy.model.characters.*;
import com.swingy.model.*;
import java.util.Scanner;

public class Run {
    // for now just running scripts to test classes

    static SuperChampion champion;
    static Map map;
    public static void main(String[] args) {
        // testing code for the main menu
        Scanner in = new Scanner(System.in);
        System.out.println("***************SWINGY***************");
        System.out.println("Would you like to CREATE NEW HERO[new] or LOAD HERO[load]");
        String choice = in.nextLine();
        if (choice.equals("new")) {
            heroSelect();
            map = new Map(champion);
        } else if(choice.equals("load")) {
            System.out.println("You currently have no save files");
        }
    }

    // this method allows the user to create their champion [might add this to a separate input class].
    public static void heroSelect() {
        Champion_Warrior baseWarrior = new Champion_Warrior();
        Champion_Elf baseElf = new Champion_Elf();
        Champion_Mage baseMage = new Champion_Mage();
        Scanner in = new Scanner(System.in);
        System.out.println("Choose ONE of the following hero classes: Warrior; Elf; Mage");
        System.out.println("Warrior -  atk: " + baseWarrior.attack + "  def: " + baseWarrior.defense + "  HP: " + baseWarrior.hitPoints);
        System.out.println("Elf -  atk: " + baseElf.attack + "  def: " + baseElf.defense + "  HP: " + baseElf.hitPoints);
        System.out.println("Mage -  atk: " + baseMage.attack + "  def: " + baseMage.defense + "  HP: " + baseMage.hitPoints);
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