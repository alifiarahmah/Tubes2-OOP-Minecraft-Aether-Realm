package com.aetherwars.card;

import java.util.Random;

public class Deck {
    private Card[] cards;

    public Deck() {
        this.cards = new Card[60];
    }

    public void addCard(Card card) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] == null) {
                cards[i] = card;
                break;
            }
        }
    }

    public void removeCard(Card card) {
        if(cards.length > 40) {
            for (int i = 0; i < cards.length; i++) {
                if (cards[i] == card) {
                    cards[i] = null;
                    break;
                }
            }
        }
    }

    // Random draw card
    public Card drawCard() {
        Random random = new Random();
        int upperbound = cards.length;
        int i = random.nextInt(upperbound);
        int ctr = 0;
        
        Boolean found = false;
        Card card = null;

        while(!found){
            if(cards[i] != null){
                found = true;
                card = cards[i];
                cards[i] = null;
                ctr++;
            }
            else{
                i = random.nextInt(upperbound);
                ctr++;
                if(ctr == upperbound){
                    return card;
                }
            }
        }
        return card;
    }
}
