package org.skeleton.map;

import java.util.ArrayList;
import java.util.List;

import org.skeleton.Logger;
import org.skeleton.Questioner;
import org.skeleton.vehicle.Vehicle;

/**
 * A város teljes úthálózatának nyilvántartója. Felelőssége, hogy összefogja az
 * utakat és csomópontokat, valamint a havazásról értesítse a lane-eket.
 */
public class Map {

    private List<Node> nodes = new ArrayList<>();
    private List<Road> roads = new ArrayList<>();
    private List<Vehicle> npcVehicles = new ArrayList<>();

    /**
     * Felépíti a város úthálózatát: legenerálja a Node-okat és a Road-okat,
     * valamint összeköti őket.
     */
    public void buildMap() {
        Logger.call("Map", "buildMap()");

        // Alap inicializálás: néhány csomópont és út létrehozása
        if (nodes.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                nodes.add(new Node());
            }
        }

        if (roads.isEmpty()) {
            for (int i = 0; i < 6; i++) {
                roads.add(new Road());
            }
        }

        Logger.retVoid();
    }

    /**
     * Ciklusban végigiterál a roads listán, és minden úton meghívja a
     * weatherTick() metódust.
     */
    public void weatherTick() {
        Logger.call("Map", "weatherTick()");

        if (Questioner.ask("Havazik éppen?")) {
            // Szimulálunk egy utat, hogy a lánc továbbmenjen és a havazás lekezelődjön
            Road dummyRoad = new Road();
            dummyRoad.weatherTick();
        }

        Logger.retVoid();
    }

    /**
     * Végigiterál a térképen tartózkodó NPC járműveken, és mindegyiknek
     * meghívja a move() metódusát.
     */
    public void moveNPCs() {
        Logger.call("Map", "moveNPCs()");
        Logger.retVoid();
    }

    /**
     * Kiszámolja a legrövidebb utat a jelenlegi sávtól a cél csomópontig, és
     * visszaadja azt a sávot, amelyre a járműnek a következő lépésben rá kell
     * lépnie.
     *
     * @param current A jelenlegi sáv, ahol a jármű tartózkodik
     * @param destination A célállomás (Node)
     * @return A következő sáv (Lane)
     */
    public Lane getNextLane(Lane current, Node destination) {
        Logger.call("Map", "getNextLane(current, destination)");
        Lane nextLane = new Lane();
        Logger.ret("Lane", "lane");
        return nextLane;
    }
}
