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
    public void attack(Player p,Character c_self,Character c_enemy){
        if(c_enemy!=null){
            //ada karakter di board lawan
            //hanya bisa serang karakter
            c_self.attack(c_enemy);
        }
        else{
            //gak ada karakter di board lawan
            //bisa langsung serang hp
            p.setHP(Math.max(p.getHP()-c_self.getAttack(),0));
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
