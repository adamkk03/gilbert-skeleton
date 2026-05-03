package org.skeleton.surface;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;
import org.skeleton.plowhead.PlowHead;
import org.skeleton.vehicle.Vehicle;

public class IcySurface extends Surface {

    @Override
    public boolean handleVehicle(Vehicle v, Lane l) {
        if (!l.isGraveled()) {
            v.crash();
            l.setSurface(new BlockedSurface());
            return false;
        }
        return true;
    }

    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) {
        if (head != null) {
            head.operate(l, inv);
            return true;
        }
        return false;
    }

    @Override
    public boolean isAccessible() {
        return true;
    }

    @Override
    public void receiveSnow(int amount, Lane l) {
        l.setSnowThickness(l.getSnowThickness() + amount);
    }
}
