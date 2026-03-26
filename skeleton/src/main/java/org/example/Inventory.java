package org.example;

import org.example.Plowhead.PlowHead;
import org.example.Resource.BioKerosene;
import org.example.Resource.Resource;
import org.example.Resource.Salt;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<PlowHead> storedHeads = new ArrayList<>();
    private Salt salt;
    private BioKerosene kerosene;

    public void addHead(PlowHead h) {}
    public void removeHead(PlowHead h) {}
    public boolean consumeSalt() { return false; }
    public boolean consumeKerosene() { return false; }
    public void addResource(Resource type, int amount) {}
}