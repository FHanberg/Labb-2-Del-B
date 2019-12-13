package carview;


public class CarViewFactory {
    public static ICarView createCarView(){
        return new CarView();
    }
}
