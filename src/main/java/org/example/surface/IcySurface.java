package org.example.surface;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;
import org.example.plowhead.PlowHead;
import org.example.vehicle.Vehicle;

/**
 * A sáv csúszós, jeges állapota. A rálépő járművek elvesztik az irányítást és
 * balesetet szenvednek rajta.
 */
public class IcySurface extends Surface {

    /**
     * Jeges útra lépve az autó megcsúszik és balesetet szenved
     * (BlockedSurface-re vált).
     *
     * @param v Az áthaladni próbáló jármű
     * @param l Az aktuális sáv
     * @return Igaz (a jármű rálépett a sávra, csak épp balesetet szenvedett).
     */
    @Override
    public boolean handleVehicle(Vehicle v, Lane l) {
        Logger.call("IcySurface", "handleVehicle(v, l)");
        // 8. SD és 5. SD: Jeges útra lépve az autó megcsúszik és balesetet szenved
        v.crash();
        l.setSurface(new BlockedSurface());
        Logger.ret("boolean", "true");
        return true;
    }

    /**
     * Csak bizonyos speciális fejek (pl. jégtörő, sárkány) tudják eltüntetni a
     * jeget.
     *
     * @param head A takarító fej
     * @param inv A hókotró inventory-ja
     * @param l A takarítandó sáv
     * @return Igaz, ha sikeres volt a takarítás.
     */
    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) {
        Logger.call("IcySurface", "clean(head, inv, l)");
        head.operate(l, inv);
        Logger.ret("boolean", "true");
        return true;
    }

    /**
     * A jégre eső havat kezeli havazáskor.
     *
     * @param amount A leeső hó mennyisége
     * @param l A sáv, ami a havat kapja
     */
    @Override
    public void receiveSnow(int amount, Lane l) {
        Logger.call("IcySurface", "receiveSnow(amount, l)");
        Logger.retVoid();
    }
}
