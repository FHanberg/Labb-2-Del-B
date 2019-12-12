import Observers.IUpdateListener;
import carcontroller.CarController;
import carmodel.CarWorldFactory;
import carmodel.ICarWorld;
import carview.CarViewFactory;
import carview.ICarView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

    private static final String NAME = "CarWorld";
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 800;

    private CarController carController;

    private ICarView view;
    private ICarWorld carWorld;

    private static Main main;

    public static void main(String[] args) {
        main = new Main();
        //main.view = new CarView("WWOO", main.carController);
        main.view = CarViewFactory.createCarView("Car Simulator");

        List<IUpdateListener> updateListeners= new ArrayList<>();
        updateListeners.add((IUpdateListener) main.view);

        main.carWorld = CarWorldFactory.createCarWorld(new String[]{"Saab_10_30", "Volvo_0_100", "Scania_0_300"},
                main.view.getWorldWidth(), main.view.getWorldHeight(),
                main.view.getCarWidth(), main.view.getCarHeight(), updateListeners);
        main.carController = new CarController(main.carWorld, SCREEN_WIDTH);

        main.setTitle(NAME);
        main.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        main.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        main.add(main.view.getPanels());
        main.add(main.carController);

        main.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        main.setLocation(dim.width/2-main.getSize().width/2, dim.height/2-main.getSize().height/2);
        // Make the frame visible
        main.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.carWorld.startUpdateMethod(50);
    }
}
