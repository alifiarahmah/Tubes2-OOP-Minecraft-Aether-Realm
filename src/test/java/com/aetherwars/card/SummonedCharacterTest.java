package com.aetherwars.card;

import com.aetherwars.card.Character.Character;
import com.aetherwars.card.Character.Type;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SummonedCharacterTest {
    private SummonedCharacter summonedCharacter;
    private SummonedCharacter summonedCharacterOverworld;
    private SummonedCharacter summonedCharacterNether;
    private SummonedCharacter summonedCharacterEnd;

    @Before
    public void setUp() {
        Character character = new Character(1, "", 5, "", "",
                Type.OVERWORLD, 2, 2, 10, 5);
        Character characterOverworld = new Character(1, "", 5, "", "",
                Type.OVERWORLD, 2, 2, 10, 5);
        Character characterNether = new Character(1, "", 5, "", "",
                Type.NETHER, 2, 2, 10, 5);
        Character characterEnd = new Character(1, "", 5, "", "",
                Type.END, 2, 2, 10, 5);
        summonedCharacter = new SummonedCharacter(character, 1);
        summonedCharacterOverworld = new SummonedCharacter(characterOverworld, 1);
        summonedCharacterNether = new SummonedCharacter(characterNether, 1);
        summonedCharacterEnd = new SummonedCharacter(characterEnd, 1);
    }

    @Test
    public void testAttackSame() {
        summonedCharacter.attack(summonedCharacterOverworld);
        assertEquals(8.0, Math.floor(summonedCharacterOverworld.getHealth()));
    }

    @Test
    public void testAttackStronger() {
        summonedCharacter.attack(summonedCharacterEnd);
        assertEquals(6.0, Math.floor(summonedCharacterEnd.getHealth()));
    }

    @Test
    public void testAttackWeaker() {
        summonedCharacter.attack(summonedCharacterNether);
        assertEquals(9.0, Math.floor(summonedCharacterNether.getHealth()));
    }
}