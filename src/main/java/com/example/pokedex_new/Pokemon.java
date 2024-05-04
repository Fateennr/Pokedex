package com.example.pokedex_new;

public class Pokemon {


    private int id;
    private String name;

    private String type;

    private String color = "#FFFFFF";
    private String typecolor = "#FFFFFF";

    private int hp;

    private int attack;
    private int defense;

    private int sp_atk;
    private int sp_def;

    private int speed;

    private int total;

    // for additional information
    private String species;
    private String heightinfo;
    private String weightinfo;

    private String ability;

    private float catchrate;


    public void setColor(String type)
    {
        switch (type) {
            case "Fire":
                this.color = "#FB6C6C";
                this.typecolor = "#9e4444";
                break;
            case "Electric":
                this.color = "#FFD451";
                this.typecolor = "#bf9f3d";
                break;
            case "Grass":
                this.color = "#48D0B0";
                this.typecolor = "#318571";
                break;
            case "Water":
                this.color = "#77BDFE";
                this.typecolor = "#416587";
                break;
            case "Bug":
                this.color = "#B7C43E";
                this.typecolor = "#6b7322";
                break;
            case "Ghost":
                this.color = "#B76DA3";
                this.typecolor = "#6b3f5f";
                break;
            case "Fairy":
                this.color = "#F1A7EC";
                this.typecolor = "#a66ca2";
                break;
            default:
                // Handle other types or unknown types here
                this.color = "#4152CC";
                break;
        }
    }

    public void setType(String type) {
        this.type = type;
        setColor(type);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHP(int hp) {
        this.hp= hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpecialAttack(int anInt) {
        this.sp_atk = anInt;
    }

    public void setSpecialDefense(int anInt) {
        this.sp_def = anInt;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void settotal(int total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getTypecolor() {
        return typecolor;
    }

    public String getType() {
        return type;
    }


    public int getTotal() {
        return total;
    }

    public int getAttack() {

        return attack;
    }

    public int getDefense() {

        return defense;
    }
}
