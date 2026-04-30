package org.skeleton.plowhead;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;

public class Salter extends PlowHead {

    @Override
    public void operate(Lane l, Inventory inv) {
        if (inv.consumeSalt()) {
            l.setSalted(true);
        }
    }
}
