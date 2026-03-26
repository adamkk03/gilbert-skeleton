package org.example;

import java.util.ArrayList;
import java.util.List;

class Inventory {
    private List<PlowHead> storedHeads = new ArrayList<>();
    private Salt salt;
    private BioKerosene kerosene;

    public void addHead(PlowHead h) {}
    public void removeHead(PlowHead h) {}
    public boolean consumeSalt() { return false; }
    public boolean consumeKerosene() { return false; }
    public void addResource(Resource type, int amount) {}
}