package org.example;

class SnowySurface extends Surface {
    @Override
    public boolean handleVehicle(Vehicle v, Lane l) { return true; }
    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) { return true; }
    @Override
    public void receiveSnow(int amount, Lane l) {}
}