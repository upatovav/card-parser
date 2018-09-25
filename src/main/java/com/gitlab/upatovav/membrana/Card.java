package com.gitlab.upatovav.membrana;

public class Card {

    private CardRank rank;
    private CardSuit suit;

    public Card(CardRank rank, CardSuit suit){
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank.toString()+suit.toString();
    }
}
