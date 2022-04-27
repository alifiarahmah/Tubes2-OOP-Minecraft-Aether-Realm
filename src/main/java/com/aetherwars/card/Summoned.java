package com.aetherwars.card;

import com.aetherwars.event.BoardChannel;

public interface Summoned {
    Card getBaseCard();

    void removeCard();

    void setChannel(BoardChannel channel);
}
