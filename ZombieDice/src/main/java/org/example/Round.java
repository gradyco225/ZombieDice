package org.example;

import java.util.ArrayList;
import java.util.List;

public class Round {

    private int roundNumber;
    private List<Turn> turns = new ArrayList<>();
    private List<Player> players;

    public Round(List<Player> players) {
        this.players = players;
    }

    public void playRound() {
        for (Player player : players) {
            displayNewTurnText(player);
            Turn currentTurn = new Turn(player);
            currentTurn.playTurn();
            turns.add(currentTurn);
        }
        displayEndRound();
    }

    public void displayEndRound(){
        System.out.println();
        System.out.println("-- Round Over --");
        System.out.println("Current Scores:");
        for (Player player : players) {
            System.out.println(player.getName() + "'s score is " + player.getScore());
        }
    }

    public void displayNewTurnText(Player player) {
        System.out.println("It is now " + player.getName() + "'s turn.");
    }

}
