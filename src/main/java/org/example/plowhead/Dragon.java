package org.example.plowhead;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;
import org.example.surface.CleanSurface;

public class Dragon extends PlowHead {

    @Override
    public void operate(Lane l, Inventory inv) {
        Logger.call("Dragon", "operate(l, inv)");
        // A 12. szekvencia diagram alapján kerozint fogyaszt és letisztítja a pályát
        if (inv.consumeKerosene()) {
            l.setSurface(new CleanSurface());
        }
        Logger.retVoid();
    }
}
