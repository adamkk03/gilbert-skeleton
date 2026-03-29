package org.example.plowhead;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;
import org.example.surface.BlockedSurface;

public class Icebreaker extends PlowHead {

    @Override
    public void operate(Lane l, Inventory inv) {
        Logger.call("Icebreaker", "operate(l, inv)");
        // A 10. szekvencia diagram alapján a jég feltörik, de ott marad törmelékként (Blocked)
        l.setSurface(new BlockedSurface());
        Logger.retVoid();
    }
}
