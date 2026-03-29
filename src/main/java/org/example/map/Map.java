package org.example.map;

import java.util.ArrayList;
import java.util.List;

import org.example.Logger;
import org.example.vehicle.Vehicle;

public class Map {

    private List<Node> nodes = new ArrayList<>();
    private List<Road> roads = new ArrayList<>();
    private List<Vehicle> npcVehicles = new ArrayList<>();

    public void buildMap() {
        Logger.call("Map", "buildMap()");
        Logger.retVoid();
    }

    public void weatherTick() {
        Logger.call("Map", "weatherTick()");
        Logger.retVoid();
    }

    // EZ A METÓDUS HIÁNYZOTT
    public void moveNPCs() {
        Logger.call("Map", "moveNPCs()");
        // Itt iterálna végig az npcVehicles listán
        Logger.retVoid();
    }

    public Lane getNextLane(Lane current, Node destination) {
        Logger.call("Map", "getNextLane(current, destination)");
        Lane nextLane = new Lane();
        Logger.ret("Lane", "lane");
        return nextLane;
    }
}
