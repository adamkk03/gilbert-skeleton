package org.skeleton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skeleton.map.Lane;
import org.skeleton.player.Player;
import org.skeleton.player.Snowplow;
import org.skeleton.surface.IcySurface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @BeforeEach
    void setUp() {
        Main.reset(); // Minden teszt előtt ürítjük a regisztereket
    }

    @Test
    void testNodeCreation() {
        Main.processCommand("node n1");
        assertNotNull(Main.nodes.get("n1"), "A csomópontnak létre kellene jönnie.");
    }

    @Test
    void testRoadAndLaneCreation() {
        Main.processCommand("node n1");
        Main.processCommand("node n2");
        Main.processCommand("road r1 n1 n2 2");

        assertNotNull(Main.roads.get("r1"), "Az út azonosítója hibás.");
        assertNotNull(Main.lanes.get("r1_l1"), "Az első sáv azonosítója hibás.");
        assertNotNull(Main.lanes.get("r1_l2"), "A második sáv azonosítója hibás.");
    }

    @Test
    void testSurfaceChange() {
        Main.processCommand("node n1");
        Main.processCommand("node n2");
        Main.processCommand("road r1 n1 n2 1");
        Main.processCommand("surface r1 l1 IcySurface");
        Lane l = Main.lanes.get("r1_l1");
        assertTrue(l.getSurface() instanceof IcySurface, "A felületnek IcySurface-nek kellene lennie.");
    }

    @Test
    void testSnowAddition() {
        Main.processCommand("node n1");
        Main.processCommand("node n2");
        Main.processCommand("road r1 n1 n2 1");
        Main.processCommand("snow r1 l1 15");

        Lane l = Main.lanes.get("r1_l1");
        assertEquals(15, l.getSnowThickness(), "A hóvastagságnak 15-nek kellene lennie.");
    }

    @Test
    void testEquipSnowplow() {
        Snowplow sp = new Snowplow();
        Main.snowplows.put("sp1", sp);

        Main.processCommand("equip sp1 salter");
        assertTrue(sp.getCurrentHead().toString().toLowerCase().contains("salter"));
    }

    @Test
    void testPlayerMoneyAndBuy() {
        Player p = new Player("P1");
        p.addMoney(2000);
        Main.players.put("p1", p);

        Snowplow sp = new Snowplow();
        Main.snowplows.put("sp1", sp);

        Main.processCommand("buy p1 head sp1 sweeper");

        assertEquals(1000, p.getMoney(), "A pénznek csökkennie kellett volna 1000-rel.");
        assertTrue(sp.getCurrentHead().toString().toLowerCase().contains("sweeper"));
    }

    @Test
    void testWeatherCommand() {
        Main.lanes.put("l1", new Lane());
        Main.lanes.put("l2", new Lane());

        Main.processCommand("weather 10");

        assertEquals(10, Main.lanes.get("l1").getSnowThickness());
        assertEquals(10, Main.lanes.get("l2").getSnowThickness());
    }

    @Test
    void testMoveVehicle() {
        Lane l1 = new Lane();
        Lane l2 = new Lane();
        Main.lanes.put("l1", l1);
        Main.lanes.put("l2", l2);

        Snowplow sp = new Snowplow();
        sp.setCurrentLane(l1);
        Main.vehicles.put("sp1", sp);

        Main.processCommand("move sp1 l2");

        assertEquals(l2, sp.getCurrentLane(), "A járműnek át kellett volna mozognia az l2 sávra.");
    }
}
