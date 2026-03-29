package org.example.vehicle;

import org.example.Logger;
import org.example.map.Lane;
import org.example.map.Map;
import org.example.map.Node;

public abstract class Vehicle {

    protected Lane currentLane;
    protected boolean isStuck = false;
    protected Node dest1;
    protected Node dest2;

    public abstract boolean move(Map map);

    public void free() {
        Logger.call("Vehicle", "free()");
        this.isStuck = false;
        Logger.retVoid();
    }

    public void crash() {
        Logger.call("Vehicle", "crash()");
        this.isStuck = true;
        Logger.retVoid();
    }

}
