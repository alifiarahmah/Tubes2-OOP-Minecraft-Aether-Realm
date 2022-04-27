package com.aetherwars.controller;

import com.aetherwars.event.BoardChannel;
import com.aetherwars.event.Event;
import com.aetherwars.event.Publisher;
import com.aetherwars.event.Subscriber;

public class BoardController implements Subscriber, Publisher {
    private BoardChannel channel;
    public BoardController(BoardChannel board){
        this.channel = board;
    }

    @Override
    public void publish(Event event) {

    }

    @Override
    public void onEvent(Event event) {

    }
}
