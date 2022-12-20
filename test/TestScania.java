package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import Model.*;

public class TestScania {
    @Test
    public void demoTestMethod() {
        assertTrue(true);
    }    

    Scania truck;
     
    @BeforeEach
    public void reset() {
        truck = new Scania();
    }

    @Test
    public void testRaisePlatform() {
        truck.raisePlatform();
        assertEquals(1, truck.getPlatform().getAngle());

        for (int i = 0; i < 10; i++) {truck.raisePlatform();}
        assertEquals(11, truck.getPlatform().getAngle());
    }

    @Test
    public void testLowerPlatform() {
        truck.getPlatform().setAngle(50);
        truck.lowerPlatform();
        assertEquals(49, truck.getPlatform().getAngle());

        for (int i = 0; i < 10; i++) {truck.lowerPlatform();}
        assertEquals(39, truck.getPlatform().getAngle());
    }
}
