package carmodel;

import java.awt.*;

/**
 * En carmodel.Saab95
 */
public class Saab95 extends Car implements ITurbo{

    private boolean turboOn;

    /**
     * Use the constructor in car
     * turns off turbo and the engine
     */
    public Saab95(){
        super(2, 125, Color.red, "carmodel.Saab95", Size.MEDIUM);
	    turboOn = false;
    }

    public Saab95(double xPos, double yPos){
        super(2, 125, Color.red, "carmodel.Saab95", Size.MEDIUM, xPos, yPos);
        turboOn = false;
    }
    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Determines the acceleration factor
     * Is dependent on the turbo
     * @return acc factor
     */
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn)
            turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }



}
