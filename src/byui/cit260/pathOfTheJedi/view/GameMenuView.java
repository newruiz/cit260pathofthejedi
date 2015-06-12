/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.pathOfTheJedi.view;

import byui.cit260.pathOfTheJedi.model.Actor;
import byui.cit260.pathOfTheJedi.model.InventoryList;
import java.util.Scanner;

public class GameMenuView {
    
    private final String MENU = "\n"
            + "\n(II:::::::::<[==============================================="
            + "\n                        Game Menu"
            + "\n(II:::::::::<[==============================================="
            + "\n E - Explore"
            + "\n F - Find Someone"
            + "\n S - Status"
            + "\n V - Inventory"            
            + "\n G - Go to Ship"
            + "\n Q - Exit and Save"
            + "\n(II:::::::::<[==============================================="; 

    void displayMenu() {
        char selection = ' ';
        do {
            System.out.println(MENU); // display the main menu
            
            String input = this.getInput(); // get the user's selection
            selection = input.charAt(0); // get first char of string
            
            this.doAction(selection); // do action based on selection
        } while (selection != 'Q'); // an selection is not "Exit"
    }
    
    private String getInput() {
        boolean valid = false; // idicates if the name has been retrieved
        String playersInput = null;
        Scanner keyboard = new Scanner(System.in); //keyboard input stream
        
        while(!valid){ //while a valid name has not been retrieved
            
            // prompt for the players name
            System.out.println("Make Selection:");
            
            // get the name from the keyboard and trim off the blanks
            playersInput = keyboard.nextLine();
            playersInput = playersInput.trim();            
        
            
            //if the value is invalid (less than one char in length)
            if (playersInput.length()<1) {
                System.out.println("a valid value has not been entered");
                continue; // and repeat agian
            }
            break; // out of the (exit) the repetition
        }
        
        return playersInput; // return the name
    }
    
    private void doAction(char choice) {
        
        switch (choice){
            case 'E': case 'e': //Explore planet
                this.explore();
                break;            
            case 'F': case 'f': //Find Someone
                this.findSomeone();
                break;
            case 'S': case 's': //Get staus
                this.viewStatus();
                break;
            case 'V': case 'v': //View Inventory
                this.viewInventory();
                break;
            case 'G': case 'g': //Go to ship menu
                this.ship();
                break;
            case 'Q': case 'q': //Save then goto main menu
                this.mainMenu();
                break;
                    
        }
        
    }

    private void explore() {
        Actor actorOne = new Actor(); //need to call getHome        
        System.out.println("\n\nYou have just explored " + actorOne.getHome());
        System.out.println("and found ");
    }

    private void findSomeone() {
        System.out.println("find someone");
    }
    
    private void viewStatus() {
        Actor actorOne = new Actor();
        InventoryList items1 = new InventoryList();
        System.out.println("\n\nYou currently on " + actorOne.getHome() );
        System.out.println("Your current force level is " + actorOne.getForceLevel());
        System.out.println("You have " + items1.getQuantity() + " Force Holograms");
        System.out.println("\n");
    }

    private void viewInventory() {
        InventoryMenuView inventoryMenu = new InventoryMenuView();
        inventoryMenu.displayMenu();
    }

    private void ship() {
        ShipMenuView shipMenu = new ShipMenuView();
        shipMenu.displayMenu();
    } 

    private void mainMenu() {
        
        // test script needs to be written for save game then main menu
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.displayMenu();
    }

    
}
