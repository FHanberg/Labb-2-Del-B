package carview;

import Observers.IUpdateListener;
import carmodel.ICarWorld;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 **/

class CarView extends JPanel implements IUpdateListener, ICarView {
    private static final int X = 800;
    private static final int Y = 800;

    public DrawPanel drawPanel = new DrawPanel(X, Y - 240);
    CarData carData = new CarData();


    // Constructor
    public CarView(String frameName) {
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
        return drawPanel.getWidth();
    }

    @Override
    public int getWorldHeight() {
        return drawPanel.getHeight();
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
