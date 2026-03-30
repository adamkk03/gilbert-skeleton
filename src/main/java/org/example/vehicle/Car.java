package org.example.vehicle;

import org.example.Logger;
import org.example.map.Lane;
import org.example.map.Map;
import org.example.map.Node;

public class Car extends Vehicle {

    @Override
    public boolean move(Map map) {
        Logger.call("Car", "move(map)");

        // A 4. szekvencia diagram (Jégképződés) szerint lekéri a Map-től a következő sávot
        Lane currentLane = new Lane();
        Node dest1 = new Node();
        Lane targetLane = map.getNextLane(currentLane, dest1);

        // Rálép a kiválasztott sávra
        boolean success = false;
        if (targetLane != null) {
            success = targetLane.acceptVehicle(this);
        }

        Logger.ret("boolean", String.valueOf(success));
        return success;
    }
}
