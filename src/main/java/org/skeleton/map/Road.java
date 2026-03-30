package org.skeleton.map;

import java.util.ArrayList;
import java.util.List;

import org.skeleton.Logger;

/**
 * A csomópontokat összekötő útszakasz. Felelőssége az egymás mellett haladó
 * sávok (Lane) összefogása, valamint annak koordinálása, hogy a takarítás során
 * oldalra tolt hó a megfelelő szomszédos sávba kerüljön.
 */
public class Road {

    private List<Lane> lanes = new ArrayList<>();

    /**
     * Végigiterál a sávokon, és mindegyiknek delegálja a havazást. Az időjárás
     * hatása propagálódik az összes sávra.
     */
    public void weatherTick() {
        Logger.call("Road", "weatherTick()");
        for (Lane lane : lanes) {
            if (lane != null) {
                lane.receiveSnow(1);
            }
        }
        Logger.retVoid();
    }

    /**
     * A kiinduló sáv indexe alapján megkeresi a szomszédos sávot, és áttolja
     * oda a havat.
     *
     * @param from A sáv, ahonnan a havat tolják
     * @param amount Az áttolt hó mennyisége
     * @param pushRight Igaz, ha jobbra toljuk a havat, hamis, ha balra
     */
    public void pushSnow(Lane from, int amount, boolean pushRight) {
        Logger.call("Road", "pushSnow(from, " + amount + ", " + pushRight + ")");
        int fromIndex = lanes.indexOf(from);
        if (fromIndex >= 0) {
            int toIndex = pushRight ? fromIndex + 1 : fromIndex - 1;
            if (toIndex >= 0 && toIndex < lanes.size() && lanes.get(toIndex) != null) {
                lanes.get(toIndex).receiveSnow(amount);
            }
        }
        Logger.retVoid();
    }
}
