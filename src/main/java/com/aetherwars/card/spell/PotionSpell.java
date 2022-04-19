package com.aetherwars.card.spell;

import com.aetherwars.card.Character.Character;

public class PotionSpell extends Spell {
    private int attack;
    private int health;
    private int duration;

    public PotionSpell(int id, String name, int mana, String description, String imagepath, int attack, int health, int duration) {
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

    @Override
    public void use(Character target) {
        /* PTN / Potion (TEMP):
        Meningkatkan atribut attack dan / atau health.
        Penambahan ini dapat bernilai 0 bahkan negatif.
        Penambahan health dilakukan secara bertumpuk, sehingga serangan musuh akan
        mengambil health dari efek potion terakhir terlebih dahulu sebelum health dari karakter
        atau efek potion sebelumnya. Pengurangan health dapat membunuh karakter.
        Pengurangan attack tidak akan membuat attack karakter kurang dari 0. */

        target.setHealth(target.getHealth() + this.health);
        target.setAttack(target.getAttack() + this.attack);
    }
}
