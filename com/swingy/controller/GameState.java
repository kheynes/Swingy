package com.swingy.controller;

import java.io.*;

import com.swingy.model.characters.*;

public class GameState {
    public static PrintWriter writer;

    public static void saveState (SuperChampion champion) throws IOException {
        writer = new PrintWriter(new FileWriter("com/swingy/save.txt"));
        writer.println("Name " + champion.heroName);
        writer.println("Class " + champion.heroClass);
        writer.println("Level " + champion.level);
        writer.println("XP " + champion.experience);
        writer.println("ATK " + champion.attack);
        writer.println("DEF " + champion.defense);
        writer.println("HP " + champion.hitPoints);
        writer.println("POSX " + (champion.x+1));
        writer.println("POSY " + (champion.y+1));
        writer.close();

    }
}
