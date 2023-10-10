package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String name;
    private List<Player> players;
    private List<Round> rounds = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public List<Round> getRounds() {
        return this.rounds;
    }

    public Game(String name, List<Player> players){
        this.name = name;
        this.players = players;
    }

    public void startNewRound() {
    }
}
