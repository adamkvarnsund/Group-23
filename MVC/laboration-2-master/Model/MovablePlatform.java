package Model;

import static java.lang.Math.abs;

public class MovablePlatform implements Platform{
    private double angle = 0;
    private boolean locked = false;
    private final double[] angleLimits = {0, 70};

    public void raisePlatform(double degree) {
        if (locked) {throw new IllegalCallerException("Unable to raise platform while car is moving");}
        setAngle(getAngle()+abs(degree));
    }
    
    public void raisePlatform(int degree) {
        raisePlatform((double)abs(degree));
    }

    public void lowerPlatform(double degree) {
        if (locked) {throw new IllegalCallerException("Unable to lower platform while car is moving");}
        setAngle(getAngle()-abs(degree));
    }

    public void lowerPlatform(int degree) {
        lowerPlatform((double)abs(degree));
    }

    public void lock() {
        if (angle != 0) {throw new IllegalCallerException("Can not lock platform while ramp is down");}
        locked = true;
    }

    public void unlock() {
        locked = false;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        if (angleLimits[0] <= angle && angle < angleLimits[1]) {this.angle = angle;}        
    }
}
