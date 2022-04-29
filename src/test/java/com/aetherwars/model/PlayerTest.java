package com.aetherwars.model;

import com.aetherwars.card.Character.Character;
import com.aetherwars.card.Character.Type;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class PlayerTest {
    private Player playerA, playerB;

    @Before
    public void setUp() {
        Player playerA = new Player("Player A");
        Player playerB = new Player("Player B");
    }

    @Test
    public void testHandCard() {
        Character x = new Character(1, "C1", 5, "", "",
                Type.OVERWORLD, 10, 2, 3, 5);
        playerA.addCard(x);
        assertEquals("C1", playerA.getBoardCharacter()[0].getName());
    }
}