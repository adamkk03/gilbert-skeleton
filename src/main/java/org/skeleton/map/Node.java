package org.skeleton.map;

import org.skeleton.player.Snowplow;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a junction or end-point in the map.
 * Connects multiple roads and can hold resting snowplows.
 */
public class Node {

    /** List of roads connected to this node. */
    private List<Road> roads;
    /** List of snowplows currently resting at this node. */
    private List<Snowplow> restingSnowplows;

    /**
     * Constructs a new empty Node.
     */
    public Node() {
        this.roads = new ArrayList<>();
        this.restingSnowplows = new ArrayList<>();
    }

    /**
     * Connects a road to this node.
     * @param r The road to add.
     */
    public void addRoad(Road r) {
        roads.add(r);
    }

    /**
     * Gets the list of roads connected to this node.
     * @return List of connected roads.
     */
    public List<Road> getNeighbors() {
        return roads;
    }

    /**
     * Accepts a snowplow into the node's resting area.
     * @param s The snowplow to accept.
     */
    public void acceptSnowplow(Snowplow s) {
        restingSnowplows.add(s);
        s.setCurrentNode(this);
    }
}
