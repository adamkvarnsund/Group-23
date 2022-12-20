package Model;

import java.util.*;

public class Loadable<T extends Car> {
    
    private final int CAPACITY;
    private final int MAXDISTANCE;
    private List<T> carsLoaded;

    public Loadable(int capacity, int maxDistanceBetweenStation) {
        CAPACITY = capacity;
        MAXDISTANCE = maxDistanceBetweenStation;
    }

    public List<T> getCarsLoaded() {
        return carsLoaded;
    }

    public int getAmount() {
        return carsLoaded.size();
    }

    public boolean containsCar(T car) {
        return carsLoaded.contains(car);
    }

    public void loadCar(T car) {
        if (carsLoaded.contains(car)) {throw new IllegalArgumentException("Car already loaded");}
        if (carsLoaded.size() >= CAPACITY) {throw new IllegalCallerException("Unable to load more cars!");}
        carsLoaded.add(car);
    }

    public void unloadCar(Car car) {
        if (!carsLoaded.contains(car)) {throw new IllegalArgumentException("Car not loaded");}
        carsLoaded.remove(car);
    }

    public void unloadCar() {
        carsLoaded.remove(carsLoaded.size()-1);
    }

    public int getCapacity() {
        return CAPACITY;
    }

    public int getMaxDistance() {
        return MAXDISTANCE;
    }
}
