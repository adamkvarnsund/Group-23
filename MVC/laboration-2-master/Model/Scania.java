package Model;
import java.awt.*;

public class Scania extends Truck {

    private MovablePlatform platform;

    public Scania(MovablePlatform platform){
        super(2, 500, Color.red, "Scania", "pics/Scania.jpg", platform);
    }

    public Scania() {
        this(new MovablePlatform());
    }

    public void raisePlatform() {
        platform.raisePlatform(1);
    }
    
    public void lowerPlatform() {
        platform.lowerPlatform(1);
    }

    public MovablePlatform getPlatform() {
        return platform;
    }
}