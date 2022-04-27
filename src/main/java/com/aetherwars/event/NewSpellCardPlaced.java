package com.aetherwars.event;

import com.aetherwars.card.spell.Spell;

public class NewSpellCardPlaced implements Event {
    Spell spell;

    public NewSpellCardPlaced(Spell spell) {
        this.spell = spell;
    }

    @Override
    public Object getInfo() {
        return this.spell;
    }
}
