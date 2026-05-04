package org.skeleton.plowhead;

import org.skeleton.Inventory;
import org.skeleton.map.Lane;

/**
 * Base class for all plow heads that can be attached to a snowplow.
 * Each plow head has a specific way of cleaning or modifying a lane surface.
 */
public abstract class PlowHead {

    /**
     * Operates the plow head on a specific lane.
     * @param l The lane to operate on.
     * @param inv The inventory for potential resource consumption.
     */
    public abstract void operate(Lane l, Inventory inv);
}
