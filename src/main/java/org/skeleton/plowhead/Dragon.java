package org.skeleton.plowhead;

import org.skeleton.Inventory;
import org.skeleton.Logger;
import org.skeleton.map.Lane;
import org.skeleton.surface.CleanSurface;

/**
 * Biokerozint égető, rendkívül erős eszköz, amely minden havat és jeget azonnal
 * megsemmisít. Csak addig működik, amíg van üzemanyaga a raktárban.
 */
public class Dragon extends PlowHead {

    /**
     * A kerozint fogyasztva elpárologtat minden havat és jeget az útról,
     * azonnal tiszta felszínt hagyva maga után.
     *
     * @param l A takarítandó sáv
     * @param inv A gép nyersanyag raktára (kerozint fogyaszt belőle)
     */
    @Override
    public void operate(Lane l, Inventory inv) {
        Logger.call("Dragon", "operate(l, inv)");
        // A 12. szekvencia diagram alapján kerozint fogyaszt és letisztítja a pályát
        boolean success = inv.consumeKerosene();
        if (success) {
            l.setSurface(new CleanSurface());
        }
        Logger.retVoid();
    }
}
