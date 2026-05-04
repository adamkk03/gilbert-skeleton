package org.skeleton.map;

import java.util.ArrayList;
import java.util.List;

import org.skeleton.Inventory;
import org.skeleton.plowhead.PlowHead;
import org.skeleton.surface.CleanSurface;
import org.skeleton.surface.Surface;
import org.skeleton.vehicle.Vehicle;

/**
 * Represents a single lane on a road.
 * Tracks snow thickness, surface type, modifiers like salt/gravel, and vehicles currently on the lane.
 */
public class Lane {

    /** Current thickness of snow on the lane. */
    private int snowThickness;
    /** Indicates if the lane is currently icy (redundant with surface type but used in some logic). */
    private boolean isIcy;
    /** Indicates if the lane has been covered with gravel. */
    private boolean isGraveled;
    /** The remaining amount of salt on the lane. */
    private int saltAmount;
    /** Count of how many times the snow has been trampled. */
    private int trampleCount;
    /** List of vehicles currently located on this lane. */
    private List<Vehicle> vehicles;
    /** The current surface type of the lane. */
    private Surface surface;
    /** Thickness limit after which gravel becomes ineffective. */
    private final int THICKNESS_LIMIT = 5;
    /** The road this lane belongs to. */
    private Road road;

    /**
     * Constructs a new Lane with a clean surface and no vehicles.
     */
    public Lane() {
        this.vehicles = new ArrayList<>();
        this.surface = new CleanSurface();
    }

    /**
     * Adds snow to the lane, accounting for salt and gravel.
     * @param amount The amount of snow to add.
     */
    public void addSnow(int amount) {
        if (isSalted()) {
            surface.reactToSalt(this);
            saltAmount--;
        } else {
            surface.receiveSnow(amount, this);
            if (isGraveled && snowThickness > THICKNESS_LIMIT) {
                isGraveled = false;
            }
        }
    }

    /**
     * Propagates a crash to all vehicles on this lane.
     */
    public void propagateCrash() {
        for (Vehicle v : vehicles) {
            v.crash();
        }
    }

    /**
     * Gets the current surface of the lane.
     * @return The surface object.
     */
    public Surface getSurface() {
        return surface;
    }

    /**
     * Accepts a vehicle onto the lane if the surface allows it.
     * @param v The vehicle to accept.
     * @return true if the vehicle was accepted, false otherwise.
     */
    public boolean acceptVehicle(Vehicle v) {
        if (surface.handleVehicle(v, this)) {
            vehicles.add(v);
            return true;
        }
        return false;
    }

    /**
     * Removes a vehicle from the lane.
     * @param v The vehicle to remove.
     */
    public void removeVehicle(Vehicle v) {
        vehicles.remove(v);
    }

    /**
     * Attempts to clean the lane using a plow head and resources.
     * @param head The plow head used for cleaning.
     * @param inv The inventory containing resources.
     * @return true if cleaning was successful, false otherwise.
     */
    public boolean clean(PlowHead head, Inventory inv) {
        return surface.clean(head, inv, this);
    }

    /**
     * Sets the surface type of the lane.
     * @param s The new surface.
     */
    public void setSurface(Surface s) {
        this.surface = s;
    }

    /**
     * Sets whether the lane is covered with gravel.
     * @param b true to gravel the lane, false otherwise.
     */
    public void setGraveled(boolean b) {
        this.isGraveled = b;
    }

    /**
     * Checks if the lane is covered with gravel.
     * @return true if graveled, false otherwise.
     */
    public boolean isGraveled() {
        return this.isGraveled;
    }

    /**
     * Sets whether the lane is salted.
     * @param b true to salt the lane, false otherwise.
     */
    public void setSalted(boolean b) {
        if (b) {
            this.saltAmount = 5; // Example default value
        }
    }

    /**
     * Checks if the lane is currently salted.
     * @return true if salt amount is greater than zero, false otherwise.
     */
    public boolean isSalted() {
        return this.saltAmount > 0;
    }

    /**
     * Gets the current snow thickness.
     * @return The snow thickness value.
     */
    public int getSnowThickness() {
        return snowThickness;
    }

    /**
     * Sets the snow thickness.
     * @param amount The new thickness value.
     */
    public void setSnowThickness(int amount) {
        this.snowThickness = amount;
    }

    /**
     * Increments the count of times snow has been trampled on this lane.
     */
    public void incrementTrampleCount() {
        trampleCount++;
    }

    /**
     * Gets the trample count.
     * @return The trample count value.
     */
    public int getTrampleCount() {
        return trampleCount;
    }

    /**
     * Receives snow on the lane (alias for addSnow).
     * @param amount The amount of snow received.
     */
    public void receiveSnow(int amount) {
        this.addSnow(amount);
    }

    /**
     * Checks if the lane is accessible based on its surface.
     * @return true if accessible, false otherwise.
     */
    public boolean isAccessible() {
        return surface.isAccessible();
    }

    /**
     * Sets the road this lane belongs to.
     * @param r The road instance.
     */
    public void setRoad(Road r) {
        this.road = r;
    }

    /**
     * Gets the road this lane belongs to.
     * @return The road instance.
     */
    public Road getRoad() {
        return this.road;
    }
}
