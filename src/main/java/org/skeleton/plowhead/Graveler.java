package org.skeleton.plowhead;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;

public class Graveler extends PlowHead {

    @Override
    public void operate(Lane l, Inventory inv) {
        if (inv.consumeGravel()) {
            l.setGraveled(true);
        }
    }
}
