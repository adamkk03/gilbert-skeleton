package org.skeleton.plowhead;

import org.skeleton.Inventory;
import org.skeleton.Logger;
import org.skeleton.map.Lane;
import org.skeleton.surface.BlockedSurface;

/**
 * Speciális fej, amely képes a felgyülemlett vastag jégpáncél összezúzására. Ez
 * után az összetört jég még jelen lesz az úton, ami miatt blokkolt lesz az út a
 * normál járművek számára.
 */
public class Icebreaker extends PlowHead {

    /**
     * Összezúzza a jeget, de otthagyja a feltörött jégtörmeléket a sávon,
     * ezáltal blokkolttá téve azt.
     *
     * @param l A takarítandó sáv
     * @param inv A gép nyersanyag raktára
     */
    @Override
    public void operate(Lane l, Inventory inv) {
        Logger.call("Icebreaker", "operate(l, inv)");
        l.setSurface(new BlockedSurface());
        Logger.retVoid();
    }
}
