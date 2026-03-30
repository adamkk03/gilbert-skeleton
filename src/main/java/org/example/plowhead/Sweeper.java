package org.example.plowhead;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;
import org.example.surface.CleanSurface;

/**
 * Alapvető kotrófej, amely a havat képes a szomszédos sávba seperni.
 */
public class Sweeper extends PlowHead {

    /**
     * A vékony havat letakarítja és egy szomszédos sávra tolja, ezáltal a
     * jelenlegi sáv tiszta lesz.
     *
     * @param l A takarítandó sáv
     * @param inv A gép nyersanyag raktára
     */
    @Override
    public void operate(Lane l, Inventory inv) {
        Logger.call("Sweeper", "operate(l, inv)");
        Lane neighborLane = new Lane(); 
        neighborLane.receiveSnow(1);

        l.setSurface(new CleanSurface());
        Logger.retVoid();
    }
}
