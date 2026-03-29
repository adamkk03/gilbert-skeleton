package org.example.surface;

import org.example.*;
import org.example.Plowhead.PlowHead;
import org.example.map.Lane;
import org.example.vehicle.Vehicle;

class BlockedSurface extends Surface {

    @Override
    public boolean handleVehicle(Vehicle v, Lane l) {
        return false;
    }

    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) {
        return false;
    }

    @Override
    public void receiveSnow(int amount, Lane l) {
    }
}
