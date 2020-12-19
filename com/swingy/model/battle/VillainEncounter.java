package com.swingy.model.battle;

import com.swingy.model.characters.*;;
import java.util.Scanner;
import java.util.Random;
import com.swingy.model.*;

public class VillainEncounter {
    Scanner in = new Scanner(System.in);
    Random rand = new Random();
    private int run;
    public VillainEncounter(SuperChampion champion, SuperVillain villain, Map map) {
        System.out.println("You have encountered a " + villain.villainName + "!");
        System.out.println("HP: " +villain.hitPoints);
        System.out.println("What will you do ? Fight(fight) or Run(run)");
        String choice = in.nextLine();
        run = rand.nextInt(2);
        if(choice.equals("run") && run == 1) {
            champion.x = champion.storeX;
            champion.y = champion.storeY;
            map.resetMap();
            map.updateMap(champion);
            map.printMap();
        }  else if (choice.equals("run") && run == 0) {
            System.out.println("You try to run but the monster quickly blocks your path and engages in battle!");
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