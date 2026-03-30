package org.example.plowhead;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;

/**
 * Sót felhasználó eszköz, amely hatékonyan olvasztja fel a jeget a sávokról
 * körről körre. Csak addig működik, amíg van benne só a raktárban.
 */
public class Salter extends PlowHead {

    /**
     * A sót fogyasztva besózza a sávot (isSalted=true), ami ezután körönként
     * olvasztani fogja a jeget és a havat.
     *
     * @param l A takarítandó sáv
     * @param inv A gép nyersanyag raktára (sót fogyaszt belőle)
     */
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
