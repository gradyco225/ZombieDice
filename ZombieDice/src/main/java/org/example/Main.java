package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public final Scanner userInput = new Scanner(System.in);
    public Game game;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run(){
        System.out.println("-----------------------");
        System.out.println("Welcome to Zombie Dice!");
        System.out.println("-----------------------");

        //Debug Testing
        //diceRoller();

        System.out.print("Enter a title for this game: ");
        String name = userInput.nextLine();
        List<Player> playerList = gatherPlayers();
        game = new Game(name,playerList);
        game.startNewRound();



    }

    public void diceRoller(){
        System.out.println("Starting Dice Roller.");

        System.out.println("Generating New Dice.");
        Dice greenDice = new Dice("Green");
        Dice yellowDice = new Dice("Yellow");
        Dice redDice = new Dice("Red");

        while (true){
            System.out.print("Select a dice to roll: ");
            String diceToRoll = userInput.nextLine();
            String diceRoll = "";
            if (diceToRoll.equals("Green")){
                diceRoll = greenDice.rollDice();
            }
            if (diceToRoll.equals("Yellow")){
                diceRoll = yellowDice.rollDice();
            }
            if (diceToRoll.equals("Red")){
                diceRoll = redDice.rollDice();
            }
            System.out.println(diceRoll);
        }
    }

    private List<Player> gatherPlayers(){
        List<Player> players = new ArrayList<>();
        boolean validPlayers = false;
        int playerCount = 0;

        while(!validPlayers) {
            System.out.print("How many players will there be?: ");
            try {
                playerCount = Integer.parseInt(userInput.nextLine());
                if (playerCount < 1){
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Number of players is invalid");
            }
        }

        for (int i = 0; i < playerCount; i++) {
            System.out.print("Enter name for player " + (i + 1) + ": ");
            players.add(new Player(userInput.nextLine()));
        }

        return players;
    }

}