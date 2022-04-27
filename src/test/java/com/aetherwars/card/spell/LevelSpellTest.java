package com.aetherwars.card.spell;

import com.aetherwars.card.Character.Character;
import com.aetherwars.card.Character.Type;
import junit.framework.TestCase;
import org.junit.Test;

public class LevelSpellTest extends TestCase {

    @Test
    public void testLevelUp() {
        Spell spell = new LevelSpell(1, "LvlUp1", 4, "", "", 1);
        Character character = new Character(1, "", 5, "", "",
                Type.OVERWORLD, 10, 2, 3, 5);
        spell.use(character);
        assertEquals(2, character.getLevel());
        assertEquals(1, character.getMana());
    }

    @Test
    public void testLevelDown() {
        Spell spell = new LevelSpell(1, "LvlDown1", 3, "", "", -1);
        Character character = new Character(1, "", 5, "", "",
                Type.OVERWORLD, 10, 2, 3, 5);
        character.setLevel(2);
        spell.use(character);
        assertEquals(1, character.getLevel());
        assertEquals(2, character.getMana());
    }

    @Test
    public void testMaxLevelUp() {
        Spell spell = new LevelSpell(1, "LvlUp", 4, "", "", 1);
        Character character = new Character(1, "", 5, "", "",
                Type.OVERWORLD, 10, 2, 3, 5);
        character.setLevel(10);
        spell.use(character);
        assertEquals(10, character.getLevel());
    }

    @Test
    public void testMaxLevelDown() {
        Spell spell = new LevelSpell(1, "LvlUp", 4, "", "", -1);
        Character character = new Character(1, "", 5, "", "",
                Type.OVERWORLD, 10, 2, 3, 5);
        spell.use(character);
        assertEquals(1, character.getLevel());
    }

    @Test
    public void testInsufficentMana() {
        Spell spell = new LevelSpell(1, "LvlUp", 4, "", "", 1);
        Character character = new Character(1, "", 5, "", "",
                Type.OVERWORLD, 10, 2, 3, 5);
        character.setMana(0);
        spell.use(character);
        assertEquals(1, character.getLevel());
    }

}