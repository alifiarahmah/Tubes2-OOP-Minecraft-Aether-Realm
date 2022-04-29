package com.aetherwars.card.spell;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MorphSpellTest {
    MorphSpell morphSpell;

    @Before
    public void setUp() {
        morphSpell = new MorphSpell(1, "S", 4, "",
                "", 5);
    }

    @Test
    public void testGetter() {
        assertEquals(1, morphSpell.getId());
        assertEquals("S", morphSpell.getName());
        assertEquals(4, morphSpell.getMana());
        assertEquals("", morphSpell.getDescription());
        assertEquals("", morphSpell.getImagepath());
        assertEquals(5, morphSpell.getTargetId());
    }
}