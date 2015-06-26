/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.pathOfTheJedi.view;

import byui.cit260.pathOfTheJedi.model.Player;

/**
 *
 * @author Technology Handyman
 */
public class ShipMenuView extends View {
    
            public ShipMenuView() {                
                super("\n"
                + "\n(II:::::::::<[==============================================="
                + "\n                        Ship Menu"
                + "\n(II:::::::::<[==============================================="
                + "\n T - Train With R4"            
                + "\n W - Workshop"
                + "\n N - Next Planet"
                + "\n E - Exit Ship"
                + "\n(II:::::::::<[===============================================");
            }
   
    @Override
    public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered
        
        switch (choice){
            case 'T': case 't': //Goto Train R4 Menu
                this.trainR4Menu();
                break;            
            case 'W': case 'w': //Woekshop Menu
                this.workshop();
                break;
            case 'N': case 'n': //Woekshop Menu
                this.nextPlanet();
                break;
            case 'E': case 'e': //Exit ship goto current Planet
                this.exitShip();
                break;       
        }
        return false;
    }

    private void trainR4Menu() {
            System.out.println("\n\n             ______             ");
            System.out.println("          ,-'//__\\`-.          ");
            System.out.println("        ,'  ____      `.        ");
            System.out.println("       /   / ,-.-.      |       ");
            System.out.println("      (/# /__`-'_| || || )      ");
            System.out.println("      ||# []/()] O || || |      ");
            System.out.println("    __`------------------'__    ");
            System.out.println("   |--| |<=={_______}=|| |--|   ");
            System.out.println("   |  | |-------------|| |  |   ");
            System.out.println("   |  | |={_______}==>|| |  |   ");
            System.out.println("   |  | |   |: _ :|   || |  |   ");
            System.out.println("   > _| |___|:===:|   || |__<   ");
            System.out.println("   :| | __| |: - :|   || | |:   ");
            System.out.println("   :| | ==| |: _ :|   || | |:   ");
            System.out.println("   :| | ==|_|:===:|___||_| |:   ");
            System.out.println("   :| |___|_|:___:|___||_| |:   ");
            System.out.println("   :| |||   ||/_||| ||| -| |:   ");
            System.out.println("   ;I_|||[]_|||_||| ||| -|_I;   ");
            System.out.println("   |_ |__________________| _|   ");
            System.out.println("   | `|||___|____|____/_//' |   ");
            System.out.println("   J : |     |____/     | : L   ");
            System.out.println("  _|_: |      |__|      | :_|_  ");
            System.out.println("-/ _-_.'    -/    |-    `.-_- |-");
            System.out.println("/______|    /______|    /______|");
            System.out.println("\n");
        TrainR4MenuView trainR4 = new TrainR4MenuView();
        trainR4.display();
    }

    private void workshop() {
        WorkShopView myWorkShop = new WorkShopView();
        myWorkShop.display();
    }
    
    private void nextPlanet() {
        System.out.println("travel");
        Player actorOne = new Player();
        System.out.println("\n\nYou currently on " + Player.getHome() );
        
        if ("New Super Star Destroyer".equals(Player.getHome())){
            System.out.println("\n\nYou are at you final destination");
        }else{
              switch (Player.getHome()){
            case "Kashyyk":  
                Player.setHome("Mandalore");
                break;            
            case "Mandalore":  
                Player.setHome("New Tatooine");
                break;
            case "New Tatooine":  
                Player.setHome("Rantine Space Station");
                break;
            case "Rantine Space Station":  
                Player.setHome("New Super Star Destroyer");
                break;
            case "New Super Star Destroyer":  
                break;
        }
        System.out.println("You have traveled to " + Player.getHome());
        }
    }

    private void exitShip() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
}
