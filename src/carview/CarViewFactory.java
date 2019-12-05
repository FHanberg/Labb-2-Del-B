package carview;

public class CarViewFactory {
    public ICarView createCarView(String frameName){
        return new CarView(frameName);
    }
}
