package org.skeleton.surface;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;
import org.skeleton.plowhead.PlowHead;
import org.skeleton.vehicle.Vehicle;

public abstract class Surface {

    public abstract boolean handleVehicle(Vehicle v, Lane l);

    public abstract boolean clean(PlowHead head, Inventory inv, Lane l);

    public abstract void receiveSnow(int amount, Lane l);
}
