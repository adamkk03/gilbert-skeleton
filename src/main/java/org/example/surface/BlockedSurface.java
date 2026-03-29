package org.example.surface;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;
import org.example.plowhead.PlowHead;
import org.example.vehicle.Vehicle;

public class BlockedSurface extends Surface {

    @Override
    public boolean handleVehicle(Vehicle v, Lane l) {
        Logger.call("BlockedSurface", "handleVehicle(v, l)");
        // Az 1. SD (Sávváltás balesetnél) alapján a blokkolt út nem enged át senkit
        Logger.ret("boolean", "false");
        return false;
    }

    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) {
        Logger.call("BlockedSurface", "clean(head, inv, l)");
        // A 16. SD alapján a hókotró eltakarítja a roncsot vagy feltört jeget
        head.operate(l, inv);
        Logger.ret("boolean", "true");
        return true;
    }

    @Override
    public void receiveSnow(int amount, Lane l) {
        Logger.call("BlockedSurface", "receiveSnow(amount, l)");
        Logger.retVoid();
    }
}
