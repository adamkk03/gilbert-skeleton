package org.example.map;

import java.util.ArrayList;
import java.util.List;

import org.example.Logger;
import org.example.player.Snowplow;

public class Node {

    private List<Road> connectedRoads = new ArrayList<>();
    private List<Snowplow> restingSnowplows = new ArrayList<>();

    public void acceptSnowplow(Snowplow s) {
        Logger.call("Node", "acceptSnowplow(s)");
        // A 13. SD (Hókotró megérkezése a kereszteződésbe) alapján fogadja a hókotrót
        if (s != null) {
            restingSnowplows.add(s);
        }
        Logger.retVoid();
    }
}
