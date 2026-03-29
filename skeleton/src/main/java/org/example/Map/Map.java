package org.example.map;

import java.util.ArrayList;
import java.util.List;

import org.example.vehicle.Vehicle;

public class Map {

    private List<Node> nodes = new ArrayList<>();
    private List<Road> roads = new ArrayList<>();
    private List<Vehicle> npcVehicles = new ArrayList<>();

    public void buildMap() {
    }

    public void weatherTick() {
    }

    public void moveNPCs() {
    }

    public Lane getNextLane(Lane current, Node destination) {
        return null;
    }
}
