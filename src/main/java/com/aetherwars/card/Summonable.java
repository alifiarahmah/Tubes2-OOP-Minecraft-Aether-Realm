package com.aetherwars.card;

import com.aetherwars.card.Character.Type;

public interface Summonable {
    Type getType();
    int getBaseAtk();
    float getBaseHealth();
}
