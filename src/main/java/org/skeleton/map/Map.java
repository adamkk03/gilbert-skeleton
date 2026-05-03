package org.skeleton.map;

import org.skeleton.vehicle.Car;
import org.skeleton.vehicle.Vehicle;
import java.util.*;

public class Map {

    private List<Node> nodes;
    private List<Road> roads;
    private List<Car> cars;

    public Map() {
        this.nodes = new ArrayList<>();
        this.roads = new ArrayList<>();
        this.cars = new ArrayList<>();
    }

    public void addNode(Node n) {
        nodes.add(n);
    }

    public void addRoad(Road r) {
        roads.add(r);
    }

    public void addCar(Car c) {
        if (c != null) {
            cars.add(c);
        }
    }

    public void generate() {
        // Pályaleíró beolvasása és inicializálása
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Road> getRoads() {
        return roads;
    }

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
