package com.aetherwars.event;

import com.aetherwars.card.Card;

public class CardDrawn implements Event {
    private Card card;

    public CardDrawn(Card card) {
        this.card = card;
    }

    @Override
    public Object getInfo() {
        return this.card;
    }
}
