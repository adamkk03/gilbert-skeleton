package org.example;

import org.example.plowhead.PlowHead;
import org.example.resource.BioKerosene;
import org.example.resource.Resource;
import org.example.resource.Salt;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<PlowHead> storedHeads = new ArrayList<>();
    private Salt salt = new Salt();
    private BioKerosene kerosene = new BioKerosene();
    
    public void addHead(PlowHead h) {
        Logger.call("Inventory", "addHead(h)");
        storedHeads.add(h);
        Logger.retVoid();
    }

    public void removeHead(PlowHead h) {
        Logger.call("Inventory", "removeHead(h)");
        storedHeads.remove(h);
        Logger.retVoid();
    }
    
    public boolean consumeSalt() {
        Logger.call("Inventory", "consumeSalt()");
        boolean hasSalt = Questioner.ask("Van még elegendő só a raktárban?");
        Logger.ret("boolean", String.valueOf(hasSalt));
        return hasSalt;
    }

    public boolean consumeKerosene() {
        Logger.call("Inventory", "consumeKerosene()");
        boolean hasKerosene = Questioner.ask("Van még elegendő kerozin a raktárban?");
        Logger.ret("boolean", String.valueOf(hasKerosene));
        return hasKerosene;
    }

    public void addResource(Resource type, int amount) {
        Logger.call("Inventory", "addResource(type, " + amount + ")");
        // Az erőforrás típusa alapján kezeljük
        Logger.retVoid();
    }
}