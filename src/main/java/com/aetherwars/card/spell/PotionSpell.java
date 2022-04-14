package com.aetherwars.card.spell;

import com.aetherwars.card.Card;

public class PotionSpell extends Spell {
    private int attack;
    private int health;
    private int duration;

    public PotionSpell(int id, String name, int mana, String description, int imagepath, int attack, int health, int duration) {
        super(id, name, mana, description, imagepath);
        this.attack = attack;
        this.health = health;
        this.duration = duration;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void use(Card target) {
        // TODO: implement
    }

}
