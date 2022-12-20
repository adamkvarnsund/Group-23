package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import Model.Direction;
import Model.Volvo240;

public class TestVolvo {

    @Test
    public void demoTestMethod() {
        assertTrue(true);
    }    

    Volvo240 car;
     
    @BeforeEach
    public void reset() {
        car = new Volvo240();
    }

    @Test
    public void testStartEngine() {
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed());
    }

    @Test
    public void testStopEngine() {
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    public void testTurnLeft() {
        car.setDirection(Direction.RIGHT);
        car.turnLeft();
        assertEquals(Direction.UP, car.getDirection());
        car.turnLeft();
        car.turnLeft();
        assertEquals(Direction.DOWN, car.getDirection());
    }

    @Test
    public void testTurnRight() {
        car.setDirection(Direction.RIGHT);
        car.turnRight();
        assertEquals(Direction.DOWN, car.getDirection());
        car.turnRight();
        car.turnRight();
        assertEquals(Direction.UP, car.getDirection());
    }
    
    @Test
    public void testValidGasInput() {
        // assertThrows(IllegalArgumentException.class, car.gas(20));
        // BEHÖVER FRÅGA TA
    }

}
