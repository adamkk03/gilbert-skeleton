package org.skeleton.map;

import java.util.ArrayList;
import java.util.List;

public class Road {

    private Node nodeA;
    private Node nodeB;
    private List<Lane> lanes;

    public Road(Node a, Node b) {
        this.nodeA = a;
        this.nodeB = b;
        this.lanes = new ArrayList<>();
    }

    public List<Lane> getLanes() {
        return lanes;
    }

    private Lane getNeighborOf(Lane l) {
        int index = lanes.indexOf(l);
        if (index >= 0 && index < lanes.size() - 1) {
            return lanes.get(index + 1);
        }
        return null;
    }

    public boolean hasAccessibleLane() {
        for (Lane lane : lanes) {
            // A BlockedSurface lekérdezésének egyszerűsítése (mivel a hasAccessibleLane metódus true-t vár, ha járható)
            if (lane.isAccessible()) {
                return true;
            }
        }
        return false;
    }

    public Node getOtherEnd(Node n) {
        if (n.equals(nodeA)) {
            return nodeB;
        }
        if (n.equals(nodeB)) {
            return nodeA;
        }
        return null;
    }

    public void pushSnow(Lane from, int amount) {
        Lane neighborLane = this.getNeighborOf(from);
        if (neighborLane != null) {
            neighborLane.receiveSnow(amount);
        }
    }
}
