package carmodel;

public interface ICarWorld {
    void gas(int amount);
    void brake(int amount);
    void turboOn();
    void turboOff();
    void liftBeds();
    void lowerBeds();
    void startCars();
    void stopCars();
    String[] getCars();
    void updatePositions();
    void addRandomCar();
    void removeCar();
    void startUpdateMethod(int delay);
}
