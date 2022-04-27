package com.aetherwars.card;
import com.aetherwars.card.spell.Spell;
import com.aetherwars.card.spell.*;
import java.util.ArrayList;
import java.util.List;
import com.aetherwars.event.*;

import com.aetherwars.card.Character.Character;
import com.aetherwars.card.Character.Type;
import com.aetherwars.model.Player;

public class SummonedCharacter implements Summoned, Publisher {
    private Character charCard;
    private int attack; 
    private float health; 
    private float maxHealth; 
    private int slot;
    private int level;
    private int exp;
    private int maxExpToNextLevel;
    private List<SummonedSpell> activeSpells;
    
    BoardChannel channel;

    public SummonedCharacter(Character charCard, int slot){
        this.charCard = charCard;
        this.attack = charCard.getBaseAtk();
        this.health = charCard.getBaseHealth();
        this.maxHealth = charCard.getBaseHealth();
        this.slot = slot;
        this.level = 1;
        this.exp = 0;
        this.maxExpToNextLevel = 1;
        this.activeSpells = new ArrayList<SummonedSpell>();
    }
    public int getAttack(){
        return this.attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public float getHealth(){
        return this.health;
    }
    public void setHealth(float health){
        this.health = health;
    }
    public float getMaxHealth(){
        return this.maxHealth;
    }
    public int getSlot(){
        return this.slot;
    }
    public int getLevel(){
        return this.level;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public int getExp(){
        return this.exp;
    }
    public void setExp(int exp){
        this.exp = exp;
    }
    public int getMaxExpToNextLevel(){
        return this.maxExpToNextLevel;
    }
    public List<SummonedSpell> getActiveSpells(){
        return this.activeSpells;
    }

    public void levelUp(){
    while (this.exp >= this.maxExpToNextLevel){
          this.level += 1;
          this.exp -= this.maxExpToNextLevel;
          this.maxExpToNextLevel += 2;
          this.attack = this.charCard.getBaseAtk() + (this.charCard.getAttackUp() * (this.level - 1));
          this.health = this.charCard.getBaseHealth() + (this.charCard.getHealthUp() * (this.level - 1));
          this.maxHealth = this.health;
        }
    }
    public Card getBaseCard(){
        return this.charCard;
    }
    public void attack(SummonedCharacter summonedCharacter){
        switch (this.charCard.getType()){
            case OVERWORLD:
                // Overworld kuat terhadap End
                if (summonedCharacter.charCard.getType().equals(Type.END)){
                summonedCharacter.setHealth(health - (this.attack * 2));
                } 
                // Overworld lemah terhadap Nether
                else if (summonedCharacter.charCard.getType().equals(Type.NETHER)){
                summonedCharacter.setHealth((float)(health - ((this.attack * 0.5))));
                }
                else {
                summonedCharacter.setHealth(health - this.attack);
                }
                // Update Exp 
                if (summonedCharacter.health <= 0){
                this.exp += summonedCharacter.level;
                levelUp();
                }
            case NETHER:
                // Nether kuat terhadap Overworld
                if (summonedCharacter.charCard.getType().equals(Type.OVERWORLD)){
                    summonedCharacter.setHealth(health - (this.attack * 2));
                } 
                // Nether lemah terhadap End
                else if (summonedCharacter.charCard.getType().equals(Type.END)){
                    summonedCharacter.setHealth((float)(health - ((this.attack * 0.5))));
                }
                else {
                    summonedCharacter.setHealth(health - this.attack);
                }
    
                // Update Exp 
                if (summonedCharacter.health <= 0){
                this.exp += summonedCharacter.level;
                levelUp();
                }
            case END:
                // End kuat terhadap Nether
                if (summonedCharacter.charCard.getType().equals(Type.NETHER)){
                    summonedCharacter.setHealth(health - (this.attack * 2));
                } 
                // End lemah terhadap Overworld
                else if (summonedCharacter.charCard.getType().equals(Type.OVERWORLD)){
                    summonedCharacter.setHealth((float)(health - ((this.attack * 0.5))));
                }
                else {
                    summonedCharacter.setHealth(health - this.attack);
                }
        
                // Update Exp 
                if (summonedCharacter.health <= 0){
                this.exp += summonedCharacter.level;
                levelUp();
                }
            default: 
                summonedCharacter.setHealth(health - this.attack);
        }
    }
    public void attack(Player player){
        player.setHP(player.getHP() - this.attack);
        if (player.getHP() <= 0) {
            // END GAME
        }
    }
    public void addSpellToChar(SummonedSpell spell){
        this.activeSpells.add(spell);
        Spell sp = (Spell) spell.getBaseCard();
        if (sp instanceof SwapSpell) {
            // SWAP
        } else if (sp instanceof LevelSpell) {
            // LEVEL
        } else if (sp instanceof MorphSpell) {
            // MORPH
        } else {
            // POTION
        }
    }
    public void removeSpellFromChar(SummonedSpell spell){
        this.activeSpells.remove(spell);
        Spell ssp = (Spell) spell.getBaseCard();
        if (ssp instanceof SwapSpell) {
            // UNDO SWAP
        }
    }
    public void removeCard(){
        // Remove all active spells first
        for (SummonedSpell sp : activeSpells) {
            sp.publish(new DestroySummonedCardEvent(sp));
        }
        // Remove character card
        publish(new DestroySummonedCardEvent(this));
    }
    public void setChannel(BoardChannel channel) {
        this.channel = channel;
    }
    @Override
    public void publish(Event event){
        // this.channel.sendEvent(this, event);
    }
}
