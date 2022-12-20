package Model;
import java.awt.Color;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.25;

    
    public Volvo240(){
        super(4, 250, Color.black, "Volvo240", "pics/Volvo240.jpg");
    }
    
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }



}