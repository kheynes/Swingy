package com.swingy.model.battle;

import com.swingy.model.artifacts.*;
import com.swingy.model.characters.*;
import com.swingy.model.*;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

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
                champion.experience += villain.experienceDrop;
                if (champion.experience >= champion.level * 1000 + ((champion.level-1)*(champion.level-1)) * 450) {
                    champion.level += 1;
                }
                if (villain.drop == 1) {
                    System.out.println ("The " + villain.villainName + " dropped an " + villain.artifact);
                    if (villain.artifact.equals("Upgraded Armor")) {
                        champion.defense= champion.defense + villain.armor.defenseBoost;
                        System.out.println("You gain " + villain.armor.defenseBoost + " defense points!");
                    } else if (villain.artifact.equals("Upgraded Helm")) {
                        champion.hitPoints = champion.hitPoints + villain.helm.hitPointsBoost;
                        System.out.println("You gain " + villain.helm.hitPointsBoost + " hit points!");
                    } else if (villain.artifact.equals("Upgraded Weapon")) {
                        champion.attack = champion.attack + villain.weapon.attackBoost;
                        System.out.println("You gain " + villain.weapon.attackBoost + " attack points!");
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