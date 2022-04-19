package com.aetherwars.card.spell;

import com.aetherwars.card.Character.Character;

public class SwapSpell extends Spell {
    private int duration;

    public SwapSpell(int id, String name, int mana, String description, String imagepath, int duration) {
        super(id, name, mana, description, imagepath);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public void use(Character target) {
        /* SWAP (TEMP): Menukar attack dan health. 
        Khusus untuk swap, apabila digunakan pada karakter yang telah memiliki efek swap 
        maka durasinya yang akan bertambah, dan bukan dilakukan swap balik. 
        Perhatikan: apabila sebelum swap attack suatu karakter adalah 0, maka setelah swap, karakter tersebut mati. */
        // TODO: append lagi dapet efek potion swap ke target
        int temp = target.getAttack();
        target.setAttack((int)target.getHealth());
        target.setHealth(temp);
    }
}
