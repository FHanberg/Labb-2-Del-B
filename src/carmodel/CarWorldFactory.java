package carmodel;

import Observers.IUpdateListener;

import java.util.List;

public class CarWorldFactory {
    public static ICarWorld createCarWorld(int startAmount, int worldWidth, int worldHeight,
                                           int carWidth, int carHeight, List<IUpdateListener> updateListeners) {
        return new CarWorld(startAmount, worldWidth, worldHeight, carWidth, carHeight, updateListeners);
    }
}
