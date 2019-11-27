import java.awt.*;

public abstract class Car extends MotorVehicle implements Transportable{

    private final int nrDoors;
    private boolean loaded = false;


    /**
     * @param nrDoors
     * @param enginePower
     * @param color
     * @param modelName
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, Size size){
        super(enginePower, color, modelName, size);
        this.nrDoors = nrDoors;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    @Override
    public double getX() {
        return super.getxPos();
    }

    @Override
    public double getY() {
       return super.getyPos();
    }

    public void setX(double xPos){
        if(loaded)
            this.xPos = xPos;
    }

    public void setY(double yPos){
        if(loaded)
            this.yPos = yPos;
    }

    void setDirection(double direction) {
        if(loaded)
            this.direction = direction;
    }

    void setSpeed(double speed){
        if(loaded)
            this.currentSpeed = speed;
    }


    public void loadSelf(){
        stopEngine();
        loaded = true;
    }

    public void unloadSelf(){
        loaded = false;
    }

    @Override
    public void followTransport(double speed, double direction) {
        setSpeed(speed);
        setDirection(direction);
        move();
    }
}
