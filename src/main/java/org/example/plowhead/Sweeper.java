package org.example.plowhead;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;
import org.example.surface.CleanSurface;

public class Sweeper extends PlowHead {

    @Override
    public void operate(Lane l, Inventory inv) {
        Logger.call("Sweeper", "operate(l, inv)");
        // A 9. szekvencia diagram alapján a havat egy szomszédos sávra tolja
        Lane neighborLane = new Lane(); // Szkeletonhoz egy dummy szomszéd
        neighborLane.receiveSnow(1);

        l.setSurface(new CleanSurface());
        Logger.retVoid();
    }
}
