package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private String name;
    private List<Player> players = new ArrayList<>();
    private Player winner;
    private int roundNumber = 0;
    private boolean gameComplete = false;
    public final Scanner userInput = new Scanner(System.in);
    private final int WINNING_COUNT = 13;

    public String getName() {
        return this.name;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Game() {
        this.name = gatherName();
        this.players = gatherPlayers();
    }

    public Game(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

    public void playGame() {
        while (!gameComplete) {
            Round currentRound = new Round(players);
            currentRound.playRound();
            checkGameComplete();
        }
        System.out.println("-- THE GAME IS OVER --");
        System.out.println("The winner is " + winner.getName() + " with a final score of " + winner.getScore() + ".");
    }

    public void checkGameComplete() {
        for (Player player : this.players) {
            if (player.getScore() >= WINNING_COUNT) {
                if (winner == null) { //There is not already a winner
                    this.gameComplete = true;
                    this.winner = player;
                }
                else { //There is a winner already
                    if (player.getScore() > winner.getScore()){
                        this.winner = player;
                    }
                }
            }
        }
    }

    public void displayPlayerList() {
        int counter = 1;
        for (Player p : this.getPlayers()) {
            System.out.println("Player " + counter + ": " + p.getName());
            counter++;
        }
    }

    public String gatherName() {
        System.out.print("Enter a title for this game: ");
        this.name = userInput.nextLine();
        return this.name;
    }

    public List<Player> gatherPlayers() {
        boolean validNumPlayers = false;
        int playerCount = 0;

        while (!validNumPlayers) {
            System.out.print("How many players will there be?: ");
            try {
                playerCount = Integer.parseInt(userInput.nextLine());
                if (playerCount < 1) {
                    throw new NumberFormatException();
                }
                validNumPlayers = true;
            } catch (NumberFormatException e) {
                System.out.println("Number of players is invalid");
            }
        }

        for (int i = 0; i < playerCount; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String name = userInput.nextLine();
            this.players.add(new Player(name));
        }

        return this.players;
    }
}
