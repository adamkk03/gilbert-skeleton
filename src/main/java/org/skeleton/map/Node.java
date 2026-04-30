package org.skeleton.map;

import org.skeleton.player.Snowplow;
import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<Road> roads;
    private List<Snowplow> restingSnowplows;

    public Node() {
        this.roads = new ArrayList<>();
        this.restingSnowplows = new ArrayList<>();
    }

    public void addRoad(Road r) {
        roads.add(r);
    }

    public List<Road> getNeighbors() {
        return roads;
    }

    public void acceptSnowplow(Snowplow s) {
        restingSnowplows.add(s);
        s.setCurrentNode(this);
    }
}
