package Model;

import java.awt.*;

public class CarTransporter extends Truck {

    private Loadable<Car> loadedCars;
    private Ramp ramp;

    public CarTransporter(Ramp ramp) {
        super(2, 700, Color.gray, "Car Transporter", "fileDoesNotExist", ramp);
        loadedCars = new Loadable<Car>(7, 5);
    }

    public CarTransporter() {
        this(new Ramp());
    }

    public void raiseRamp() {
        ramp.lowerRamp();
    }
   
    public void lowerRamp() {
        ramp.raiseRamp();
    }
    
    public void loadCar(Car car) {
        if (ramp.getState() != State.DOWN) {throw new IllegalCallerException("Ramp must be down to load cars");}
        if (calculateDistance(car.getX(), car.getY()) > loadedCars.getMaxDistance()) {throw new IllegalCallerException("Car too far from transporter!");}
        loadedCars.loadCar(car);
    }
    

    public void unloadCar(Car car) {
        if (ramp.getState() != State.DOWN) {throw new IllegalCallerException("Ramp must be down to unload cars");}
        loadedCars.unloadCar(car);
        car.setX(car.getX()+loadedCars.getMaxDistance());
        car.setY(car.getY()+loadedCars.getMaxDistance());
    }

    @Override
    public void gas(double amount) {
        super.gas(amount);
    }

    public Ramp getRamp() {
        return ramp;
    }

    public Loadable<Car> getLoadedCars() {
        return loadedCars;
    }
}
