package org.example.plowhead;

import org.example.Inventory;
import org.example.map.Lane;

public abstract class PlowHead {

    public abstract void operate(Lane l, Inventory inv);
}
