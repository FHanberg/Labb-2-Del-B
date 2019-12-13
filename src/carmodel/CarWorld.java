package carmodel;

import Observers.IUpdateListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CarWorld implements ICarWorld {
    private ArrayList<Car> cars = new ArrayList<>();

    private int worldWidth;
    private int worldHeight;
    private int carWidth;
    private int carHeight;
    private List<IUpdateListener> updateListeners;

    public CarWorld(int startAmount, int worldWidth, int worldHeight, int carWidth, int carHeight,
                    List<IUpdateListener> updateListeners) {
        this.carWidth = carWidth;
        this.carHeight = carHeight;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;

        this.updateListeners = updateListeners;
        for (int i = 0; i < startAmount; i++) {
            addRandomCar();
        }
    }

    private boolean collidingWithWall(double rotation, double x, double y){
        if(rotation < 90 || rotation > 270){
            if(x + carWidth > worldWidth){
                return true;
            }
        }
        if(rotation < 180){
            if(y < 0){
                return true;
            }
        }
        if(rotation > 90 && rotation < 270){
            if(x < 0){
                return true;
            }
        }
        if(rotation > 180){
            return y + carHeight > worldHeight;
        }

        return false;
    }

    private void turnAroundProcedure(Car car){
        car.stopEngine();

        for (int i = 0; i <4 ; i++) {
            car.turnLeft();
        }
        car.startEngine();
    }

    @Override
    public void addRandomCar() {
        if(cars.size() >= 10){
            return;
        }
        int random = new Random().nextInt(3);
        String randomCar = "";
        switch (random){
            case 0:
                randomCar = "Volvo";
                break;
            case 1:
                randomCar = "Saab";
                break;
            case 2:
                randomCar = "Scania";
                break;
            default:
                System.out.println("This should not happen");
                break;
        }
        addCar(randomCar, 0, (carHeight + 10) * cars.size() + 10);

    }

    @Override
    public void removeCar() {
        if(cars.size() == 0){
            return;
        }
        cars.remove(cars.size() - 1);
    }

    private void addCar(String carClassName, double xPos, double yPos) {
        Car newCar = null;
        switch (carClassName) {
            case "Volvo":
                newCar = new Volvo240(xPos, yPos);
                break;
            case "Saab":
                newCar = new Saab95(xPos, yPos);
                break;
            case "Scania":
                newCar = new Scania(xPos, yPos);
                break;
            default:
                System.out.println("No such car available: " + carClassName);
                break;
        }
        if(newCar != null) cars.add(newCar);
    }

    @Override
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    @Override
    public void brake(int amount) {
        double brake = amount / 100.0;
        for(Car car : cars){
            car.brake(brake);
        }
    }

    @Override
    public void turboOn() {
        for(Car car : cars){
            if(car instanceof ITurbo){
                ((ITurbo) car).setTurboOn();
            }
        }
    }

    @Override
    public void turboOff() {
        for(Car car : cars){
            if(car instanceof ITurbo){
                ((ITurbo) car).setTurboOff();
            }
        }
    }

    @Override
    public void liftBeds() {
        for(Car car : cars){
            if(car instanceof Flatbed){
                ((Flatbed) car).raiseBed();
            }
        }
    }

    @Override
    public void lowerBeds() {
        for (Car car : cars){
            if(car instanceof Flatbed){
                ((Flatbed) car).lowerBed();
            }
        }
    }

    @Override
    public void startCars() {
        for(Car car : cars){
            car.startEngine();
        }
    }

    @Override
    public void stopCars() {
        for(Car car : cars){
            car.stopEngine();
        }
    }

    /**
     * getCars returns the data about the cars that is necessary for the view in form of a string array
     * @return a string with the car class first and then xpos and then ypos, and then the current speed
     */
    @Override
    public String[] getCars() {
        String[] returnArray = new String[cars.size()];
        for(int i = 0; i < cars.size(); i++){
            returnArray[i] = cars.get(i).getClass().toString() + "_" + (int)cars.get(i).getX() + "_" + (int)cars.get(i).getY()
            + "_" + (int)cars.get(i).getCurrentSpeed();
        }
        return returnArray;
    }

    @Override
    public void updatePositions() {
        for(Car car : cars){
            car.move();
            if(collidingWithWall(car.getDirection(), car.getX(), car.getY())){
                turnAroundProcedure(car);
            }
        }
    }

    @Override
    public void startUpdateMethod(int delay) {
        Timer timer = new Timer(delay, new TimerListener());
        timer.start();
    }

    private void callUpdates(){
        for(IUpdateListener listener : updateListeners){
            listener.update(getCars());
        }
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            updatePositions();
            callUpdates();
        }
    }

}
