package carmodel;

public class CarWorldFactory {
    public static ICarWorld createCarWorld(String[] inputValues) {
        return new CarWorld(inputValues);
    }
}
