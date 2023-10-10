package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private String name;
    private List<Player> players;
    private List<Round> rounds = new ArrayList<>();
    private int roundNumber = 1;
    private boolean gameComplete = false;
    public final Scanner userInput = new Scanner(System.in);
    private final int WINNING_COUNT = 13;

    public String getName() {
        return this.name;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public List<Round> getRounds() {
        return this.rounds;
    }

    public Game() {
        this.name = gatherName();
        this.players = gatherPlayers();
    }

    public Game(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

    public void startGame() {
        while (!gameComplete) {

            for (Player p : players) {
                createNewRound(p);
                rounds.get(rounds.size() - 1).playRound(); //Play last round in the list (the one we just made)
            }

            checkGameComplete();
        }
    }

    public void checkGameComplete() {
        for (Player p : this.players) {
            if (p.getScore() >= WINNING_COUNT) {
                this.gameComplete = true;
                break;
            }
        }
    }

    public void createNewRound(Player currentPlayer) {
        Round newRound = new Round(roundNumber + 1, currentPlayer);
        this.rounds.add(newRound);
    }

    public void outputPlayerList() {
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
            this.players.add(new Player(userInput.nextLine()));
        }

        return this.players;
    }
}
