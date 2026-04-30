package org.skeleton.vehicle;

import org.skeleton.map.Lane;
import org.skeleton.map.Map;
import org.skeleton.map.Node;

public class Car extends Vehicle {

    private Node home;
    private Node workplace;

    public void moveTowardsDestination(Map map) {
        if (this.isStuck()) {
            return;
        }
        Node currentNode = this.getCurrentNode();
        Lane nextLane = map.getShortestPath(currentNode, workplace);
        if (nextLane != null) {
            this.move(nextLane);
        }
    }

    public Node getWorkplace() {
        return workplace;
    }
}
