package org.skeleton;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.skeleton.map.Lane;
import org.skeleton.player.Player;
import org.skeleton.player.Snowplow;
import org.skeleton.surface.IcySurface;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class MainTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        Main.reset();
        Main.setupMockData();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @ParameterizedTest(name = "FileTest: {0}")
    @MethodSource("provideTestFiles")
    void testWithResourceFiles(String testName, Path inputPath, Path outputPath) throws IOException {
        try (Stream<String> lines = Files.lines(inputPath)) {
            lines.forEach(line -> {
                if (!line.trim().isEmpty()) {
                    Main.processCommand(line.trim());
                }
            });
        }

        String actualOutput = outputStreamCaptor.toString().trim().replace("\r\n", "\n");

        if (Files.exists(outputPath)) {
            String expectedOutput = Files.readString(outputPath).trim().replace("\r\n", "\n");
            assertEquals(expectedOutput, actualOutput, "Hiba a(z) " + testName + " tesztnél!");
        }
    }

    static Stream<Arguments> provideTestFiles() throws IOException, URISyntaxException {
        URL resource = MainTest.class.getClassLoader().getResource(".");
        if (resource == null) {
            throw new IllegalStateException("Could not find the classpath root directory.");
        }

        Path resPath = Paths.get(resource.toURI());

        try (Stream<Path> stream = Files.list(resPath)) {
            List<Arguments> testCases = stream
                    .filter(p -> p.getFileName().toString().endsWith("_in.txt"))
                    .map(p -> {
                        String filename = p.getFileName().toString();
                        String name = filename.substring(0, filename.length() - 7);
                        return Arguments.of(name, p, p.resolveSibling(name + "_out.txt"));
                    })
                    .toList();

            if (testCases.isEmpty()) {
                throw new RuntimeException("No files matching '*_in.txt' found in resources!");
            }

            return testCases.stream();
        }
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
        assertEquals(IcySurface.class, l.getSurface().getClass(), "A felületnek IcySurface-nek kellene lennie.");
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

    @Test
    void testSaltAbsorbsSnow() {
        Main.processCommand("node n1");
        Main.processCommand("node n2");
        Main.processCommand("road r1 n1 n2 1");
        Main.processCommand("modifier r1 l1 salt");

        Lane l = Main.lanes.get("r1_l1");
        assertEquals(0, l.getSnowThickness());
        assertTrue(l.isSalted());

        Main.processCommand("snow r1 l1 1");
        assertEquals(0, l.getSnowThickness());
    }

    @Test
    void testGravelModifier() {
        Main.processCommand("node n1");
        Main.processCommand("node n2");
        Main.processCommand("road r1 n1 n2 1");
        Main.processCommand("modifier r1 l1 gravel");

        Lane l = Main.lanes.get("r1_l1");
        assertTrue(l.isGraveled());
    }

    @Test
    void testGravelDisappearsUnderSnow() {
        Main.processCommand("node n1");
        Main.processCommand("node n2");
        Main.processCommand("road r1 n1 n2 1");
        Main.processCommand("modifier r1 l1 gravel");

        Lane l = Main.lanes.get("r1_l1");
        assertTrue(l.isGraveled());

        Main.processCommand("snow r1 l1 6");
        assertFalse(l.isGraveled());
    }

    @Test
    void testBlockedSurfaceIgnoresSnow() {
        Main.processCommand("node n1");
        Main.processCommand("node n2");
        Main.processCommand("road r1 n1 n2 1");
        Main.processCommand("surface r1 l1 BlockedSurface");

        Lane l = Main.lanes.get("r1_l1");
        Main.processCommand("snow r1 l1 5");

        assertEquals(0, l.getSnowThickness());
    }

    @Test
    void testBlockedSurfaceNotAccessible() {
        Main.processCommand("node n1");
        Main.processCommand("node n2");
        Main.processCommand("road r1 n1 n2 1");
        Main.processCommand("surface r1 l1 BlockedSurface");

        Lane l = Main.lanes.get("r1_l1");
        assertFalse(l.isAccessible());

        org.skeleton.vehicle.Car c = new org.skeleton.vehicle.Car();
        assertFalse(l.acceptVehicle(c));
    }

    @Test
    void testPlayerSetMoney() {
        Player p = new Player("p1");
        Main.players.put("p1", p);

        Main.processCommand("set_money p1 500");
        assertEquals(500, p.getMoney());
    }

    @Test
    void testCleanSurfaceToSnowySurface() {
        Main.processCommand("node n1");
        Main.processCommand("node n2");
        Main.processCommand("road r1 n1 n2 1");

        Lane l = Main.lanes.get("r1_l1");
        assertEquals(org.skeleton.surface.CleanSurface.class, l.getSurface().getClass());

        Main.processCommand("snow r1 l1 2");
        assertEquals(org.skeleton.surface.SnowySurface.class, l.getSurface().getClass());
        assertEquals(2, l.getSnowThickness());
    }

    @Test
    void testSnowySurfaceToIcySurface() {
        Main.processCommand("node n1");
        Main.processCommand("node n2");
        Main.processCommand("road r1 n1 n2 1");
        Main.processCommand("snow r1 l1 1");

        Lane l = Main.lanes.get("r1_l1");
        assertEquals(org.skeleton.surface.SnowySurface.class, l.getSurface().getClass());

        org.skeleton.vehicle.Car c1 = new org.skeleton.vehicle.Car();
        org.skeleton.vehicle.Car c2 = new org.skeleton.vehicle.Car();
        org.skeleton.vehicle.Car c3 = new org.skeleton.vehicle.Car();

        l.acceptVehicle(c1);
        l.acceptVehicle(c2);
        l.acceptVehicle(c3);

        assertEquals(org.skeleton.surface.IcySurface.class, l.getSurface().getClass());
    }

    @Test
    void testIcySurfaceCrash() {
        Main.processCommand("node n1");
        Main.processCommand("node n2");
        Main.processCommand("road r1 n1 n2 1");
        Main.processCommand("surface r1 l1 IcySurface");

        Lane l = Main.lanes.get("r1_l1");
        org.skeleton.vehicle.Car c = new org.skeleton.vehicle.Car();
        l.acceptVehicle(c);

        assertTrue(c.isStuck());
        assertEquals(org.skeleton.surface.BlockedSurface.class, l.getSurface().getClass());
    }

    @Test
    void testIcySurfaceWithGravel() {
        Main.processCommand("node n1");
        Main.processCommand("node n2");
        Main.processCommand("road r1 n1 n2 1");
        Main.processCommand("surface r1 l1 IcySurface");
        Main.processCommand("modifier r1 l1 gravel");

        Lane l = Main.lanes.get("r1_l1");
        org.skeleton.vehicle.Car c = new org.skeleton.vehicle.Car();
        boolean accepted = l.acceptVehicle(c);

        assertTrue(accepted);
        assertFalse(c.isStuck());
        assertEquals(org.skeleton.surface.IcySurface.class, l.getSurface().getClass());
    }

    @Test
    void testPlayerCannotBuyWithoutMoney() {
        Player p = new Player("p1");
        Main.players.put("p1", p);

        Snowplow sp = new Snowplow();
        Main.snowplows.put("sp1", sp);
        sp.changeHead(new org.skeleton.plowhead.Sweeper());

        Main.processCommand("buy p1 head sp1 salter");

        assertEquals(org.skeleton.plowhead.Sweeper.class, sp.getCurrentHead().getClass());
        assertEquals(0, p.getMoney());
    }
}
