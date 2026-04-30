package org.skeleton.plowhead;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;
import org.skeleton.surface.BlockedSurface;

public class Icebreaker extends PlowHead {

    @Override
    public void operate(Lane l, Inventory inv) {
        l.setSurface(new BlockedSurface());
    }
}
