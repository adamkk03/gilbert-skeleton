package org.skeleton.plowhead;

import org.skeleton.Inventory;
import org.skeleton.Logger;
import org.skeleton.map.Lane;
import org.skeleton.surface.CleanSurface;

/**
 * Erősebb kotrófej, amely nagyobb mennyiségű havat képes messzebbre, az útról
 * teljesen letakarítani (tehát nem egy szomszédos sávba löki, hanem
 * megsemmisíti).
 */
public class Thrower extends PlowHead {

    /**
     * A nagyobb mennyiségű havat teljesen eltünteti az útról, így a sáv tiszta
     * állapotú lesz.
     *
     * @param l A takarítandó sáv
     * @param inv A gép nyersanyag raktára
     */
    @Override
    public void operate(Lane l, Inventory inv) {
        Logger.call("Thrower", "operate(l, inv)");
        l.setSurface(new CleanSurface());
        Logger.retVoid();
    }
}
