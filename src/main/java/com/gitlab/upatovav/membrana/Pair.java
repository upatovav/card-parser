package com.gitlab.upatovav.membrana;

public class Pair {
    private final int x;
    private final int y;

    private Pair (int x, int y){
        this.x = x;
        this.y = y;
    }

    static Pair of(int x, int y){
        return new Pair(x,y);
    }

    public int getX(){
        return x;
    }
    public  int getY(){
        return y;
    }
}
