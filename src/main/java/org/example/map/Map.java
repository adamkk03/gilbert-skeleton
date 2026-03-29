package org.example.map;

import org.example.Logger;

public class Map {

    public void weatherTick() {
        Logger.call("Map", "weatherTick()");

        // 9. SD: Havazás esetén a térkép értesíti a sávokat
        boolean isSnowing = Logger.ask("Havazik éppen?");
        if (isSnowing) {
            Lane dummyLane = new Lane(); // Szimulálunk egy sávot
            dummyLane.receiveSnow(1);
        }

        // 10. SD: Só elolvasztja a jeget
        boolean isFreezing = Logger.ask("Fagypont alá csökkent a hőmérséklet?");
        if (isFreezing) {
            boolean wasSalted = Logger.ask("Volt besózott sáv a térképen?");
            if (wasSalted) {
                // A sózott sáv feloldódik
                Logger.call("Lane (salted)", "setSurface(CleanSurface)");
                Logger.retVoid();
            }
        }

        Logger.retVoid();
    }

    public Lane getNextLane(Lane current, Node dest) {
        Logger.call("Map", "getNextLane(current, dest)");
        // A szkeletonban nem keresünk gráfban, csak visszaadunk egy új sávot
        Lane nextLane = new Lane();
        Logger.ret("Lane", "nextLane");
        return nextLane;
    }
}
