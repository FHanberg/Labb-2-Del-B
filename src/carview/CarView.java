package carview;

import Observers.IUpdateListener;


import javax.swing.*;

/**
 * This class represents a "central hub" for the view of the MVC pattern of your car simulator.
 * It initializes at the center of the screen.
 * It does not communicate outward, but does receive data from the model (in the form of Strings)
 **/

class CarView extends JPanel implements IUpdateListener, ICarView {
    private static final int WORLD_WIDTH = 800;
    private final int WORLD_HEIGHT = 800 - 240;

    private DrawPanel drawPanel = new DrawPanel(WORLD_WIDTH, WORLD_HEIGHT);
    private CarData carData = new CarData();


    // Constructor
    CarView() {
        this.add(carData);
        this.add(drawPanel);
    }

    @Override
    public JPanel getPanels() {
        return this;
    }

    @Override
    public int getCarHeight() {
        return DrawPanel.CAR_HEIGHT;
    }

    @Override
    public int getCarWidth() {
        return DrawPanel.CAR_WIDTH;
    }

    @Override
    public int getWorldWidth() {
        return WORLD_WIDTH;
    }

    @Override
    public int getWorldHeight() {
        return WORLD_HEIGHT;
    }

    @Override
    public void update(String[] data) {
        for(String dat : data){
            String[] splits = dat.split("_");
            drawPanel.updatePosAndImg(splits[0], splits[1], splits[2]);
            carData.updateText(splits[0], splits[3]);
        }
        drawPanel.repaint();
        carData.displayText();
    }
}
