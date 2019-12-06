package carmodel;

public class CarWorldFactory {
    public static ICarWorld createCarWorld(String[] inputValues, int worldWidth, int worldHeight,
                                           int carWidth, int carHeight) {
        return new CarWorld(inputValues, worldWidth, worldHeight, carWidth, carHeight);
    }
}
