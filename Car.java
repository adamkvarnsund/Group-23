import java.awt.*;

abstract class Car implements Movable {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double x;
    private double y;
    private int direction = 1;


    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }

    public String getModelName() {
        return modelName;
    }

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed){
        this.currentSpeed = currentSpeed;
    }
    
    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }

    public abstract void incrementSpeed(double amount);

    public abstract void decrementSpeed(double amount);
    
    public abstract double speedFactor();


    public void move(){

        switch (direction){
            case 1: 
                x += currentSpeed;
            case 2: 
                y += currentSpeed;
            case 3: 
                x -= currentSpeed;
            case 4: 
                y -= currentSpeed;
        }

    }

    public void turnLeft(){
        
        if (direction == 1){
            direction = 4;
        }else {
            direction--;
        }

    }

    public void turnRight(){
        if (direction == 4){
            direction = 1;
        }else{
            direction++;
        }

    }





    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }
}
