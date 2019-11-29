import java.awt.*;

public class Scania extends Car implements Flatbed{

    private boolean turboOn = false;
    private double degreesOnFlatbed = 0;
    private final int maxAngle = 70;
    private final int angleInc = 10;

    /**
     * A truck with a flatbed
     */
    public Scania(){
        super(2, 350, Color.white, "LBS141", Size.BIG);
        stopEngine();
    }

    public Scania(double xPos, double yPos){
        super(2, 350, Color.white, "LBS141", Size.BIG, xPos, yPos);
        stopEngine();
    }
    public void turboOn(){
        turboOn = true;
    }

    public void turboOff(){
        turboOn = false;
    }


    /**
     * Depending on the turbo and engine power, changes the (acceleration) speed factor
     * If the flatbed is raised, returns zero (can't accelerate)
     * @return Factor on which the speed changes (acceleration factor)
     */
    @Override
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn)
            turbo = 1.3;
        return degreesOnFlatbed == 0 ? enginePower * 0.01 * turbo : 0;
    }

    /**
     * Lowers the degrees of the flatbed
     */
    @Override
    public void lowerBed() {
        if(degreesOnFlatbed >= angleInc){
            degreesOnFlatbed -= angleInc;
        }else if(degreesOnFlatbed >= 0){
            degreesOnFlatbed = 0;
        }
        System.out.println("Current bed angle: " + getDegreesOnFlatbed());
    }

    /**
     * Raises flatbed if stationary
     */
    @Override
    public void raiseBed() {
        if(currentSpeed == 0){
            if(degreesOnFlatbed <= maxAngle - angleInc){
                degreesOnFlatbed += angleInc;
            }else if(degreesOnFlatbed <= maxAngle){
                degreesOnFlatbed = maxAngle;
            }
        }
        System.out.println("Current bed angle: " + getDegreesOnFlatbed());
    }

    public double getDegreesOnFlatbed() {
        return degreesOnFlatbed;
    }
}
