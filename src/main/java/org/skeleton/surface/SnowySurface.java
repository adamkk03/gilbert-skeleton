package org.skeleton.surface;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;
import org.skeleton.plowhead.PlowHead;
import org.skeleton.vehicle.Vehicle;

public class SnowySurface extends Surface {

    private final int THICKNESS_LIMIT = 5;
    private final int CRITICAL_TRAMPLE_LIMIT = 3;

    @Override
    public boolean handleVehicle(Vehicle v, Lane l) {
        if (l.getSnowThickness() > THICKNESS_LIMIT) {
            v.slip();
            return false;
        }
        l.incrementTrampleCount();
        if (l.getTrampleCount() >= CRITICAL_TRAMPLE_LIMIT) {
            l.setSurface(new IcySurface());
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
