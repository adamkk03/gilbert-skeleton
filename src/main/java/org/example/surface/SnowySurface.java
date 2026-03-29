package org.example.surface;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;
import org.example.plowhead.PlowHead;
import org.example.vehicle.Vehicle;

public class SnowySurface extends Surface {

    @Override
    public boolean handleVehicle(Vehicle v, Lane l) {
        Logger.call("SnowySurface", "handleVehicle(v, l)");

        // Elágazás a 6. és 7. Szekvencia diagram alapján
        boolean stuck = Logger.ask("Túl vastag a hó (elakad benne a jármű)?");

        if (stuck) {
            // 7. SD: Autó elakad a hóban
            Logger.ret("boolean", "false");
            return false;
        } else {
            // 6. SD: Autó letapossa a havat
            boolean turnsToIce = Logger.ask("A letaposástól a sáv jéggé változik?");
            if (turnsToIce) {
                l.setSurface(new IcySurface());
            }
            Logger.ret("boolean", "true");
            return true;
        }
    }

    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) {
        Logger.call("SnowySurface", "clean(head, inv, l)");
        // Delegáljuk a takarítást magának a fejnek
        head.operate(l, inv);
        Logger.ret("boolean", "true");
        return true;
    }

    @Override
    public void receiveSnow(int amount, Lane l) {
        Logger.call("SnowySurface", "receiveSnow(amount, l)");
        // Növeli a hóvastagságot (szkeletonban elég csak logolni)
        Logger.retVoid();
    }
}
