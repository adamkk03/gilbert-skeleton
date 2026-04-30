package org.skeleton.vehicle;

import org.skeleton.map.Lane;
import org.skeleton.map.Node;

public abstract class Vehicle {

    private Lane currentLane;
    private boolean isStuck;

    public boolean move(Lane destination) {
        if (isStuck) {
            return false;
        }
        if (destination.acceptVehicle(this)) {
            if (currentLane != null) {
                currentLane.removeVehicle(this);
            }
            currentLane = destination;
            return true;
        }
        return false;
    }

    public void slip() {
        this.isStuck = true;
    }

    public void free() {
        this.isStuck = false;
    }

    public void crash() {
        this.isStuck = true;
    }

    public Node getCurrentNode() {
        // Absztrakt visszatérés a struktúra bemutatásához
        return null;
    }

    public Lane getCurrentLane() {
        return currentLane;
    }

    public void setCurrentLane(Lane lane) {
        this.currentLane = lane;
    }

    public boolean isStuck() {
        return this.isStuck;
    }
}
