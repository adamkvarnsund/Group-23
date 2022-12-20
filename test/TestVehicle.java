package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import Model.Direction;
import Model.*;

public class TestVehicle {

    Vehicle vehicle;

    @BeforeEach
    public void reset() {
        vehicle = new Volvo240();
    }

    @Test   
    public void testMove(){
        vehicle.setCurrentSpeed(5);
        vehicle.move();
        assertEquals(5, vehicle.getX());
    }

    @Test   
    public void gasShouldIncreaseSpeedOfVehicle() {          
        double goal = vehicle.getCurrentSpeed() + vehicle.speedFactor() * 1;
        vehicle.gas(1);
        assertEquals(goal, vehicle.getCurrentSpeed());
        assertThrows(IllegalArgumentException.class, () -> {vehicle.gas(20);});
        assertThrows(IllegalArgumentException.class, () -> {vehicle.gas(-4);});
    }
    
    @Test
    public void breakShouldDecreaseSpeedOfVehicle(){
        vehicle.setCurrentSpeed(5);
        double goal = vehicle.getCurrentSpeed() - vehicle.speedFactor() * 1;
        vehicle.brake(1);
        assertEquals(goal, vehicle.getCurrentSpeed());
        assertThrows(IllegalArgumentException.class, () -> {vehicle.gas(20);});
        assertThrows(IllegalArgumentException.class, () -> {vehicle.gas(-20);});
    }

        
}