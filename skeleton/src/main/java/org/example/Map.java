package org.example;

import java.util.ArrayList;
import java.util.List;

class Map {
    private List<Node> nodes = new ArrayList<>();
    private List<Road> roads = new ArrayList<>();
    private List<Vehicle> npcVehicles = new ArrayList<>();

    public void buildMap() {}
    public void weatherTick() {}
    public void moveNPCs() {}
    public Lane getNextLane(Lane current, Node destination) { return null; }
}