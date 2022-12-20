package Model;
import java.awt.*;

public abstract class Truck extends Vehicle {

    private Platform platform;

    public Truck(int nrDoors, double enginePower, Color color, String modelName, String pictureFile, Platform platform){
        super(nrDoors, enginePower, color, modelName, pictureFile);
        this.platform = platform;
    }

    @Override
    public void startEngine() {
        platform.lock();
        super.startEngine();
    }

    @Override
    public void stopEngine(){
        platform.unlock();
        super.stopEngine();
    }

    public void incrementSpeed(double amount){
        double newSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
	    if (newSpeed > getCurrentSpeed()) {setCurrentSpeed(newSpeed);}
    }
    public void decrementSpeed(double amount){
        double newSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if (newSpeed < getCurrentSpeed()) {setCurrentSpeed(newSpeed);}
    }

    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

    @Override
    public void gas(double amount) {
        platform.lock();
        super.gas(amount);
    }

    @Override   
    public void brake(double amount) {
        super.brake(amount);
        if (getCurrentSpeed() < 0.01) {
            platform.unlock();
        }
    }

}
