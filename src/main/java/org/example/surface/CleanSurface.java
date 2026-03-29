package org.example.surface;

import org.example.Inventory;
import org.example.map.Lane;
import org.example.plowhead.PlowHead;
import org.example.vehicle.Vehicle;

public class CleanSurface extends Surface {

    @Override
    public boolean handleVehicle(Vehicle v, Lane l) {
        return true;
    }

    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) {
        return false;
    }

    @Override
    public void receiveSnow(int amount, Lane l) {
    }
}
