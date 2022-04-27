package com.aetherwars.card.spell;

import com.aetherwars.card.Character.Character;

public class LevelSpell extends Spell {
    private int levelChange;

    public LevelSpell(int id, String name, int mana, String description, String imagepath, int levelChange) {
        super(id, name, mana, description, imagepath);
        this.levelChange = levelChange;
    }

    public int getLevelChange(){
        return this.levelChange;
    }

    public void setLevelChange(int levelChange){
        this.levelChange = levelChange;
    }

    @Override
    public void use(Character target) {
        /* (PERM):
        Meningkatkan/menurunkan level dari sebuah karakter sebanyak 1 serta mereset exp (membuat exp menjadi 0).
        Batas minimal level tetap 1 dan maksimal tetap 10. */

        if (target.getMana() >= this.getMana()) {
            target.setLevel(this.getLevelChange() > 0
                    ? Math.min(target.getLevel() + this.levelChange, 10)
                    : Math.max(target.getLevel() + this.levelChange, 1)
            );
            target.setMana(target.getMana() - this.getMana());
            target.setExp(0);
        } else {
            System.out.println("Not enough mana!");
        }
    }
}
