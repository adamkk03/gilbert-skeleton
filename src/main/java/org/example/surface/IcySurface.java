package org.example.surface;

import org.example.Inventory;
import org.example.Logger;
import org.example.map.Lane;
import org.example.plowhead.PlowHead;
import org.example.vehicle.Vehicle;

public class IcySurface extends Surface {

    @Override
    public boolean handleVehicle(Vehicle v, Lane l) {
        Logger.call("IcySurface", "handleVehicle(v, l)");
        // 8. SD és 5. SD: Jeges útra lépve az autó megcsúszik és balesetet szenved
        v.crash();
        l.setSurface(new BlockedSurface());
        Logger.ret("boolean", "true");
        return true;
    }

    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) {
        Logger.call("IcySurface", "clean(head, inv, l)");
        head.operate(l, inv);
        Logger.ret("boolean", "true");
        return true;
    }

    @Override
    public void receiveSnow(int amount, Lane l) {
        Logger.call("IcySurface", "receiveSnow(amount, l)");
        Logger.retVoid();
    }
}
