package carmodel;

import Observers.IUpdateListener;

import java.util.List;

public class CarWorldFactory {
    public static ICarWorld createCarWorld(String[] inputValues, int worldWidth, int worldHeight,
                                           int carWidth, int carHeight, List<IUpdateListener> updateListeners) {
        return new CarWorld(inputValues, worldWidth, worldHeight, carWidth, carHeight, updateListeners);
    }
}
