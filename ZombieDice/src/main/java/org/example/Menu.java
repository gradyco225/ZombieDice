package org.example;

import java.util.Scanner;

public class Menu {

    private static final String ROUND_OPTION_ROLL_DICE = "Roll Dice";
    private static final String ROUND_OPTION_END_TURN = "End Turn";
    private static final String[] ROUND_ROLL_OPTIONS = {ROUND_OPTION_ROLL_DICE, ROUND_OPTION_END_TURN};

    private Scanner userInput;

    public Menu() {
        userInput = new Scanner(System.in);
    }

    /**
     *
     * @return String - the round option selected
     */
    public String runRollMenu() {
        return runMenu(ROUND_ROLL_OPTIONS);
    }


    /**
     *
     * @param currentMenu
     * @return String the round option selected
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

                if (menuOption.equals(ROUND_OPTION_ROLL_DICE) && currentMenu == ROUND_ROLL_OPTIONS) {
                    return ROUND_OPTION_ROLL_DICE;
                }

                if (menuOption.equals(ROUND_OPTION_END_TURN) && currentMenu == ROUND_ROLL_OPTIONS) {
                    return ROUND_OPTION_END_TURN;
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
