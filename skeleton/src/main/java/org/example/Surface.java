package org.example;

abstract class Surface {
    public abstract boolean handleVehicle(Vehicle v, Lane l);
    public abstract boolean clean(PlowHead head, Inventory inv, Lane l);
    public abstract void receiveSnow(int amount, Lane l);
}