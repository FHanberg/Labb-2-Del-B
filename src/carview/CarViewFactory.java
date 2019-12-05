package carview;

import carcontroller.CarController;

public class CarViewFactory {
    public static ICarView createCarView(String frameName, CarController carController){
        return new CarView(frameName, carController);
    }
}
