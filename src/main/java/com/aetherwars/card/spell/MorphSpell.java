package com.aetherwars.card.spell;

import com.aetherwars.card.Card;

public class MorphSpell extends Spell {
    public int target_id;

    public MorphSpell(int id, String name, int mana, String description, int imagepath, final int target_id) {
        super(id, name, mana, description, imagepath);
        this.target_id = target_id;
    }

    public int getTargetId() {
        return this.target_id;
    }

    public void setTargetId(final int target_id) {
        this.target_id = target_id;
    }

    public void use(Card target) {
        // TODO: implement
    }
}
