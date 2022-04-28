package com.aetherwars.card.spell;
import com.aetherwars.card.Card;
import com.aetherwars.card.Character.Character;
import com.aetherwars.card.SummonedCharacter;

public abstract class Spell extends Card {
    public Spell(int id, String name, int mana, String description, String imagepath){
        super(id, name, mana, description, imagepath);
    }

    public abstract void use(SummonedCharacter target);

}