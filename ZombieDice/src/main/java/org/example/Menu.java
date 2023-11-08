package org.example;

import java.util.Scanner;

public class Menu {

    private static final String TURN_OPTION_ROLL_DICE = "Roll Dice";
    private static final String TURN_OPTION_END_TURN = "End Turn";
    private static final String[] TURN_ROLL_OPTIONS = {TURN_OPTION_ROLL_DICE, TURN_OPTION_END_TURN};

    private Scanner userInput;

    public Menu() {
        userInput = new Scanner(System.in);
    }

    /**
     * Run Roll Menu runs the menu for the turn roll options
     * @return String - returns the menu option selected
     */
    public String runRollMenu() {
        return runMenu(TURN_ROLL_OPTIONS);
    }


    /**
     * Run Menu runs the current menu
     * @param currentMenu
     * @return Returns string for the option selected
     */
    private String runMenu(String[] currentMenu) {
        boolean runMenu = true;

        while (runMenu) {

            displayMenu(currentMenu);

            System.out.print("\nPlease make a selection: ");
            String selection = userInput.nextLine();

            try {
                int selectionIndex = Integer.parseInt(selection) - 1;

                String menuOption = currentMenu[selectionIndex];

                if (menuOption.equals(TURN_OPTION_ROLL_DICE) && currentMenu == TURN_ROLL_OPTIONS) {
                    return TURN_OPTION_ROLL_DICE;
                }

                if (menuOption.equals(TURN_OPTION_END_TURN) && currentMenu == TURN_ROLL_OPTIONS) {
                    return TURN_OPTION_END_TURN;
                }
            } catch (Exception ex) {
                System.out.printf("'%s' Is Not a Valid Option%n", selection);
            }
        }
        return null;
    }

    private void displayMenu(String[] menu) {
        System.out.println("\n*******************************");
        for (int i = 0; i < menu.length; i++) {
            if (!menu[i].startsWith("*")) {
                System.out.printf("%1$s) %2$s\n", i + 1, menu[i]);
            }
        }
        System.out.println("*******************************");
    }

}
