package org.example.vehicle;

import org.example.map.Lane;
import org.example.map.Map;
import org.example.map.Node;

public abstract class Vehicle {

    protected Lane currentLane;
    protected boolean isStuck;
    protected Node dest1;
    protected Node dest2;

    public abstract boolean move(Map map);

    public void free() {
    }

    public void crash() {
    }
}
