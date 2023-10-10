package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Round {

    private int roundNumber;
    private Player activePlayer;
    private int score = 0;
    private int strikes = 0;
    private int footprints = 0;
    private List<Dice> cupDice;
    private List<Dice> usedDice = new ArrayList<>();
    private List<Dice> activeDice = new ArrayList<>();
    private List<String> activeDiceRolls = new ArrayList<>();
    private final int AMOUNT_OF_GREEN_DICE = 6;
    private final int AMOUNT_OF_YELLOW_DICE = 4;
    private final int AMOUNT_OF_RED_DICE = 3;
    private final int AMOUNT_OF_ACTIVE_DICE = 3;

    public Round(int roundNumber, Player activePlayer) {
        this.roundNumber = roundNumber;
        this.activePlayer = activePlayer;
        this.cupDice = generateCupDice();
    }

    public void playRound(){

    }

    public void rollDice(){
        activeDiceRolls = new ArrayList<>();
        for (Dice die : activeDice){
            activeDiceRolls.add(die.rollDice());
        }
    }

    public void moveToActiveDice(){
        for (int numActiveDice = activeDice.size(); numActiveDice < AMOUNT_OF_ACTIVE_DICE; numActiveDice++){
            Random rand = new Random();
            int randomNumber = (rand.nextInt(cupDice.size())); //generate random number between 0 and the size of cupDice
            activeDice.add(activeDice.size(),cupDice.get(randomNumber)); //add dice from cupDice at randomNumber location to activeDice
            cupDice.remove(randomNumber);
        }
    }

    public void moveFromActiveDiceToUsedDice(int diceNumber, String symbol) {
        if (symbol.equals("Brain") || symbol.equals("Shotgun")){
            usedDice.add(this.activeDice.get(diceNumber));
            activeDice.remove(this.activeDice.get(diceNumber));
        }
    }

    private List<Dice> generateCupDice(){
        List<Dice> cupDice = new ArrayList<>();
        for (int i = 0; i < AMOUNT_OF_GREEN_DICE; i++) {
            cupDice.add(new Dice("Green"));
        }
        for (int i = 0; i < AMOUNT_OF_YELLOW_DICE; i++){
            cupDice.add(new Dice("Yellow"));
        }
        for (int i = 0; i < AMOUNT_OF_RED_DICE; i++){
            cupDice.add(new Dice("Red"));
        }
        return cupDice;
    }
}
