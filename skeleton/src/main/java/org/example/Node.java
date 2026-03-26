package org.example;

import java.util.ArrayList;
import java.util.List;

class Node {
    private List<Road> connectedRoads = new ArrayList<>();
    private List<Snowplow> restingSnowplows = new ArrayList<>();

    public void acceptSnowplow(Snowplow s) {}
}