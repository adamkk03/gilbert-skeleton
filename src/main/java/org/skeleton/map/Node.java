package org.skeleton.map;

import java.util.ArrayList;
import java.util.List;

import org.skeleton.Logger;
import org.skeleton.player.Snowplow;

/**
 * Egy kereszteződést reprezentál a térképen. Nyilvántartja a rácsatlakozó
 * utakat, illetve biztosítja a biztonságos pihenőhelyet a hókotrók számára,
 * hogy ne akadályozzák a forgalmat, amikor épp nem dolgoznak.
 */
public class Node {

    private List<Road> connectedRoads = new ArrayList<>();
    private List<Snowplow> restingSnowplows = new ArrayList<>();

    /**
     * Fogadja a csomópontra érkező hókotrót, és biztonságos pihenőhelyet
     * biztosít számára.
     *
     * @param s Az érkező hókotró
     */
    public void acceptSnowplow(Snowplow s) {
        Logger.call("Node", "acceptSnowplow(s)");
        if (s != null) {
            // Fogadott hókotró feldolgozása
        }
        Logger.retVoid();
    }
}
