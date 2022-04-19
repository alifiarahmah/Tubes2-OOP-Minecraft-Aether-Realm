package com.aetherwars.card.spell;

import com.aetherwars.card.Character.Character;

public class MorphSpell extends Spell {
    public int target_id;

    public MorphSpell(int id, String name, int mana, String description, String imagepath, final int target_id) {
        super(id, name, mana, description, imagepath);
        this.target_id = target_id;
    }

    public int getTargetId() {
        return this.target_id;
    }

    public void setTargetId(final int target_id) {
        this.target_id = target_id;
    }

    @Override
    public void use(Character target) {
        /* MORPH (PERM):
        Mengubah sebuah karakter menjadi karakter lain dengan level 1 dengan exp 0.
        Seluruh spell yang menempel akan dibuang. */

        // TODO cari karakter baru dari daftar karakter
        // Character newCharacter = search(databasekarakter, id)
        target.setId(this.target_id);
        /* target.setCharacter(newCharacter); */
    }
}
