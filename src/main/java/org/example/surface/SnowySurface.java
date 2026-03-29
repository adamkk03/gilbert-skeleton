package org.example.surface;

import org.example.Inventory;
import org.example.Logger;
import org.example.Questioner;
import org.example.map.Lane;
import org.example.plowhead.PlowHead;
import org.example.vehicle.Vehicle;

public class SnowySurface extends Surface {

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

    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) {
        Logger.call("SnowySurface", "clean(head, inv, l)");
        Logger.ret("boolean", "true");
        return true;
    }

    @Override
    public void receiveSnow(int amount, Lane l) {
        Logger.call("SnowySurface", "receiveSnow(" + amount + ", l)");
        Logger.retVoid();
    }
}
