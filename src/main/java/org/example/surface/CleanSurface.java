package org.example.surface;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;
import org.example.plowhead.PlowHead;
import org.example.vehicle.Vehicle;

public class CleanSurface extends Surface {

    @Override
    public boolean handleVehicle(Vehicle v, Lane l) {
        Logger.call("CleanSurface", "handleVehicle(v, l)");
        // A tiszta út mindig átengedi a járművet
        Logger.ret("boolean", "true");
        return true;
    }

    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) {
        Logger.call("CleanSurface", "clean(head, inv, l)");
        // Nincs mit takarítani
        Logger.ret("boolean", "false");
        return false;
    }

    @Override
    public void receiveSnow(int amount, Lane l) {
        Logger.call("CleanSurface", "receiveSnow(amount, l)");
        // A 9. SD (Havazás) alapján tiszta útra eső hó havas felszínt csinál
        l.setSurface(new SnowySurface());
        Logger.retVoid();
    }
}
