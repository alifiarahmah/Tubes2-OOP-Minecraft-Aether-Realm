package com.aetherwars.card.Character;

import com.aetherwars.card.Card;
import com.aetherwars.card.Summonable;

public class Character extends Card implements Summonable {
  private Type type; // Wajib
  private int atk_0; //Simpan baseAttack saat level 1 (Nilai tidak akan pernah berubah)
  private int attackUp;
  private float hp_0; // Simpan baseHealth saat level 1 (Nilai tidak akan pernah berubah)
  private int healthUp;

  public Character(int id, String name, int mana, String description, String imagepath, Type element, int attack, int attackUp, float health, int healthUp) {
    super(id, name, mana, description, imagepath);
    this.type = element;
    this.atk_0 = attack;
    this.attackUp = attackUp;
    this.hp_0 = health;
    this.healthUp = healthUp;
  }
  public Type getType(){
    return this.type;
  }
  public int getBaseAtk(){
    return this.atk_0;
  }
  public int getAttackUp(){
    return this.attackUp;
  }
  public float getBaseHealth(){
    return this.hp_0;
  }
  public int getHealthUp(){
    return this.healthUp;
  }
  
}
