package Model;
import java.awt.*;

public abstract class Car extends Vehicle {
    public Car(int nrDoors, double enginePower, Color color, String modelName, String pictureFile){
        super(nrDoors, enginePower, color, modelName, pictureFile);
    }

}