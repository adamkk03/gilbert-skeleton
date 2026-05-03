package org.skeleton;

import java.util.ArrayList;
import java.util.List;

import org.skeleton.plowhead.PlowHead;
import org.skeleton.resource.BioKerosene;
import org.skeleton.resource.Gravel;
import org.skeleton.resource.Resource;
import org.skeleton.resource.Salt;

public class Inventory {

    private Resource salt;
    private Resource kerosene;
    private Resource gravel;
    private List<PlowHead> storedHeads;

    public Inventory() {
        this.storedHeads = new ArrayList<>();
        this.salt = new Salt();
        this.kerosene = new BioKerosene();
        this.gravel = new Gravel();
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
        if (type != null) {
            type.fillInventory(this, amount);
        }
    }

    public void addSalt(int amount) {
        if (this.salt != null) {
            this.salt.addAmount(amount);
        }
    }

    public void addKerosene(int amount) {
        if (this.kerosene != null) {
            this.kerosene.addAmount(amount);
        }
    }

    public void addGravel(int amount) {
        if (this.gravel != null) {
            this.gravel.addAmount(amount);
        }
    }
}
