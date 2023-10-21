package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Round {

    private int roundNumber;
    private Player activePlayer;
    private int score = 0;
    private int strikes = 0;
    private List<Dice> cupDice;
    private List<Dice> usedDice = new ArrayList<>();
    private List<Dice> activeDice = new ArrayList<>();
    private List<Dice> shotgunDice = new ArrayList<>(); //Only gets added to when there are shotguns rolled
    private List<String> activeDiceRolls = new ArrayList<>();
    private final int AMOUNT_OF_GREEN_DICE = 6;
    private final int AMOUNT_OF_YELLOW_DICE = 4;
    private final int AMOUNT_OF_RED_DICE = 3;
    private final int AMOUNT_OF_ACTIVE_DICE = 3;
    private static final String ROUND_OPTION_ROLL_DICE = "Roll Dice";
    private static final String ROUND_OPTION_END_TURN = "End Turn";
    private static final String ROUND_OPTION_NEW_DICE = "Get new dice";

    public Round(int roundNumber, Player activePlayer) {
        this.roundNumber = roundNumber;
        this.activePlayer = activePlayer;
        this.cupDice = generateCupDice();
    }

    /**
     * The main body structure for the playing of the round
     */
    public void playRound(){
        Menu menu = new Menu();
        boolean roundActive = true;
        while(roundActive){
            String option = menu.runRollMenu();

            if (option == ROUND_OPTION_END_TURN){
                activePlayer.addToScore(this.score);
                displayEndTurn();
                break;
            }else if (option == ROUND_OPTION_ROLL_DICE){
                moveToActiveDice();
                rollDice();
                displayRoll();
                moveFromActiveDice();
                if (this.strikes >= 3){
                    this.score = 0;
                    displayEndTurn();
                    break;
                }
            }else{
                System.err.println("Round roll option error. Contact support.");
            }

        }
    }

    /**
     * Roll Dice rolls the dice, then adds the brains to score and shotguns to strikes
     */
    public void rollDice(){
        for (Dice die : this.activeDice){
            String side = die.rollDice();
            if (side == "Brain") {
                this.score += 1;
            }
            if (side == "Shotgun"){
                this.strikes += 1;
            }
        }
    }

    public void moveToActiveDice(){
        if (AMOUNT_OF_ACTIVE_DICE - activeDice.size() < 0){
            refillCupDice();
        }

        for (int numActiveDice = activeDice.size(); numActiveDice < AMOUNT_OF_ACTIVE_DICE; numActiveDice++){ //If current dice count is less than total active dice needed
            Random rand = new Random();
            int randomNumber = (rand.nextInt(cupDice.size())); //generate random number between 0 and the size of cupDice
            activeDice.add(activeDice.size(),cupDice.get(randomNumber)); //add dice from cupDice at randomNumber location to end of activeDice
            cupDice.remove(randomNumber);
        }
    }

    public void moveFromActiveDice() {
        List<Dice> itemsToUsedDice = new ArrayList<>();
        List<Dice> itemsToShotgunDice = new ArrayList<>();

        for (Dice die : this.activeDice) {
            if (die.getRolled_Symbol().equals("Brain")) {
                itemsToUsedDice.add(die);
            }
            if (die.getRolled_Symbol().equals("Shotgun")){
                itemsToShotgunDice.add(die);
            }
        }
        activeDice.removeAll(itemsToUsedDice);
        activeDice.removeAll(itemsToShotgunDice);
        usedDice.addAll(itemsToUsedDice);
        shotgunDice.addAll(itemsToShotgunDice);
    }

    public void refillCupDice(){
        for (Dice die : this.usedDice){
            die.resetDiceRoll();
            this.cupDice.add(die);
            this.usedDice.remove(die);
        }
    }


    private List<Dice> generateCupDice(){
        int idCounter = 1;
        List<Dice> cupDice = new ArrayList<>();
        for (int i = 0; i < AMOUNT_OF_GREEN_DICE; i++) {
            cupDice.add(new Dice(idCounter,"Green"));
            idCounter++;
        }
        for (int i = 0; i < AMOUNT_OF_YELLOW_DICE; i++){
            cupDice.add(new Dice(idCounter,"Yellow"));
            idCounter++;
        }
        for (int i = 0; i < AMOUNT_OF_RED_DICE; i++){
            cupDice.add(new Dice(idCounter,"Red"));
            idCounter++;
        }
        return cupDice;
    }

    private void displayRoll(){
        System.out.println("Dice rolled:");
        int counter = 1;
        for (Dice die : this.activeDice) {
            System.out.println("Dice " + counter + " Color: " + die.getColor());
            System.out.println("Dice " + counter + " Roll: " + die.getRolled_Symbol());
            counter++;
        }
        System.out.println("Your Score: " + this.activePlayer.getScore());
        System.out.println("Round Score: " + this.score);
        System.out.println("Strikes: " + this.strikes);
        System.out.println("");
        System.out.println("Dice remaining in cup: ");
        System.out.println("Green: " + getColorCount("Green"));
        System.out.println("Yellow: " + getColorCount("Yellow"));
        System.out.println("Red: " + getColorCount("Red"));
    }

    private int getColorCount(String color){
        int result = 0;
        for (Dice die : cupDice) {
            if (die.getColor().equals(color)) {
                result++;
            }
        }
        return result;
    }

    private void displayEndTurn(){
        System.out.println("TURN OVER");
        System.out.println("Final Round Score: " + this.score);
        System.out.println("Final Player Score: " + this.activePlayer.getScore());
    }
}
