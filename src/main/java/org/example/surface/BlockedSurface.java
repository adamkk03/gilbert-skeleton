package org.example.surface;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;
import org.example.plowhead.PlowHead;
import org.example.vehicle.Vehicle;

/**
 * Valamely ok miatti áthatolhatatlan állapot. Lehet az baleset, túl vastag hó,
 * vagy feltördelt jég.
 */
public class BlockedSurface extends Surface {

    /**
     * A blokkolt út nem enged át senkit.
     *
     * @param v Az áthaladni próbáló jármű
     * @param l Az aktuális sáv
     * @return Mindig hamis, elutasítja a járművet.
     */
    @Override
    public boolean handleVehicle(Vehicle v, Lane l) {
        Logger.call("BlockedSurface", "handleVehicle(v, l)");
        Logger.ret("boolean", "false");
        return false;
    }

    /**
     * A hókotró eltakarítja a roncsot vagy feltört jeget, és kiszabadítja a
     * járműveket.
     *
     * @param head A takarító fej
     * @param inv A hókotró inventory-ja
     * @param l A takarítandó sáv
     * @return Igaz, ha sikeres volt az akadály elhárítása.
     */
    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) {
        Logger.call("BlockedSurface", "clean(head, inv, l)");
        head.operate(l, inv);
        Logger.ret("boolean", "true");
        return true;
    }

    /**
     * Havazás fogadása a blokkolt úton.
     *
     * @param amount A leeső hó mennyisége
     * @param l A sáv, ami a havat kapja
     */
    @Override
    public void receiveSnow(int amount, Lane l) {
        Logger.call("BlockedSurface", "receiveSnow(amount, l)");
        Logger.retVoid();
    }
}
