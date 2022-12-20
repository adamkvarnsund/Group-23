package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import Model.CarTransporter;
import Model.Saab95;
import Model.State;

public class TestCarTransporter {
    @Test
    public void demoTestMethod() {
        assertTrue(true);
    }    

    CarTransporter truck;
     
    @BeforeEach
    public void reset() {
        truck = new CarTransporter();
    }

    @Test
    public void testLowerRamp() {
        truck.getRamp().setState(State.UP);
        truck.lowerRamp();
        assertEquals(State.DOWN, truck.getRamp().getState());

    }

    @Test
    public void testLoadCar() {
        Saab95 car = new Saab95();
        truck.lowerRamp();
        truck.loadCar(car);
        assertEquals(1, truck.getLoadedCars().getAmount());
        truck.raiseRamp();
        truck.gas(0.7);
        // se om det blir error men idk how
    }

    @Test
    public void testUnloadCar() {
        Saab95 car = new Saab95();
        truck.lowerRamp();
        truck.loadCar(car);
        truck.unloadCar(car);
        assertEquals(0, truck.getLoadedCars().getAmount());
        // same as above ey din 
    }
}