package org.example.vehicle;

import org.example.Logger;
import org.example.Questioner;
import org.example.map.Lane;
import org.example.map.Map;

/**
 * A játékos által irányított utasszállító, amely két végállomás között próbál
 * minél többször megfordulni.
 */
public class Bus extends Vehicle {

    /**
     * A játékos irányítása alapján megkísérel haladni az úton a célállomás
     * felé.
     *
     * @param map A város térképe a navigációhoz
     * @return Igaz, ha a lépés és az útvonalválasztás sikeres volt.
     */
    @Override
    public boolean move(Map map) {
        Logger.call("Bus", "move(map)");

        // A 14. szekvencia diagram (Busz sikeres célba érése) alapján halad
        Lane targetLane = map.getNextLane(this.currentLane, this.dest1);

        boolean success = false;
        if (targetLane != null) {
            success = targetLane.acceptVehicle(this);
        }

        boolean arrived = Questioner.ask("A busz elérte a célállomást?");
        if (arrived) {
        }

        Logger.ret("boolean", String.valueOf(success));
        return success;
    }
}
