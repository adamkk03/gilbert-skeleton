package org.skeleton.map;

import org.skeleton.vehicle.Car;
import org.skeleton.vehicle.Vehicle;
import java.util.*;

/**
 * Represents the game map containing nodes, roads, and cars.
 * Handles pathfinding and map generation.
 */
public class Map {

    /** List of nodes in the map. */
    private List<Node> nodes;
    /** List of roads connecting the nodes. */
    private List<Road> roads;
    /** List of non-player controlled cars currently on the map. */
    private List<Car> cars;

    /**
     * Constructs a new empty Map.
     */
    public Map() {
        this.nodes = new ArrayList<>();
        this.roads = new ArrayList<>();
        this.cars = new ArrayList<>();
    }

    /**
     * Adds a node to the map.
     * @param n The node to add.
     */
    public void addNode(Node n) {
        nodes.add(n);
    }

    /**
     * Adds a road to the map.
     * @param r The road to add.
     */
    public void addRoad(Road r) {
        roads.add(r);
    }

    /**
     * Adds a car to the map.
     * @param c The car to add.
     */
    public void addCar(Car c) {
        if (c != null) {
            cars.add(c);
        }
    }

    /**
     * Generates the map layout (e.g., by reading from a file).
     */
    public void generate() {
        // Initialization of map layout
    }

    /**
     * Gets the list of cars on the map.
     * @return List of cars.
     */
    public List<Car> getCars() {
        return this.cars;
    }

    /**
     * Gets the list of roads in the map.
     * @return List of roads.
     */
    public List<Road> getRoads() {
        return roads;
    }

    /**
     * Finds the first lane of the first road on the shortest path between two nodes.
     * Uses Breadth-First Search (BFS).
     * @param start The starting node.
     * @param dest The destination node.
     * @return The next lane to take, or null if no path is found.
     */
    public Lane getShortestPath(Node start, Node dest) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        java.util.Map<Node, Road> cameFrom = new HashMap<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.equals(dest)) {
                Road lastRoad = null;
                while (cameFrom.containsKey(current) && !current.equals(start)) {
                    lastRoad = cameFrom.get(current);
                    current = lastRoad.getOtherEnd(current);
                }
                return lastRoad != null && !lastRoad.getLanes().isEmpty() ? lastRoad.getLanes().get(0) : null;
            }

            for (Road road : current.getNeighbors()) {
                Node neighbor = road.getOtherEnd(current);
                if (neighbor != null && !visited.contains(neighbor) && road.hasAccessibleLane()) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    cameFrom.put(neighbor, road);
                }
            }
        }
        return null;
    }
}
