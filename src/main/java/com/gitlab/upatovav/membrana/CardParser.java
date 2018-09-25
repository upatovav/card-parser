package com.gitlab.upatovav.membrana;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class CardParser {

    private static CardParser ourInstance = new CardParser();

    static int BLACK = 0xFF232326;
    static int RED = 0xFFCD4949;
    static int WHITE = 0xFFFFFFFF;
    static int GREY_BLACK = 0xFF101012;
    static int GREY_RED = 0xFF602222;
    static int GREY_WHITE = 0xFF787878;

    public static CardParser getInstance() {
        return ourInstance;
    }

    private CardParser() {
    }

    public boolean isCardPresent(int leftX, int topY,  BufferedImage img){
        int centerDotColour = img.getRGB(leftX + 25, topY + 35);
        return centerDotColour == WHITE || centerDotColour == GREY_WHITE;
    }

    public Card parseCard(int leftX, int topY,  BufferedImage img){
        return new Card(getCardRank(leftX, topY, img), getCardSuit(leftX, topY, img));
    }

    private CardSuit getCardSuit(int leftX, int topY, BufferedImage img) {
        int centerDot = img.getRGB(leftX + 35, topY + 60);
        if (checkIsBlack(centerDot)){// clubs or spades
            int ifSpadesDot = img.getRGB(leftX + 27, topY + 55);
            if (checkIsBlack(ifSpadesDot)){//spades
                return  CardSuit.SPADES;
            } else { //clubs
                return  CardSuit.CLUBS;
            }
        } else { //diamonds or hearts
            int ifDiamondDot = img.getRGB(leftX + 35, topY + 50);
            if (checkIsRed(ifDiamondDot)){//diamonds
                return CardSuit.DIAMONDS;
            } else { // hearts
                return  CardSuit.HEARTS;
            }
        }
    }

    private CardRank getCardRank(int leftX, int topY, BufferedImage img) {
        if (is2Rank(leftX, topY, img)) return CardRank.N2;
        if (is3Rank(leftX, topY, img)) return CardRank.N3;
        if (is4Rank(leftX, topY, img)) return CardRank.N4;
        if (is5Rank(leftX, topY, img)) return CardRank.N5;
        if (is6Rank(leftX, topY, img)) return CardRank.N6;
        if (is7Rank(leftX, topY, img)) return CardRank.N7;
        if (is8Rank(leftX, topY, img)) return CardRank.N8;
        if (is9Rank(leftX, topY, img)) return CardRank.N9;
        if (is10Rank(leftX, topY, img)) return CardRank.N10;
        if (isJRank(leftX, topY, img)) return CardRank.J;
        if (isQRank(leftX, topY, img)) return CardRank.Q;
        if (isKRank(leftX, topY, img)) return CardRank.K;
        if (isARank(leftX, topY, img)) return CardRank.A;
        throw new RuntimeException("Unknown card");
    }

    private boolean is2Rank(int leftX, int topY, BufferedImage img) {
        return checkNotWhite(img, leftX, topY,
                Pair.of(4, 5),
                Pair.of(9, 3),
                Pair.of(15, 7),
                Pair.of(12, 13),
                Pair.of(4, 22),
                Pair.of(15, 22)) &&
                checkWhite(img, leftX, topY,
                        Pair.of(3, 12),
                        Pair.of(15, 17));
    }

    private boolean is3Rank(int leftX, int topY, BufferedImage img) {
        return checkNotWhite(img, leftX, topY,
                Pair.of(4, 3),
                Pair.of(9, 12),
                Pair.of(15, 18),
                Pair.of(9, 22)) &&
                checkWhite(img, leftX, topY,
                        Pair.of(3, 8),
                        Pair.of(3, 12),
                        Pair.of(3, 16));
    }

    private boolean is4Rank(int leftX, int topY, BufferedImage img) {
        return checkNotWhite(img, leftX, topY,
                Pair.of(15, 5),
                Pair.of(3, 17),
                Pair.of(18, 17),
                Pair.of(14, 22)) &&
                checkWhite(img, leftX, topY,
                        Pair.of(3, 5),
                        Pair.of(2, 9));
    }

    private boolean is5Rank(int leftX, int topY, BufferedImage img){
        return checkNotWhite(img, leftX, topY,
                Pair.of(10, 4),
                Pair.of(4, 8),
                Pair.of(10, 10),
                Pair.of(16, 17),
                Pair.of(10, 22)) &&
                checkWhite(img, leftX, topY,
                        Pair.of(17, 8),
                        Pair.of(4, 17));
    }
    private boolean is6Rank(int leftX, int topY, BufferedImage img){
        return checkNotWhite(img, leftX, topY,
                Pair.of(10, 4),
                Pair.of(4, 8),
                Pair.of(10, 10),
                Pair.of(2, 12),
                Pair.of(16, 12),
                Pair.of(4, 17),
                Pair.of(16, 17),
                Pair.of(10, 22)) &&
                checkWhite(img, leftX, topY,
                        Pair.of(17, 8));
    }

    private boolean is7Rank(int leftX, int topY, BufferedImage img){
        return checkNotWhite(img, leftX, topY,
                Pair.of(3, 3),
                Pair.of(15, 3),
                Pair.of(10, 13),
                Pair.of(5, 22)) &&
                checkWhite(img, leftX, topY,
                        Pair.of(3, 10));

    }

    private boolean is8Rank(int leftX, int topY, BufferedImage img){
        return checkNotWhite(img, leftX, topY,
                Pair.of(10, 4),
                Pair.of(15, 7),
                Pair.of(4, 7),
                Pair.of(10, 12),
                Pair.of(4, 17),
                Pair.of(16, 17),
                Pair.of(10, 22));
    }

    private boolean is9Rank(int leftX, int topY, BufferedImage img){
        return checkNotWhite(img, leftX, topY,
                Pair.of(10, 4),
                Pair.of(17, 8),
                Pair.of(4,8),
                Pair.of(10,14),
                Pair.of(16, 17),
                Pair.of(10, 22)) &&
                checkWhite(img, leftX, topY,
                        Pair.of(4, 17));
    }

    private boolean is10Rank(int leftX, int topY, BufferedImage img) {
        return checkNotWhite(img, leftX, topY,
                Pair.of(4, 4),
                Pair.of(17, 4),
                Pair.of(4, 13),
                Pair.of(10, 13),
                Pair.of(24, 13),
                Pair.of(4, 22),
                Pair.of(17, 22));
    }

    private boolean isJRank(int leftX, int topY, BufferedImage img) {
        return checkNotWhite(img, leftX, topY,
                Pair.of(12, 4),
                Pair.of(13, 17),
                Pair.of(3, 20),
                Pair.of(8, 22)) &&
                checkWhite(img, leftX, topY,
                        Pair.of(4, 12));
    }

    private boolean isQRank(int leftX, int topY, BufferedImage img) {
        return checkNotWhite(img, leftX, topY,
                Pair.of(13, 3),
                Pair.of(4, 12),
                Pair.of(22, 12),
                Pair.of(12, 22));
    }

    private boolean isKRank(int leftX, int topY, BufferedImage img) {
        return checkNotWhite(img, leftX, topY,
                Pair.of(5, 3),
                Pair.of(18, 3),
                Pair.of(5, 10),
                Pair.of(10, 10),
                Pair.of(5, 22),
                Pair.of(18, 22));
    }

    private boolean isARank(int leftX, int topY, BufferedImage img){
        return checkNotWhite(img, leftX, topY,
                Pair.of(10, 4),
                Pair.of(3, 17),
                Pair.of(10, 17),
                Pair.of(16, 17),
                Pair.of(0, 22),
                Pair.of(17, 22));

    }

    public boolean checkWhite( BufferedImage img, int leftX, int topY, Pair ... pairs){
        return Arrays.stream(pairs).allMatch(p -> checkWhite(img.getRGB(leftX + p.getX(), topY + p.getY())));
    }

    public boolean checkNotWhite( BufferedImage img, int leftX, int topY, Pair ... pairs){
        return Arrays.stream(pairs).allMatch(p -> checkNotWhite(img.getRGB(leftX + p.getX(), topY + p.getY())));
    }

    private boolean checkWhite(int dotColour) {
        return dotColour == WHITE || dotColour == GREY_WHITE;
    }

    private boolean checkNotWhite(int dotColour) {
        return dotColour != WHITE && dotColour != GREY_WHITE;
    }

    private boolean checkIsRed(int dotColour) {
        return dotColour == RED || dotColour == GREY_RED;
    }

    private boolean checkIsBlack(int dotColour) {
        return dotColour == BLACK || dotColour == GREY_BLACK;
    }
}
