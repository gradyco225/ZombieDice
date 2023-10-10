package org.example;

import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    //@Test
    public void greenDiceGeneration(){
        //Arrange
        //Act
        //Assert
    }

    //@Test
    public void roll_Green_Dice_Returns_Brain_With_Value_Zero(){
        //Arrange
        Dice die = new Dice("Green");

        //Act
        String actual = die.rollDice();
        String expected = "Shotgun";
        System.out.println("shotgun");

        //Assert
        Assert.assertEquals("It did not work",expected,actual);

    }
}
