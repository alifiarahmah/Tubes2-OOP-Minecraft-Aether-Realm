package com.aetherwars.card.spell;

import com.aetherwars.card.Character.Character;
import com.aetherwars.card.Character.Type;
import com.aetherwars.card.SummonedCharacter;
import org.junit.Assert;
import org.junit.Test;

public class LevelSpellTest {

    @Test
    public void testLevelUp() {
        Spell spell = new LevelSpell(1, "LvlUp1", 4, "", "", 1);
        Character character = new Character(1, "", 5, "", "",
                Type.OVERWORLD, 10, 2, 3, 5);
        SummonedCharacter summonedCharacter = new SummonedCharacter(character, 1);
        spell.use(summonedCharacter);
        Assert.assertEquals(2, summonedCharacter.getLevel());
        Assert.assertEquals(1, character.getMana());
    }

    @Test
    public void testLevelDown() {
        Spell spell = new LevelSpell(1, "LvlDown1", 3, "", "", -1);
        Character character = new Character(1, "", 5, "", "",
                Type.OVERWORLD, 10, 2, 3, 5);
        SummonedCharacter summonedCharacter = new SummonedCharacter(character, 1);
        spell.use(summonedCharacter);
        Assert.assertEquals(1, summonedCharacter.getLevel());
        Assert.assertEquals(2, character.getMana());
    }

    @Test
    public void testMaxLevelUp() {
        Spell spell = new LevelSpell(1, "LvlUp", 4, "", "", 1);
        Character character = new Character(1, "", 5, "", "",
                Type.OVERWORLD, 10, 2, 3, 5);
        SummonedCharacter summonedCharacter = new SummonedCharacter(character, 1);
        summonedCharacter.setLevel(10);
        spell.use(summonedCharacter);
        spell.use(summonedCharacter);
        Assert.assertEquals(10, summonedCharacter.getLevel());
    }

    @Test
    public void testMaxLevelDown() {
        Spell spell = new LevelSpell(1, "LvlUp", 4, "", "", -1);
        Character character = new Character(1, "", 5, "", "",
                Type.OVERWORLD, 10, 2, 3, 5);
        SummonedCharacter summonedCharacter = new SummonedCharacter(character, 1);
        spell.use(summonedCharacter);
        Assert.assertEquals(1, summonedCharacter.getLevel());
    }

    @Test
    public void testInsufficentMana() {
        Spell spell = new LevelSpell(1, "LvlUp", 999, "", "", 2);
        Character character = new Character(1, "", 5, "", "",
                Type.OVERWORLD, 10, 2, 3, 5);
        SummonedCharacter summonedCharacter = new SummonedCharacter(character, 1);
        spell.use(summonedCharacter);
        Assert.assertEquals(1, summonedCharacter.getLevel());
    }

}