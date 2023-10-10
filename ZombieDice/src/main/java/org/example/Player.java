package org.example;

public class Player {

    private String name;
    private int score = 0;

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public Player(String name){
        this.name = name;
    }

    public void addToScore(int score){
        this.score += score;
    }


}
