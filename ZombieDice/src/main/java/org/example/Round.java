package org.example;

import java.util.List;

public class Round {

    private int roundNumber;
    private Player activePlayer;
    private int score = 0;
    private int strikes = 0;
    private int footprints = 0;
    private List<Dice> cupDice;
    private List<Dice> usedDice;
    private List<Dice> activeDice;
}
