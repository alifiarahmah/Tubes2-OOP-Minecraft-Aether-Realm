package com.aetherwars.model;
public class Player {
    private String name;
    private int HP ;
    private int mana;
    private int maxMana;
    private Card[] handCard;
    private Character[] onBoardCard;

    public Player(String name){
        this.name = name;
        this.HP = 80;
        this.mana = 1;
        this.maxMana = 1;
        this.handCard = new Card[5];
        this.onBoardCard = new Character[5];
    }
    public void attack(){

    }
    public void setMaxMana(){

    }
}
