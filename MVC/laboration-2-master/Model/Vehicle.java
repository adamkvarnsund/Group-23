package Model;
import java.awt.*;
import controller.Observer;

public abstract class Vehicle implements Movable, Observer {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private String pictureFile;
    private double posx, posy;
    private Direction direction;

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, String pictureFile) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.pictureFile = pictureFile;
        this.direction = Direction.RIGHT;
        this.posx = 0;
        this.posy = 0;
        this.currentSpeed = 0;
    }



    public void stopEngine(){
	    currentSpeed = 0;
    }

    public void move() {

        switch(direction) {
            case UP: posy += currentSpeed; break;
            case LEFT: posx -= currentSpeed; break;
            case DOWN: posy -= currentSpeed; break;
            case RIGHT: posx += currentSpeed; break;
        }
    }

    public void turnLeft() {
        int index = (direction.ordinal() + 3) % 4;
        direction = Direction.values()[index];
    }

    public void turnRight() {
        int index = (direction.ordinal() + 1) % 4;
        direction = Direction.values()[index];
    }

    public abstract double speedFactor();

    /*
     * Takes a double amount between [0, 1]
     * Throws IllegalArgumentException if amount < 0 or amount > 1
     * Otherwise increments speed
     */
    public void gas(double amount) {
        if (amount < 0 || amount > 1) {throw new IllegalArgumentException("Gas only accepts values between [0, 1]");}
        incrementSpeed(amount);
    }

    /*
     * Takes a double amount between [0, 1]
     * Throws IllegalArgumentException if amount < 0 or amount > 1
     * Otherwise decrements speed
     */
    public void brake(double amount) {
        if (amount < 0 || amount > 1) {throw new IllegalArgumentException("Brake only accepts values between [0, 1]");}
        decrementSpeed(amount);
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }

    public double calculateDistance(double x, double y){
        double distance = Math.sqrt(Math.pow((posx-x), 2)+Math.pow((posy-y), 2));
        return distance;
    }

    public void incrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (newSpeed > getCurrentSpeed()) {setCurrentSpeed(newSpeed);}
    }

    public void decrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (newSpeed < getCurrentSpeed()) {setCurrentSpeed(newSpeed);}
    }

    @Override
    public void update(){
     move();
    }
    
    //? -----GETTEEEERS AND SETTEEEERS----- */
    

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public String getPictureFile() {
        return pictureFile;
    }

    public double getX() {
        return posx;
    }

    public double getY() {
        return posy;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getModelname() {
        return modelName;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCurrentSpeed(double speed) {
        if (0 <= speed && speed <= enginePower) {
            currentSpeed = speed;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setX(double x) {
        posx = x;
    }

    public void setY(double y) {
        posy = y;
    }
}
