package org.example;

import java.util.Random;

public class Dice {

    private int id;
    private String color;
    private String[] symbol;
    private String rolled_symbol = null;

    public String getColor() {
        return color;
    }

    public String getSymbol(int side) {
        return symbol[side];
    }

    public String getRolled_Symbol(){
        return this.rolled_symbol;
    }

    public Dice(int id, String color){
        this.id = id;
        this.color = color;
        if (color.equals("Green")){
            symbol = generateGreenDice();
        }
        else if (color.equals("Yellow")){
            symbol = generateYellowDice();
        }
        else if (color.equals("Red")){
            symbol = generateRedDice();
        }
    }

    public void resetDiceRoll(){
        this.rolled_symbol = null;
    }

    public String rollDice(){
        String output = "";
        Random rand = new Random();

        int randomNumber = (rand.nextInt(6)); //Generates a number between 0-5

        output = this.getSymbol(randomNumber);
        this.rolled_symbol = output;
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
