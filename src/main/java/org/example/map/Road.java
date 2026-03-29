package org.example.map;

import java.util.ArrayList;
import java.util.List;

import org.example.Logger;

public class Road {

    private List<Lane> lanes = new ArrayList<>();

    public void weatherTick() {
        Logger.call("Road", "weatherTick()");
        // Az időjárás hatása propagálódik az összes sávra
        for (Lane lane : lanes) {
            if (lane != null) {
                lane.receiveSnow(1);
            }
        }
        Logger.retVoid();
    }

    public void pushSnow(Lane from, int amount, boolean pushRight) {
        Logger.call("Road", "pushSnow(from, " + amount + ", " + pushRight + ")");
        // A hó átmozgatása szomszédos sávra
        int fromIndex = lanes.indexOf(from);
        if (fromIndex >= 0) {
            int toIndex = pushRight ? fromIndex + 1 : fromIndex - 1;
            if (toIndex >= 0 && toIndex < lanes.size() && lanes.get(toIndex) != null) {
                lanes.get(toIndex).receiveSnow(amount);
            }
        }
        Logger.retVoid();
    }
}
