package com.aetherwars.card.spell;

import com.aetherwars.card.Card;

public class LevelSpell extends Spell {
    private int levelChange;

    public LevelSpell(int id, String name, int mana, String description, int imagepath, int levelChange) {
        super(id, name, mana, description, imagepath);
        this.levelChange = levelChange;
    }

    public int getLevelChange(){
        return this.levelChange;
    }

    public void setLevelChange(int levelChange){
        this.levelChange = levelChange;
    }

    public void use(Card target) {
        // TODO: implement
    }
}
