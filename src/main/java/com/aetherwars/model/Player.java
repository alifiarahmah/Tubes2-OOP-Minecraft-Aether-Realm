package com.aetherwars.model;
import com.aetherwars.card.Card;
import com.aetherwars.card.Character.Character;
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
    public void attack(Player p,Character c){
        if(p.getBoardCharacter().length>0){
            //ada karakter di board lawan
            //hanya bisa serang karakter
        }
        else{
            //gak ada karakter di board lawan
            //bisa langsung serang hp

            //p.setHP(p.getHP()-c.getATK())
        }
    }
    public void setMaxMana(){
        this.maxMana++;
    }
    public Character[] getBoardCharacter(){
        return this.onBoardCard;
    }
    public void setHP(int hp){
        this.HP = hp;
    }
    public int getHP(){
        return this.HP;
    }

}
