package org.example;


abstract class Vehicle {
    protected Lane currentLane;
    protected boolean isStuck;
    protected Node dest1;
    protected Node dest2;

    public abstract boolean move(Map map);
    public void free() {}
    public void crash() {}
}