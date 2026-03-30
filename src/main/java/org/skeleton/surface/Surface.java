package org.skeleton.surface;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;
import org.skeleton.plowhead.PlowHead;
import org.skeleton.vehicle.Vehicle;

/**
 * Az úttest felületének fizikai minőségét reprezentáló általános fogalom.
 * Meghatározza, hogy a rajta lévő járművek hogyan viselkednek (biztonságosan
 * haladnak, elakadnak vagy megcsúsznak), és hogyan reagál a takarításra.
 */
public abstract class Surface {

    /**
     * Kezeli a jármű áthaladását az adott felszínen. A viselkedés a konkrét
     * állapottól függ.
     *
     * @param v Az áthaladó jármű
     * @param l A sáv, amelyiknek ez a felszíne
     * @return Igaz, ha átengedi a járművet (pl. CleanSurface), hamis ha
     * blokkolja (pl. BlockedSurface).
     */
    public abstract boolean handleVehicle(Vehicle v, Lane l);

    /**
     * A fej takarító hatását érvényesíti az adott állapotban.
     *
     * @param head A takarító fej
     * @param inv A hókotró inventory-ja
     * @param l A takarítandó sáv
     * @return Igaz, ha a takarítás elvégezhető volt.
     */
    public abstract boolean clean(PlowHead head, Inventory inv, Lane l);

    /**
     * Hó fogadását kezeli az adott állapotban (pl. a tiszta útra eső hó havas
     * felszínt csinál).
     *
     * @param amount A leeső hó mennyisége
     * @param l A sáv, ami a havat kapja
     */
    public abstract void receiveSnow(int amount, Lane l);
}
