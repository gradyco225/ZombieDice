package org.example;

import java.util.Scanner;

public class Main {

    public final Scanner userInput = new Scanner(System.in);
    public Game game;

    public boolean active = true;

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
        //Player player1 = new Player("Connor");
        //Turn turn = new Turn(player1);
        //turn.playTurn();
        while(active) {

            game = new Game();

            game.displayPlayerList();

            game.playGame();

            while (true) {
                System.out.println();
                System.out.println("Do you want to play again? Y/N");
                String input = userInput.nextLine();
                if (input.equals("Y") || input.equals("y")){
                    break;
                }
                if (input.equals("N") || input.equals("n")){
                    active = false;
                    break;
                }
                System.out.println("Invalid input. Please type Y or N.");
            }

        }
        System.out.println("Thank you for playing Zombie Dice.");

    }

    public void diceRoller(){
        System.out.println("Starting Dice Roller.");

        System.out.println("Generating New Dice.");
        Dice greenDice = new Dice(1,"Green");
        Dice yellowDice = new Dice(2,"Yellow");
        Dice redDice = new Dice(3,"Red");

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



}