package org.skeleton.plowhead;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;
import org.skeleton.surface.CleanSurface;

public class Thrower extends PlowHead {

    @Override
    public void operate(Lane l, Inventory inv) {
        l.setSurface(new CleanSurface());
        l.setGraveled(false);
    }
}
