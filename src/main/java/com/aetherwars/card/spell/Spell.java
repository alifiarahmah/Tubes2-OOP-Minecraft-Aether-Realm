package com.aetherwars.card.spell;

import com.aetherwars.card.Card;

public abstract class Spell extends Card {
    public Spell(int id, String name, int mana, String description, int imagepath){
        super(id, name, mana, description, imagepath);
    }

    public abstract void use(Card target);
}