package test;

import static org.junit.jupiter.api.Assertions.*;
import Model.*;

import org.junit.jupiter.api.*;

public class TestCarRepairShop {
    @Test
    public void demoTestMethod() {
        assertTrue(true);
    }    

    CarRepairShop repairShop;
     
    @BeforeEach
    public void reset() {
        repairShop = new CarRepairShop(12);
    }

    @Test
    public void testNewCar() {
        Car car = new Saab95();
        repairShop.loadCar(car);
        assertEquals(1, repairShop.getLoadedCars().getAmount());
    }
}
