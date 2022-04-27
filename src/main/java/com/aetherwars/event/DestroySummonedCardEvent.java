package com.aetherwars.event;

import com.aetherwars.card.Summoned;

public class DestroySummonedCardEvent implements Event {
    private Summoned summoned;

    public DestroySummonedCardEvent(Summoned summoned){
        this.summoned = summoned;
    }

    @Override 
    public Object getInfo() {
        return this.summoned;
    }
}
