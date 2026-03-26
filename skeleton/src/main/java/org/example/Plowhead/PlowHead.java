package org.example.Plowhead;

import org.example.Inventory;
import org.example.Map.Lane;

public abstract class PlowHead {
    public abstract void operate(Lane l, Inventory inv);
}