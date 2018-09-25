package com.gitlab.upatovav.membrana;



import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {



    static int FIRST_CARD_LEFT_X = 150;
    static int CARD_TOP_Y = 590;
    static int CARD_STEPPING = 72;


    public static void main(String[] args) {
        String folderName = args[0];
        File folder = new File(folderName);
        if (folder.exists() && folder.isDirectory()) {
            for (File imgFile : folder.listFiles()) {
                try {
                    BufferedImage img = ImageIO.read(imgFile);
                    int x = FIRST_CARD_LEFT_X;
                    LinkedList<Card> cards = new LinkedList<>();
                    CardParser parser = CardParser.getInstance();
                    while (parser.isCardPresent(x, CARD_TOP_Y, img)) {
                        cards.add(parser.parseCard(x, CARD_TOP_Y, img));
                        x = x + CARD_STEPPING;
                    }
                    System.out.println(imgFile.getName() + " :" + String.join("", cards.stream().map(Card::toString).collect(Collectors.toList())));
                } catch (Exception e) {
                    System.out.println(imgFile.getName() + " :" + e.toString());
                }
            }
        } else{
            System.out.println(folderName + " is not a directory");
        }
    }
}
