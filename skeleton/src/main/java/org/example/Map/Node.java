package org.example.map;

import org.example.Snowplow;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private List<Road> connectedRoads = new ArrayList<>();
    private List<Snowplow> restingSnowplows = new ArrayList<>();

    public void acceptSnowplow(Snowplow s) {
    }
}
