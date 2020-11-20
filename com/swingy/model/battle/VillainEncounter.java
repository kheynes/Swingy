package com.swingy.model.battle;

import com.swingy.model.artifacts.*;
import com.swingy.model.characters.*;
import com.swingy.model.*;
import java.util.Scanner;
import java.util.Random;

public class VillainEncounter {
    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    public VillainEncounter(SuperChampion champion, SuperVillain villain) {
        System.out.println("You have encountered a " + villain.villainName + "!");
        System.out.println("HP: " +villain.hitPoints);
        System.out.println("What will you do ? Fight(fight) or Run(run)");
        String choice = in.nextLine();
        if(choice.equals("run")) {
            System.out.println("figure out how to go back to previous position");
        } else if (choice.equals("fight")) {
            while (champion.hitPoints > 0 && villain.hitPoints > 0) {
                playerAttack(champion, villain);
                villainAttack(champion, villain);
            }
            if (champion.hitPoints <= 0) {
                System.out.println("<YOU ARE DEAD!>");
            } else if (villain.hitPoints <= 0) {
                System.out.println("You defeated the villain!");
                if (villain.drop == 1) {
                    System.out.println ("The " + villain.villainName + " dropped an " + villain.artifact);
                    if (villain.artifact.equals("Upgraded Armor")) {
                        System.out.println("Defence before: " + champion.defense);
                        champion.defense= champion.defense + villain.armor.defenseBoost;
                        System.out.println("Defence after: " + champion.defense);
                    } else if (villain.artifact.equals("Upgraded Helm")) {
                        System.out.println("HP before: " + champion.hitPoints);
                        champion.hitPoints = champion.hitPoints + villain.helm.hitPointsBoost;
                        System.out.println("HP after: " + champion.hitPoints);
                    } else if (villain.artifact.equals("Upgraded Weapon")) {
                        System.out.println("AD before: " + champion.attack);
                        champion.attack = champion.attack + villain.weapon.attackBoost;
                        System.out.println("AD after: " + champion.attack);
                    }
                }
            }
        }
    }

    public void playerAttack(SuperChampion champion, SuperVillain villain) {
        int playerDamage = rand.nextInt(champion.attack);
        villain.hitPoints = villain.hitPoints - playerDamage;
    }

    public void villainAttack(SuperChampion champion, SuperVillain villain) {
        int villainDamage = rand.nextInt(villain.attack);
        if (villainDamage > champion.defense) {
            villainDamage = villainDamage - champion.defense;
        } else {
            villainDamage = 0;
        }
        champion.hitPoints = champion.hitPoints - villainDamage;
    }
}