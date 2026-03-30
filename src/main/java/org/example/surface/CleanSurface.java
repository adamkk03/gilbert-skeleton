package org.example.surface;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;
import org.example.plowhead.PlowHead;
import org.example.vehicle.Vehicle;

/**
 * A sáv biztonságos, hó- és jégmentes állapota. A járművek akadálytalanul
 * áthaladhatnak rajta.
 */
public class CleanSurface extends Surface {

    /**
     * Megvalósítja az ős absztrakt metódusát. A tiszta út mindig akadálytalanul
     * átengedi a járművet.
     *
     * @param v Az áthaladó jármű
     * @param l Az aktuális sáv
     * @return Mindig igaz, biztosítja az áthaladást.
     */
    @Override
    public boolean handleVehicle(Vehicle v, Lane l) {
        Logger.call("CleanSurface", "handleVehicle(v, l)");
        Logger.ret("boolean", "true");
        return true;
    }

    /**
     * Megvalósítja az ős absztrakt metódusát. Tiszta úton nincs mit takarítani.
     *
     * @param head A takarító fej
     * @param inv A hókotró inventory-ja
     * @param l A takarítandó sáv
     * @return Mindig hamis, mivel nincs hatása a takarításnak.
     */
    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) {
        Logger.call("CleanSurface", "clean(head, inv, l)");
        // Nincs mit takarítani
        Logger.ret("boolean", "false");
        return false;
    }

    /**
     * Megvalósítja az ős absztrakt metódusát. A havazás fogadásakor tiszta útra
     * eső hó havas felszínt (SnowySurface) csinál.
     *
     * @param amount A leeső hó mennyisége
     * @param l A sáv, ami a havat kapja
     */
    @Override
    public void receiveSnow(int amount, Lane l) {
        Logger.call("CleanSurface", "receiveSnow(amount, l)");
        l.setSurface(new SnowySurface());
        Logger.retVoid();
    }
}
