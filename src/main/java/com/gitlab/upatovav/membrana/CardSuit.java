package com.gitlab.upatovav.membrana;

public enum CardSuit {
    DIAMONDS("d"),
    CLUBS("c"),
    HEARTS("h"),
    SPADES("s");

    private String stringValue;

    CardSuit(String stringValue){
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
