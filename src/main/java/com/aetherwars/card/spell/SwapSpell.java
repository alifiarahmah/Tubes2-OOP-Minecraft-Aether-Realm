package com.aetherwars.card.spell;

import com.aetherwars.card.Card;

public class SwapSpell extends Spell {
    private int duration;

    public SwapSpell(int id, String name, int mana, String description, int imagepath, int duration) {
        super(id, name, mana, description, imagepath);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void use(Card target) {
        // TODO: implement
    }
}
