package org.skeleton.surface;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;
import org.skeleton.plowhead.PlowHead;
import org.skeleton.vehicle.Vehicle;

public class BlockedSurface extends Surface {

    @Override
    public boolean handleVehicle(Vehicle v, Lane l) {
        return false;
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
    public void receiveSnow(int amount, Lane l) {
        // Blokkolt úton a havazásnak nincs további hatása a járhatóságra
    }
}
