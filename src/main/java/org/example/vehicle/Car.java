package org.example.vehicle;

import org.example.Logger;
import org.example.map.Lane;
import org.example.map.Map;

/**
 * A gép által irányított városi forgalmat (NPC jármű) reprezentáló osztály. A
 * legrövidebb utat keresi a végállomásai között.
 */
public class Car extends Vehicle {

    /**
     * A megörökölt absztrakt metódus implementációja. A kapott map objektum
     * segítségével lekéri a következő sávot a legrövidebb úton, majd rálép.
     *
     * @param map A város térképe a navigációhoz
     * @return Igaz, ha a sávra lépés (vagy legalább a rálépési kísérlet)
     * sikeres volt.
     */
    @Override
    public boolean move(Map map) {
        Logger.call("Car", "move(map)");

        // A 4. szekvencia diagram (Jégképződés) szerint lekéri a Map-től a következő sávot
        Lane targetLane = map.getNextLane(this.currentLane, this.dest1);

        boolean success = false;
        if (targetLane != null) {
            success = targetLane.acceptVehicle(this);
        }

        Logger.ret("boolean", String.valueOf(success));
        return success;
    }
}
