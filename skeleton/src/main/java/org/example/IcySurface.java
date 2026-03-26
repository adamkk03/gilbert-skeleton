package org.example;

class IcySurface extends Surface {
    @Override
    public boolean handleVehicle(Vehicle v, Lane l) { return true; }
    @Override
    public boolean clean(PlowHead head, Inventory inv, Lane l) { return false; }
    @Override
    public void receiveSnow(int amount, Lane l) {}
}