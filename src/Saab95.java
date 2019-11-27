import java.awt.*;

/**
 * En Saab95
 */
public class Saab95 extends Car {

    private boolean turboOn;

    /**
     * Use the constructor in car
     * turns off turbo and the engine
     */
    public Saab95(){
        super(2, 125, Color.red, "Saab95", Size.MEDIUM);
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
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }



}
