/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.pathOfTheJedi.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author David
 */
public class Map implements Serializable {
    
    private String currentLocation;

    public Map() {
    }
    
    public void initialize() {
        this.getCurrentLocation();
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.currentLocation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Map other = (Map) obj;
        return Objects.equals(this.currentLocation, other.currentLocation);
    }

    @Override
    public String toString() {
        return "Map{" + "currentLocation=" + currentLocation + '}';
    }
    
    
    
}
