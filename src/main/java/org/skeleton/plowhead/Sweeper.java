package org.skeleton.plowhead;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;
import org.skeleton.surface.CleanSurface;

public class Sweeper extends PlowHead {

    @Override
    public void operate(Lane l, Inventory inv) {
        int snowAmount = l.getSnowThickness();
        if (snowAmount > 0 && l.getRoad() != null) {
            l.getRoad().pushSnow(l, snowAmount);
        }

        l.setSurface(new CleanSurface());
        l.setGraveled(false);
    }
}
