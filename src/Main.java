import carcontroller.CarController;
import carview.CarViewFactory;
import carview.ICarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private CarController carController;

    private final int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    private ICarView view;

    private static Main main;

    public static void main(String[] args) {
        main = new Main();
        main.carController = new CarController();
        //main.view = new CarView("WWOO", main.carController);
        main.view = CarViewFactory.createCarView("Car Simulator", main.carController);
        main.timer.start();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            main.carController.update();
            System.out.println("WOW");

            /*frame.drawPanel.repaint();
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                //TODO: Make so it doesn't overwrite the image
                frame.drawPanel.updatePosAndImg(x, y, car.getClass().toString());
                // repaint() calls the paintComponent method of the panel
                if(collidingWithWall(car.getDirection(), x, y)){
                    turnAroundProcedure(car);
                }
            }*/

        }

    }
}
