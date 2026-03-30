package org.example.vehicle;

import org.example.Logger;
import org.example.map.Lane;
import org.example.map.Map;
import org.example.map.Node;

/**
 * A sávokon közlekedő, az időjárásnak és az útviszonyoknak kitett entitások
 * általános fogalma. Nyilvántartja a saját pozícióját, a célállomásait, és hogy
 * éppen elakadt-e. Haladásával a havat letapossa, jégen pedig balesetet
 * szenvedhet, amivel blokkolja az utat a többiek elől.
 */
public abstract class Vehicle {

    protected Lane currentLane;
    protected boolean isStuck = false;
    protected Node dest1;
    protected Node dest2;

    /**
     * Leszármazottakban megvalósítandó mozgási logika.
     *
     * @param map A város teljes úthálózatának nyilvántartója, ami alapján a
     * jármű navigál.
     * @return Igaz, ha a jármű sikeresen mozgott.
     */
    public abstract boolean move(Map map);

    /**
     * Kiszabadítja a járművet az elakadásból (isStuck = false).
     */
    public void free() {
        Logger.call("Vehicle", "free()");
        Logger.retVoid();
    }

    /**
     * Jeges sávon történő baleset esetén hívódik meg, mozgásképtelenné téve a
     * járművet.
     */
    public void crash() {
        Logger.call("Vehicle", "crash()");
        Logger.retVoid();
    }

}
