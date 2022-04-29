package com.aetherwars.event;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.aetherwars.model.Phase;
import com.aetherwars.card.*;
/**
 *
 * @author Fahmi
 */
public class EnterDrawPhaseEvent implements Event {
    private Card[] cards;
    
    public EnterDrawPhaseEvent(Card card1, Card card2, Card card3){
        this.cards = new Card[3];
        this.cards[0] = card1;
        this.cards[1] = card2;
        this.cards[2] = card3;
    }
    @Override
    public Object getInfo(){
        return this.cards;
    }
}
