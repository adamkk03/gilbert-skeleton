package org.skeleton;

import java.util.ArrayList;
import java.util.List;

import org.skeleton.plowhead.PlowHead;
import org.skeleton.resource.Resource;

public class Inventory {

    private Resource salt;
    private Resource kerosene;
    private Resource gravel;
    private List<PlowHead> storedHeads;

    public Inventory() {
        this.storedHeads = new ArrayList<>();
    }

    public void addHead(PlowHead h) {
        storedHeads.add(h);
    }

    public void removeHead(PlowHead h) {
        storedHeads.remove(h);
    }

    public boolean consumeSalt() {
        if (salt != null && !salt.isEmpty()) {
            salt.consume();
            return true;
        }
        return false;
    }

    public boolean consumeKerosene() {
        if (kerosene != null && !kerosene.isEmpty()) {
            kerosene.consume();
            return true;
        }
        return false;
    }

    public boolean consumeGravel() {
        if (gravel != null && !gravel.isEmpty()) {
            gravel.consume();
            return true;
        }
        return false;
    }

    public void addResource(Resource type, int amount) {
        // Logika a megfelelő resource növelésére
    }
}
