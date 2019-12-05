package carview;

import carcontroller.CarController;

public class CarViewFactory {
    public ICarView createCarView(String frameName, CarController cc){
        return new CarView(frameName, cc);
    }
}
