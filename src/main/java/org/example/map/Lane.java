package org.example.map;

import org.example.Logger;
import org.example.player.Inventory;
import org.example.plowhead.PlowHead;
import org.example.surface.CleanSurface;
import org.example.surface.Surface;
import org.example.vehicle.Vehicle;

public class Lane {

    private Surface surface = new CleanSurface();
    private boolean isSalted = false;

    public boolean clean(PlowHead head, Inventory inv) {
        Logger.call("Lane", "clean(head, inv)");
        // A takarítást a jelenlegi felszínre (Surface) delegáljuk
        boolean result = this.surface.clean(head, inv, this);
        Logger.ret("boolean", String.valueOf(result));
        return result;
    }

    public boolean acceptVehicle(Vehicle v) {
        Logger.call("Lane", "acceptVehicle(v)");
        // A jármű ráhajtását a jelenlegi felszínre delegáljuk
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
}
