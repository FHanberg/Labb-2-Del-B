import java.awt.*;

/**
 * Abstract class for motor-powered vehicles
 */
public abstract class MotorVehicle implements Movable, Engine {
    final double enginePower;
    private Color color;
    double currentSpeed = 0;
    private final String modelName;
    double direction = 0;
    private final double rotationSpeed = 45;
    double xPos;
    double yPos;
    private final Size size;
    private boolean engineOn = false;

    public MotorVehicle(double enginePower, Color color, String modelName, Size size){
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.size = size;

        stopEngine();
    }

    public MotorVehicle(double enginePower, Color color, String modelName, Size size, double xPos, double yPos){
        this.xPos = xPos;
        this.yPos = yPos;

        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.size = size;

        stopEngine();
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

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * The angle of the car in degrees, where 0 deg is the same direction as the unit circle 0 deg
     * @return degrees
     */
    public double getDirection() {
        return direction;
    }

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }


    public Size getSize(){
        return size;
    }

    /**
     * Determines the acceleration factor for the car
     * @return
     */
    protected abstract double speedFactor();

    /**
     * Rotates left
     * Changes direction
     */
    public void turnLeft() {
        direction += rotationSpeed;
        if(360 < direction){
            direction -= 360;
        }
    }

    /**
     * Rotates right
     * Changes direction
     */
    public void turnRight(){
        direction -= rotationSpeed;
        if(direction < 0){
            direction += 360;
        }
    }

    /**
     * xPos and yPos is changed dependent on direction and speed
     */
    public void move() {
        xPos += currentSpeed * Math.cos(Math.toRadians(direction));
        yPos += currentSpeed * Math.sin(Math.toRadians(direction));
    }

    /**
     * Ignites engine, allowing vehicle to move
     */
    public void startEngine(){
        engineOn = true;
    }

    /**
     * Kills engine and stops the vehicle
     */
    public void stopEngine(){
        engineOn = false;
        currentSpeed = 0;
    }

    /**
     * Is dependent on speedFactor
     * @param amount how much gas is applied
     */
    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Is dependent on speedFactor?
     * @param amount how much brake is applied
     */
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    /**
     * Gas increases currentSpeed depending on the attribute
     * @param amount Value between 0 - 1, more makes for higher acceleration
     */
    public void gas(double amount){
        if(engineOn) {
            if (amount > 1) {
                System.out.println("Gas amount is more than 1");
                return;
            } else if (amount < 0) {
                System.out.println("Gas is less than 0");
                return;
            }
            incrementSpeed(amount);
        }
    }

    /**
     * Brake decreases currentSpeed depending on the attribute
     * @param amount Value between 0 - 1, more makes for greater retardation
     */

    void brake(double amount){
        if(amount > 1){
            System.out.println("Brake amount is more than 1");
            return;
        }else if(amount < 0){
            System.out.println("Brake is less than 0");
            return;
        }
        decrementSpeed(amount);
    }

}
