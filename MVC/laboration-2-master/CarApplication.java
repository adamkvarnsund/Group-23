import Model.*;
import controller.CarController;
import controller.Timekeeper;
import view.*;

import java.util.ArrayList;
import java.util.List;

public class CarApplication {
    public static void main(String[] args) {
        List<Vehicle> cars = new ArrayList<>();

        cars.add(new Volvo240());
        cars.add(new Saab95());
        cars.add(new Scania());

        int carIndex = 0;
        for (Vehicle car : cars){
            car.setY(carIndex*100);
            carIndex++;
        }

        CarController cc = new CarController(cars);

        Timekeeper timer = new Timekeeper();
        for (Vehicle car : cars) {timer.addObserver(car);}

        DrawPanel view = new DrawPanel(cars);
        timer.addObserver(view);

        new CarView("CarSim 1.0", cc, view);

        timer.start();        
    }
}
