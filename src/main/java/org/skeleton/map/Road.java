package org.skeleton.map;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a road connecting two nodes.
 * Contains multiple lanes and manages snow movement between them.
 */
public class Road {

    /** One end-point of the road. */
    private Node nodeA;
    /** The other end-point of the road. */
    private Node nodeB;
    /** List of lanes belonging to this road. */
    private List<Lane> lanes;

    /**
     * Constructs a new Road between two nodes.
     * @param a The first node.
     * @param b The second node.
     */
    public Road(Node a, Node b) {
        this.nodeA = a;
        this.nodeB = b;
        this.lanes = new ArrayList<>();
    }

    /**
     * Gets the list of lanes on this road.
     * @return List of lanes.
     */
    public List<Lane> getLanes() {
        return lanes;
    }

    /**
     * Gets the neighboring lane (next index) of a given lane.
     * @param l The reference lane.
     * @return The neighboring lane, or null if it's the last lane.
     */
    private Lane getNeighborOf(Lane l) {
        int index = lanes.indexOf(l);
        if (index >= 0 && index < lanes.size() - 1) {
            return lanes.get(index + 1);
        }
        return null;
    }

    /**
     * Checks if the road has at least one accessible lane.
     * @return true if any lane is accessible, false otherwise.
     */
    public boolean hasAccessibleLane() {
        for (Lane lane : lanes) {
            if (lane.isAccessible()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the node at the other end of the road relative to the given node.
     * @param n The reference node.
     * @return The other node, or null if the given node is not part of this road.
     */
    public Node getOtherEnd(Node n) {
        if (n.equals(nodeA)) {
            return nodeB;
        }
        if (n.equals(nodeB)) {
            return nodeA;
        }
        return null;
    }

    /**
     * Pushes snow from one lane to the neighboring lane.
     * @param from The source lane.
     * @param amount The amount of snow to push.
     */
    public void pushSnow(Lane from, int amount) {
        Lane neighborLane = this.getNeighborOf(from);
        if (neighborLane != null) {
            neighborLane.receiveSnow(amount);
        }
    }
}
