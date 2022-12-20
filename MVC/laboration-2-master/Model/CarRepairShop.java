package Model;

public class CarRepairShop {

    private Loadable<Car> loadedCars;

    public CarRepairShop(int capacity)  {
        loadedCars = new Loadable<Car>(12, 5);
    }

    public void loadCar(Car car) {
        loadedCars.loadCar(car);
    }

    public void unloadCar() {
        loadedCars.unloadCar();
    }

    public Loadable<Car> getLoadedCars() {
        return loadedCars;
    }
}
