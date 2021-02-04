package com.swingy.controller;

import java.io.*;

import com.swingy.model.characters.*;
import com.swingy.model.*;
import com.swingy.view.Console;

public class GameState {
    public static PrintWriter writer;

    public static void saveState (SuperChampion champion) throws IOException {
        writer = new PrintWriter(new FileWriter("src/main/java/com/swingy/save.txt"));
        writer.println("Class " + champion.heroClass);
        writer.println("Name " + champion.heroName);
        writer.println("Level " + champion.level);
        writer.println("XP " + champion.experience);
        writer.println("ATK " + champion.attack);
        writer.println("DEF " + champion.defense);
        writer.println("HP " + champion.hitPoints);
        writer.println("POSX " + (champion.x+1));
        writer.println("POSY " + (champion.y+1));
        writer.println("END");
        writer.close();

    }

    public static void loadState () throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/swingy/save.txt"));
        String line = reader.readLine();
        SuperChampion champion = new SuperChampion();

        while (!line.equals("END")) {
            if (line.split(" ")[0].equals("Class")) {
                String type = line.split(" ")[1];
                if (type.equals("Warrior")) {
                    champion = new Champion_Warrior();
                } else if (type.equals("Elf")) {
                    champion = new Champion_Elf();
                } else if (type.equals("Mage")) {
                    champion = new Champion_Mage();
                }
                champion.heroClass = line.split(" ")[1];
            }
            if (line.split(" ")[0].equals("Name"))
                champion.heroName = line.split(" ")[1];
            if (line.split(" ")[0].equals("Level"))
                champion.level = Integer.parseInt(line.split(" ")[1]);
            if (line.split(" ")[0].equals("XP"))
                champion.experience = Integer.parseInt(line.split(" ")[1]);
            if (line.split(" ")[0].equals("ATK"))
                champion.attack = Integer.parseInt(line.split(" ")[1]);
            if (line.split(" ")[0].equals("DEF"))
                champion.defense = Integer.parseInt(line.split(" ")[1]);
            if (line.split(" ")[0].equals("HP"))
                champion.hitPoints = Integer.parseInt(line.split(" ")[1]);
            if (line.split(" ")[0].equals("POSX"))
                champion.x = Integer.parseInt(line.split(" ")[1]);
            if (line.split(" ")[0].equals("POSY"))
                champion.y = Integer.parseInt(line.split(" ")[1]);
            line = reader.readLine();
        }
        Map map = new Map(champion);
        while(champion.hitPoints > 0) {
            Console.championMove(champion, map);
        }
        if(champion.hitPoints <= 0) {
            System.out.println("GAME OVER");
        }
    }
}
