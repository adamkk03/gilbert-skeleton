package org.example.surface;

import org.example.Inventory;
import org.example.Plowhead.PlowHead;
import org.example.map.Lane;
import org.example.vehicle.Vehicle;

abstract class Surface {

    public abstract boolean handleVehicle(Vehicle v, Lane l);

    public abstract boolean clean(PlowHead head, Inventory inv, Lane l);

    public abstract void receiveSnow(int amount, Lane l);
}
