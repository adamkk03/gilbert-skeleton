package org.example.map;

import java.util.ArrayList;
import java.util.List;

import org.example.Inventory;
import org.example.Logger;
import org.example.plowhead.PlowHead;
import org.example.surface.CleanSurface;
import org.example.surface.Surface;
import org.example.vehicle.Vehicle;

/**
 * Az út egyetlen forgalmi sávja. Felelőssége a járművek befogadása és a fizikai
 * mennyiségek (hóvastagság, jég) tárolása. A tényleges eseményeket (megcsúszás,
 * letaposás) mindig az aktuális felszíni viszonyai alapján bírálja el.
 */
public class Lane {

    private Surface surface = new CleanSurface();
    private boolean isSalted = false;

    private int snowThickness;
    private int iceThickness;
    private List<Vehicle> vehicles = new ArrayList<>();

    /**
     * A takarítás logikáját az aktuális felszínre (Surface) delegálja. A
     * takarítás végeztével végigiterál a járműveken, és az elakadtakat
     * kiszabadítja.
     *
     * @param head A használt kotrófej
     * @param inv A hókotró raktára
     * @return Igaz, ha a takarítás sikeres volt.
     */
    public boolean clean(PlowHead head, Inventory inv) {
        Logger.call("Lane", "clean(head, inv)");
        boolean result = this.surface.clean(head, inv, this);
        Logger.ret("boolean", String.valueOf(result));
        return result;
    }

    /**
     * Fogadja a járművet, majd meghívja az aktuális felszín handleVehicle
     * metódusát.
     *
     * @param v Az áthaladó jármű
     * @return Igaz, ha a jármű sikeresen áthaladt.
     */
    public boolean acceptVehicle(Vehicle v) {
        Logger.call("Lane", "acceptVehicle(v)");
        boolean result = new CleanSurface().handleVehicle(v, this);
        Logger.ret("boolean", String.valueOf(result));
        return result;
    }

    /**
     * A havazás vagy áttolt hó fogadása a felszín felé történő delegálással.
     *
     * @param amount A kapott hó mennyisége
     */
    public void receiveSnow(int amount) {
        Logger.call("Lane", "receiveSnow(" + amount + ")");
        new CleanSurface().receiveSnow(amount, this);
        Logger.retVoid();
    }

    /**
     * Átállítja a sáv állapotát (pl. havasról jegesre).
     *
     * @param s Az új felszín állapota
     */
    public void setSurface(Surface s) {
        Logger.call("Lane", "setSurface(s)");
        Logger.retVoid();
    }

    /**
     * Sózott állapot beállítása a sávon.
     *
     * @param salted Sózott-e az út
     */
    public void setSalted(boolean salted) {
        Logger.call("Lane", "setSalted(" + salted + ")");
        Logger.retVoid();
    }

    /**
     * A sózás logikájához és az időjárás effektek körönkénti frissítéséhez
     * szükséges metódus.
     */
    public void weatherTick() {
        Logger.call("Lane", "weatherTick()");
        Logger.retVoid();
    }

    /**
     * Végigiterál a Lane saját vehicles listáján, és minden rajta lévő járművön
     * meghívja a crash() metódust baleset esetén.
     */
    public void propagateCrash() {
        Logger.call("Lane", "propagateCrash()");
        Logger.retVoid();
    }
}
