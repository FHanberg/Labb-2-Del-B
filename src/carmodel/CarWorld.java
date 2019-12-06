package carmodel;

import java.util.ArrayList;

public class CarWorld implements ICarWorld {
    ArrayList<Car> cars = new ArrayList<>();

    public CarWorld(String[] inputValues) {
        for(String s : inputValues){
            String[] splits = s.split(" ");
            try {
                addCar(splits[0], Double.parseDouble(splits[1]), Double.parseDouble(splits[2]));
            } catch (NumberFormatException e) {}
        }
    }

    void addCar(String carClassName, double xPos, double yPos) {
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

    @Override
    public String[] getCars() {
        String[] returnArray = new String[cars.size()];
        for(int i = 0; i < cars.size(); i++){
            returnArray[i] = cars.get(i).getClass().toString() + "_" + (int)cars.get(i).getX() + "_" + (int)cars.get(i).getY();
        }
        return returnArray;
    }

    @Override
    public void updatePositions() {
        for(Car car : cars){
            car.move();
        }
    }
}
