package org.example.surface;

import org.example.Inventory;
import org.example.Plowhead.PlowHead;
import org.example.map.Lane;
import org.example.vehicle.Vehicle;

class IcySurface extends Surface {

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
