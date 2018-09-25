package com.gitlab.upatovav.membrana;

public enum CardRank {
    N2("2"),
    N3("3"),
    N4("4"),
    N5("5"),
    N6("6"),
    N7("7"),
    N8("8"),
    N9("9"),
    N10("10"),
    J("J"),
    Q("Q"),
    K("K"),
    A("A");

    private String stringValue;

    CardRank(String stringValue){
        this.stringValue = stringValue;
    }

    @Override
    public String toString() {
        return stringValue;
    }
}
