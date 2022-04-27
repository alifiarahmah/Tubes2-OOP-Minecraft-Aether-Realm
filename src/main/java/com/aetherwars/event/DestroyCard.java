package com.aetherwars.event;

import com.aetherwars.card.Card;
 
public class DestroyCard implements Event {
    private Card card;

    public DestroyCard(Card card) {
        this.card = card;
    }

    @Override
    public Object getInfo() {
        return this.card;
    }    
}
