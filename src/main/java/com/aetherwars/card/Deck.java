package com.aetherwars.card;

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

    // ini masih bingung (implementasi ini ngamnbil kartu pertama yang ga kosong)
    public Card drawCard() {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                Card card = cards[i];
                cards[i] = null;
                return card;
            }
        }
        return null;
    }

}
