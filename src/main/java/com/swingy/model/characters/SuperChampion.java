package com.swingy.model.characters;

import javax.validation.constraints.*;

public class SuperChampion {

    @NotNull
    @NotBlank
    public String heroName = null;

    @NotNull
    @NotBlank
    public String heroClass = null;
    public int level;
    public int experience;
    public int attack;
    public int defense;
    public int hitPoints;
    public int x;
    public int y;
    public int storeX;
    public int storeY;
}