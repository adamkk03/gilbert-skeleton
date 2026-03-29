package org.example.map;

import java.util.ArrayList;
import java.util.List;

import org.example.Inventory;
import org.example.Logger;
import org.example.plowhead.PlowHead;
import org.example.surface.CleanSurface;
import org.example.surface.Surface;
import org.example.vehicle.Vehicle;

public class Lane {

    private Surface surface = new CleanSurface();
    private boolean isSalted = false;

    // Hiányzó attribútumok pótolva
    private int snowThickness;
    private int iceThickness;
    private List<Vehicle> vehicles = new ArrayList<>();

    public boolean clean(PlowHead head, Inventory inv) {
        Logger.call("Lane", "clean(head, inv)");
        boolean result = this.surface.clean(head, inv, this);
        Logger.ret("boolean", String.valueOf(result));
        return result;
    }

    public boolean acceptVehicle(Vehicle v) {
        Logger.call("Lane", "acceptVehicle(v)");
        boolean result = this.surface.handleVehicle(v, this);
        Logger.ret("boolean", String.valueOf(result));
        return result;
    }

    public void receiveSnow(int amount) {
        Logger.call("Lane", "receiveSnow(" + amount + ")");
        this.surface.receiveSnow(amount, this);
        Logger.retVoid();
    }

    public void setSurface(Surface s) {
        Logger.call("Lane", "setSurface(s)");
        this.surface = s;
        Logger.retVoid();
    }

    public void setSalted(boolean salted) {
        Logger.call("Lane", "setSalted(" + salted + ")");
        this.isSalted = salted;
        Logger.retVoid();
    }

    // Hiányzó metódusok pótolva
    public void weatherTick() {
        Logger.call("Lane", "weatherTick()");
        Logger.retVoid();
    }

    public void propagateCrash() {
        Logger.call("Lane", "propagateCrash()");
        // Szkeletonban a belső iterációs logika imitálása
        Logger.retVoid();
    }
}
