package com.aetherwars.card.spell;

import com.aetherwars.card.Character.Character;
import com.aetherwars.card.Character.Type;
import com.aetherwars.card.SummonedCharacter;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LevelSpellTest {
      private LevelSpell spell;
      private Character character;
      private SummonedCharacter summonedCharacter;

    @Before
    public void setUp() {
        spell = new LevelSpell(1, "LvlUp1", 4, "", "", 1);
        character = new Character(1, "", 5, "", "",
                Type.OVERWORLD, 10, 2, 3, 5);
        summonedCharacter = new SummonedCharacter(character, 1);
    }

    @Test
    public void testLevelUp() {
        spell.use(summonedCharacter);
        assertEquals(2, summonedCharacter.getLevel());
        assertEquals(1, character.getMana());
    }

    @Test
    public void testLevelDown() {
        spell.setLevelChange(-1);
        spell.use(summonedCharacter);
        assertEquals(1, summonedCharacter.getLevel());
        assertEquals(1, character.getMana());
    }

    @Test
    public void testMaxLevelUp() {
        summonedCharacter.setLevel(10);
        this.spell.use(summonedCharacter);
        assertEquals(10, summonedCharacter.getLevel());
    }

    @Test
    public void testMaxLevelDown() {
        spell.setLevelChange(-1);
        spell.use(summonedCharacter);
        assertEquals(1, summonedCharacter.getLevel());
    }

    @Test
    public void testInsufficentMana() {
        spell.setMana(999);
        spell.use(summonedCharacter);
        assertEquals(1, summonedCharacter.getLevel());
    }

}