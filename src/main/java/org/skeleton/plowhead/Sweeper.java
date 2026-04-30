package org.skeleton.plowhead;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;
import org.skeleton.surface.CleanSurface;

public class Sweeper extends PlowHead {

    @Override
    public void operate(Lane l, Inventory inv) {
        // Ide kerülne a Road objektumon keresztüli hólökés, a sávot magát megtisztítja
        l.setSurface(new CleanSurface());
        l.setGraveled(false);
    }
}
