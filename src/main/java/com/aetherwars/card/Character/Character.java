package com.aetherwars.card.Character;

import com.aetherwars.card.Card;

public class Character extends Card {
  private Type type; // Wajib
  private int exp;
  private int maxExpToNextLevel;
  private int level;
  private int attack; // Wajib
  private int attackUp;
  private float health; // Wajib
  private int healthUp;

  public Character(int id, String name, int mana, String description, int imagepath, Type element, int attack, int attackUp, float health, int healthUp) {
    super(id, name, mana, description, imagepath);
    this.type = element;
    this.exp = 0;
    this.level = 1;
    this.maxExpToNextLevel = 1;
    this.attack = attack;
    this.attackUp = attackUp;
    this.health = health;
    this.healthUp = healthUp;
  }
  public int getExp(){
    return this.exp;
  }
  public int getMaxExpToNextLevel(){
    return this.maxExpToNextLevel;
  }
  public int getAttack(){
    return this.attack;
  }
  public void setAttack(int attack){
    this.attack = attack;
  }
  public int getLevel(){
    return this.level;
  }
  public void setLevel(int level){
    this.level = level;
  }
  public float getHealth(){
    return this.health;
  }
  public void setHealth(float health){
    this.health = health;
  }
  public Type getType(){
    return this.type;
  }
  public void levelUp(){
    while (this.exp >= this.maxExpToNextLevel){
      this.level += 1;
      this.exp -= this.maxExpToNextLevel;
      this.maxExpToNextLevel += 2;
      this.attack += this.attackUp;
      this.health += this.healthUp;
    }
  }
  public void attack(Character character){
    switch (this.type){
      case OVERWORLD:
        // Overworld kuat terhadap End
        if (character.type.equals(Type.END)){
          character.setHealth(health - (this.attack * 2));
        } 
        // Overworld lemah terhadap Nether
        else if (character.type.equals(Type.NETHER)){
          character.setHealth((float)(health - ((this.attack * 0.5))));
        }
        else {
          character.setHealth(health - this.attack);
        }
        // Update Exp 
        if (character.health <= 0){
          this.exp += character.level;
          levelUp();
        }
      case NETHER:
        // Nether kuat terhadap Overworld
        if (character.type.equals(Type.OVERWORLD)){
          character.setHealth(health - (this.attack * 2));
        } 
        // Nether lemah terhadap End
        else if (character.type.equals(Type.END)){
          character.setHealth((float)(health - ((this.attack * 0.5))));
        }
        else {
          character.setHealth(health - this.attack);
        }

        // Update Exp 
        if (character.health <= 0){
          this.exp += character.level;
          levelUp();
        }
      case END:
        // End kuat terhadap Nether
        if (character.type.equals(Type.NETHER)){
          character.setHealth(health - (this.attack * 2));
        } 
        // End lemah terhadap Overworld
        else if (character.type.equals(Type.OVERWORLD)){
          character.setHealth((float)(health - ((this.attack * 0.5))));
        }
        else {
          character.setHealth(health - this.attack);
        }

        // Update Exp 
        if (character.health <= 0){
          this.exp += character.level;
          levelUp();
        }
      default: 
        character.setHealth(health - this.attack);
    }
  }
}
