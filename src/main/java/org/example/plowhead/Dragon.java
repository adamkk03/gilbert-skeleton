package org.example.plowhead;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;
import org.example.surface.CleanSurface;

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
        boolean success = inv.consumeKerosene();
        if (success) {
            l.setSurface(new CleanSurface());
        }
        Logger.retVoid();
    }
}
