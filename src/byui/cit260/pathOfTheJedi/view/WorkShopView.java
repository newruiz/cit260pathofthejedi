/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.pathOfTheJedi.view;

import byui.cit260.pathOfTheJedi.model.ItemsAvailable;
import byui.cit260.pathOfTheJedi.model.Player;
import byui.cit260.pathOfTheJedi.model.TrainR4;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class WorkShopView extends View {
    
    public WorkShopView(){
    
            super("\n"
            + "\n(II:::::::::<[==============================================="
            + "\n                        Work Shop"
            + "\n(II:::::::::<[==============================================="
            + "\n 1 - Veiw Crystals"
            + "\n 2 - Veiw Shell"
            + "\n 3 - Build Light Sabre"
            + "\n 4 - Quit"
            + "\n(II:::::::::<[===============================================");            
        }          
            

    

    @Override
        public boolean doAction(Object obj) {
        String value = (String) obj;
        value = value.toUpperCase(); // convert to all upper case
        char choice = value.charAt(0); // get first character entered {
        
        switch (choice){
            case '1': //load a game
                this.viewCrystals();
                break;
            case '2': //New game
                this.viewShell();
                break;
            case '3': //How to play menu
                this.buildLightSabre();
                break;
            case '4': //How to play menu
                this.exitWorkshop();
                break;
            
                    
        }
        return false;
        
    }
    public void viewCrystals(){
        //TODO; create view crystals method
        this.console.println("\nList of Crystals");
                
        ArrayList<ItemsAvailable> onhnd = ItemsAvailable.OnHand;
        for (ItemsAvailable itemsAvailable : onhnd){
            String type = itemsAvailable.getType();
            String planet = itemsAvailable.getPlanet();
            double power = itemsAvailable.getPower();
            if ("Lightsaber_Crystal".equals(type)){
            this.console.println(type + " | Power = " 
                    + power 
                    + " \t");
            }
        }   
    }
    public void viewShell(){
        //TODO; create view crystal method
        this.console.println("\nList of Shells");
                
        ArrayList<ItemsAvailable> onhnd = ItemsAvailable.OnHand;
        for (ItemsAvailable itemsAvailable : onhnd){
            String type = itemsAvailable.getType();
            String planet = itemsAvailable.getPlanet();
            double power = itemsAvailable.getPower();
            if ("Lightsaber_Shell".equals(type)){
            this.console.println(type + " | Power = " 
                    + power 
                    + " \t");
            }
        }
    }
    public void buildLightSabre(){
        try {
            //TODO; creat build light sabre method
            this.console.println("\n\nBuild Lightsaber");
            this.console.println("\nSelect crystal:");
            int i = 1;
            this.console.println("[ 0 ] - None\t");
            ArrayList<ItemsAvailable> onhnd = ItemsAvailable.OnHand;
            for (ItemsAvailable itemsAvailable : onhnd){
                String type = itemsAvailable.getType();
                String planet = itemsAvailable.getPlanet();
                double power = itemsAvailable.getPower();
                if ("Lightsaber_Crystal".equals(type)){
                    this.console.println("[ "
                            + i
                            + " ] - "
                            + type + " | Power = "
                            + power
                            + " \t");
                }
                i++;
            }
            this.console.println("What crystal do you want to equip?");
            String entry = this.keyboard.readLine().trim();
            int rnum1 = 0;
            String centry = "";
            for(i = 0; i <= entry.length() -1 ; i++){
                char ch = entry.charAt(i);
                if (Character.isDigit(ch)){
                    centry = centry + ch;
                    rnum1 = Integer.parseInt(centry);                  
                }
            }
            if (rnum1 > 0 ) {
                
                this.console.println("\n\nSelect shell:");
                i = 1;
                this.console.println("[ 0 ] - None\t");        
                for (ItemsAvailable itemsAvailable : onhnd){
                    String type = itemsAvailable.getType();
                    String planet = itemsAvailable.getPlanet();
                    double power = itemsAvailable.getPower();
                    if ("Lightsaber_Shell".equals(type)){
                        this.console.println("[ "
                                + i
                                + " ] - "
                                + type + " | Power = "
                                + power
                                + " \t");
                    }
                    i++;
                }
                this.console.println("What shell do you want to equip?");
                entry = this.keyboard.readLine().trim();
                int rnum2 = 0;
                centry = "";
                for(i = 0; i <= entry.length() -1 ; i++){
                    char ch = entry.charAt(i);
                    if (Character.isDigit(ch)){
                        centry = centry + ch;
                        rnum2 = Integer.parseInt(centry);                  
                    }
                }
                if (rnum2 != 0 ) {
                    double cPower = ItemsAvailable.OnHand.get(rnum1 -1).getPower();
                    double sPower = ItemsAvailable.OnHand.get(rnum2 -1).getPower();
                    
                    TrainR4.setLightSaberScore(cPower + sPower);
                    double updateForceLevel = TrainR4.getLightSaberScore()
                            + TrainR4.getCombat()
                            + TrainR4.getPush()
                            + TrainR4.getDefence()
                            + TrainR4.getForceAffinity();
                    
                    Player.setForceLevel(updateForceLevel);
                    this.console.println("\n\nLighsaber has been built!");
                    this.console.println("You now have a force level of " + updateForceLevel);
                }
            } } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }
    
    public void exitWorkshop(){
       ShipMenuView shipMenu = new ShipMenuView();
       shipMenu.display(); 
    }
}
