package org.example.surface;

import org.example.Inventory;
import org.example.Logger;
import org.example.Questioner;
import org.example.map.Lane;
import org.example.plowhead.PlowHead;
import org.example.vehicle.Vehicle;

/**
 * A sáv havas állapota. A járművek kerekei letapossák, ami idővel jéggé válhat.
 * Ha a hóréteg túl vastag lesz, a járművek elakadnak benne.
 */
public class SnowySurface extends Surface {

    /**
     * Kezeli a jármű áthaladását. Növeli a letaposást (ami jéggé válhat), vagy
     * elakasztja a járművet, ha túl vastag a hó.
     *
     * @param v Az áthaladó jármű
     * @param l Az aktuális sáv
     * @return Igaz, ha átjutott a jármű, hamis, ha elakadt a hóban.
     */
    @Override
    public boolean handleVehicle(Vehicle v, Lane l) {
        Logger.call("SnowySurface", "handleVehicle(v, l)");

        boolean stuck = Questioner.ask("Túl vastag a hó (elakad benne a jármű)?");

        if (stuck) {
            Logger.ret("boolean", "false");
            return false;
        } else {
            boolean becomesIcy = Questioner.ask("A letaposástól jéggé válik a felszín?");
            if (becomesIcy) {
                l.setSurface(new IcySurface());
            }
            Logger.ret("boolean", "true");
            return true;
        }
    }

    /**
     * A fej működése alapján eltünteti a havat.
     *
     * @param head A takarító fej
     * @param inv A hókotró inventory-ja
     * @param l A takarítandó sáv
     * @return Igaz, ha sikeres volt a takarítás.
     */
    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) {
        Logger.call("SnowySurface", "clean(head, inv, l)");
        head.operate(l, inv);
        Logger.ret("boolean", "true");
        return true;
    }

    /**
     * Hó fogadását kezeli. Növeli a hóvastagságot, egészen az elakadásig.
     *
     * @param amount A leeső hó mennyisége
     * @param l A sáv, ami a havat kapja
     */
    @Override
    public void receiveSnow(int amount, Lane l) {
        Logger.call("SnowySurface", "receiveSnow(" + amount + ", l)");
        Logger.retVoid();
    }
}
