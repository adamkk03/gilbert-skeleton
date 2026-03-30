package org.example.map;

import java.util.ArrayList;
import java.util.List;

import org.example.Logger;

public class Road {

    private List<Lane> lanes = new ArrayList<>();

    public void weatherTick() {
        Logger.call("Road", "weatherTick()");
        // Az időjárás hatása propagálódik az összes sávra
        Lane lane = new Lane();
        lane.receiveSnow(1);
        Logger.retVoid();
    }

    public void pushSnow(Lane from, int amount, boolean pushRight) {
        Logger.call("Road", "pushSnow(from, " + amount + ", " + pushRight + ")");
        // A hó átmozgatása szomszédos sávra
        Lane toLane = new Lane();
        toLane.receiveSnow(amount);
        Logger.retVoid();
    }
}
