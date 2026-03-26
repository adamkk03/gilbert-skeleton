package org.example;

import java.util.ArrayList;
import java.util.List;

class Road {
    private List<Lane> lanes = new ArrayList<>();

    public void weatherTick() {}
    public void pushSnow(Lane from, int amount, boolean pushRight) {}
}