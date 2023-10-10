package org.example;

public class Player {

    private String name;
    private int Score = 0;

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public Player(String name){
        this.name = name;
    }
}
