package org.example.Surface;

import org.example.Inventory;
import org.example.Map.Lane;
import org.example.Plowhead.PlowHead;
import org.example.Vehicle.Vehicle;

class SnowySurface extends Surface {
    @Override
    public boolean handleVehicle(Vehicle v, Lane l) { return true; }
    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) { return true; }
    @Override
    public void receiveSnow(int amount, Lane l) {}
}