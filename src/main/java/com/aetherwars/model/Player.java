package com.aetherwars.model;
import com.aetherwars.card.Card;
import com.aetherwars.card.Character.Character;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int HP ;
    private int mana;
    private int maxMana;
    private List<Card> handCard;
    private Character[] onBoardCard;
    private boolean isDeckEmpty;

    public Player(String name){
        this.name = name;
        this.HP = 80;
        this.mana = 1;
        this.maxMana = 1;
        this.handCard = new ArrayList<>();
        this.onBoardCard = new Character[5];
        for(int i=0;i<5;i++){
            this.onBoardCard[i] = null;
        }
        this.isDeckEmpty = true;
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
    public void addCard(Card card){
        //assume udah dihandle controller
        if(this.handCard.size()<5){
            this.handCard.add(card);
        }
        else{
            removeCard(0);
            this.handCard.add(card);
        }
    }
    public Card removeCard(int index){
        //asumsi: mulai dari 0
        Card card = this.handCard.remove(index);
        return card;
    }
    public void addToDeck(Character character,int index){
        //assume udah dihandle controller
        this.onBoardCard[index] = character;
        this.isDeckEmpty = false;
    }
    public Character removeFromDeck(int index){
        //asumsi: mulai dari 0
        Character chara = this.onBoardCard[index];
        this.onBoardCard[index] = null;
        boolean isEmpty = true;
        for(int i =0;i<5;i++){
            if(this.onBoardCard[index]!=null){
                isEmpty = false;
                break;
            }
        }
        if(isEmpty){
            this.isDeckEmpty = true;
        }
        return chara;
    }
    
    public boolean getIsDeckEmpty() {
    	return this.isDeckEmpty;
    }
}
