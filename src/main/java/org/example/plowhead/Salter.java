package org.example.plowhead;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;

public class Salter extends PlowHead {

    @Override
    public void operate(Lane l, Inventory inv) {
        Logger.call("Salter", "operate(l, inv)");
        // A 11. szekvencia diagram alapján fogyasztja a sót, majd besózza a sávot
        boolean success = inv.consumeSalt();
        if (success) {
            l.setSalted(true);
        }
        Logger.retVoid();
    }
}
