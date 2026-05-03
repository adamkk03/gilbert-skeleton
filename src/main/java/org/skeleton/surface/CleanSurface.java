package org.skeleton.surface;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;
import org.skeleton.plowhead.PlowHead;
import org.skeleton.vehicle.Vehicle;

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
    public boolean isAccessible() {
        return true;
    }

    @Override
    public void receiveSnow(int amount, Lane l) {
        l.setSurface(new SnowySurface());
    }
}
