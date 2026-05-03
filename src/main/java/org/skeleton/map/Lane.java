package org.skeleton.map;

import java.util.ArrayList;
import java.util.List;

import org.skeleton.Inventory;
import org.skeleton.plowhead.PlowHead;
import org.skeleton.surface.CleanSurface;
import org.skeleton.surface.Surface;
import org.skeleton.vehicle.Vehicle;

public class Lane {

    private int snowThickness;
    private boolean isIcy;
    private boolean isGraveled;
    private int saltAmount;
    private int trampleCount;
    private List<Vehicle> vehicles;
    private Surface surface;
    private final int THICKNESS_LIMIT = 5;

    public Lane() {
        this.vehicles = new ArrayList<>();
        this.surface = new CleanSurface();
    }

    public void addSnow(int amount) {
        if (saltAmount > 0) {
            saltAmount--;
        } else {
            snowThickness += amount;
            if (isGraveled && snowThickness > THICKNESS_LIMIT) {
                isGraveled = false;
            }
            surface.receiveSnow(amount, this);
        }
    }

    public void propagateCrash() {
        for (Vehicle v : vehicles) {
            v.crash();
        }
    }

    public Surface getSurface() {
        return surface;
    }

    public boolean acceptVehicle(Vehicle v) {
        if (surface.handleVehicle(v, this)) {
            vehicles.add(v);
            return true;
        }
        return false;
    }

    public void removeVehicle(Vehicle v) {
        vehicles.remove(v);
    }

    public boolean clean(PlowHead head, Inventory inv) {
        return surface.clean(head, inv, this);
    }

    public void setSurface(Surface s) {
        this.surface = s;
    }

    public void setGraveled(boolean b) {
        this.isGraveled = b;
    }

    public boolean isGraveled() {
        return this.isGraveled;
    }

    public void setSalted(boolean b) {
        if (b) {
            this.saltAmount = 5; // Példa érték

        }
    }

    public boolean isSalted() {
        return this.saltAmount > 0;
    }

    public int getSnowThickness() {
        return snowThickness;
    }

    public void incrementTrampleCount() {
        trampleCount++;
    }

    public int getTrampleCount() {
        return trampleCount;
    }

    public void receiveSnow(int amount) {
        this.addSnow(amount);
    }

    public boolean isAccessible() {
        // Segédmetódus a Road osztály hasAccessibleLane ellenőrzéséhez
        return !(surface instanceof org.skeleton.surface.BlockedSurface);
    }
}
