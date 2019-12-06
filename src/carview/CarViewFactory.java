package carview;

import carcontroller.CarController;

public class CarViewFactory {
    public static ICarView createCarView(String frameName){
        return new CarView(frameName);
    }
}
