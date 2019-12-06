package carcontroller;

import carmodel.*;
import carview.ICarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements IListener{
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    //private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    ICarView frame;
    ICarWorld carWorld;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();

    //methods:

    public CarController(ICarView carView, ICarWorld carWorld){
        frame = carView;
        this.carWorld = carWorld;
    }

    public void update(){
        carWorld.updatePositions();
        frame.updatePosAndImg(carWorld.getCars());
        frame.callForRepaint();
    }


    /*
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95(0, 100));
        cc.cars.add(new Scania(0, 200));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }
    */


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */





    // Calls the gas method for each car once
    public void gas(int amount) {
        carWorld.gas(amount);
    }

    public void brake(int amount){
        carWorld.brake(amount);
    }

    public void turboOn(){
       carWorld.turboOn();
    }

    public void turboOff(){
        carWorld.turboOff();
    }

    public void liftBeds(){
        carWorld.liftBeds();
    }

    public void lowerBeds(){
        carWorld.lowerBeds();
    }

    public void startCars(){
        carWorld.startCars();
    }

    public void stopCars(){
        carWorld.stopCars();
    }

    @Override
    public void listenForMethod(int methodNumber) {
        switch (methodNumber){
            case 0:
                gas(frame.getGasAmount());
                break;
            case 1:
                brake(frame.getGasAmount());
                break;
            case 2:
                turboOn();
                break;
            case 3:
                turboOff();
                break;
            case 4:
                liftBeds();
                break;
            case 5:
                lowerBeds();
                break;
            case 6:
                startCars();
                break;
            case 7:
                stopCars();
                break;
            default:
                System.out.println("This should never have happened");
                break;
        }
    }
}
