package carmodel;

import java.awt.*;

/**
 * A carmodel.Volvo240
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    /**
     * Use the constructor in car
     * Stops the engine
     */
    public Volvo240(){
        super(4, 100, Color.black, "carmodel.Volvo240", Size.MEDIUM);
    }

    public Volvo240(double xPos, double yPos){
        super(4, 100, Color.black, "carmodel.Volvo240", Size.MEDIUM, xPos, yPos);
    }

    /**
     * Determines acceleration factor based on trimFactor
     * @return acc factor
     */
    protected double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }
}
