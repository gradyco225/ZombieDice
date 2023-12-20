package org.example;

import java.util.Random;

public class Dice {

    private int id;
    private String color;
    private String[] symbols;
    private String rolledSymbol = null;

    public String getColor() {
        return color;
    }

    public String getSymbol(int side) {
        return symbols[side];
    }

    public String getRolled_Symbol(){
        return this.rolledSymbol;
    }

    public Dice(int id, String color){
        this.id = id;
        this.color = color;
        if (color.equals("Green")){
            symbols = generateGreenDice();
        }
        else if (color.equals("Yellow")){
            symbols = generateYellowDice();
        }
        else if (color.equals("Red")){
            symbols = generateRedDice();
        }
    }

    public void resetDiceRoll(){
        this.rolledSymbol = null;
    }

    public String rollDice(){
        String output = "";
        Random rand = new Random();

        int randomNumber = (rand.nextInt(6)); //Generates a number between 0-5

        output = this.getSymbol(randomNumber);
        this.rolledSymbol = output;
        return output;
    }

    private String[] generateGreenDice(){
        String[] output = new String[6];

        output[0] = "Brain";
        output[1] = "Brain";
        output[2] = "Brain";
        output[3] = "Footprint";
        output[4] = "Footprint";
        output[5] = "Shotgun";

        return output;
    }

    private String[] generateYellowDice(){
        String[] output = new String[6];

        output[0] = "Brain";
        output[1] = "Brain";
        output[2] = "Footprint";
        output[3] = "Footprint";
        output[4] = "Shotgun";
        output[5] = "Shotgun";

        return output;
    }

    private String[] generateRedDice(){
        String[] output = new String[6];

        output[0] = "Brain";
        output[1] = "Footprint";
        output[2] = "Footprint";
        output[3] = "Shotgun";
        output[4] = "Shotgun";
        output[5] = "Shotgun";

        return output;
    }
}
