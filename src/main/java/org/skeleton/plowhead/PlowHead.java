package org.skeleton.plowhead;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;

public abstract class PlowHead {

    public abstract void operate(Lane l, Inventory inv);
}
