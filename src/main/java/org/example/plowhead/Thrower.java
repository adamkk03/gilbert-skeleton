package org.example.plowhead;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;
import org.example.surface.CleanSurface;

public class Thrower extends PlowHead {

    @Override
    public void operate(Lane l, Inventory inv) {
        Logger.call("Thrower", "operate(l, inv)");
        // A 8. szekvencia diagram alapján teljesen eltünteti a havat az útról
        l.setSurface(new CleanSurface());
        Logger.retVoid();
    }
}
