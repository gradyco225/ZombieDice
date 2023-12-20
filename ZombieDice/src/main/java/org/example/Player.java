package org.example;

public class Player {

    private String name;
    private int score = 0;

    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void addToScore(int score){
        this.score += score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
