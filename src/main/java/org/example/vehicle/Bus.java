package org.example.vehicle;

import org.example.Logger;
import org.example.Questioner;
import org.example.map.Lane;
import org.example.map.Map;
import org.example.map.Node;

public class Bus extends Vehicle {

    @Override
    public boolean move(Map map) {
        Logger.call("Bus", "move(map)");

        // A 14. szekvencia diagram (Busz sikeres célba érése) alapján halad
        Lane currentLane = new Lane();
        Node dest1 = new Node();
        Lane targetLane = map.getNextLane(currentLane, dest1);

        boolean success = false;
        if (targetLane != null) {
            success = targetLane.acceptVehicle(this);
        }

        boolean arrived = Questioner.ask("A busz elérte a célállomást?");
        if (arrived) {
            // Itt a valóságban a Player kapna pontot, amit a szkeletonban 
            // majd a hívó oldalról (pl. Player.moveBus()) kezelünk le.
        }

        Logger.ret("boolean", String.valueOf(success));
        return success;
    }
}
