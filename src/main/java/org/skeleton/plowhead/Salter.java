package org.skeleton.plowhead;

import org.skeleton.Inventory;
import org.skeleton.Logger;
import org.skeleton.map.Lane;

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
        boolean success = inv.consumeSalt();
        if (success) {
            l.setSalted(true);
        }
        Logger.retVoid();
    }
}
