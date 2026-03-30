package org.example.plowhead;

import org.example.Inventory;
import org.example.map.Lane;

/**
 * A hókotrókra felszerelhető munkaeszközök általános fogalma. Meghatározza,
 * hogy a gép hogyan és mennyi havat vagy jeget tud eltakarítani az útról.
 */
public abstract class PlowHead {

    /**
     * A fej működését elindító parancs. A különböző leszármazottak eltérő módon
     * valósítják meg a takarítást (pl. söprés, olvasztás).
     *
     * @param l A takarítandó sáv
     * @param inv A gép nyersanyag raktára (pl. sóhoz, kerozinhoz)
     */
    public abstract void operate(Lane l, Inventory inv);
}
