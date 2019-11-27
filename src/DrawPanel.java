import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    public static int CAR_WIDTH = 100;
    public static int CAR_HEIGHT = 60;

    // Just a single image, TODO: Generalize
    Map<String, String> imageMap = new HashMap<>();
    BufferedImage carImage;
    // To keep track of a singel cars position
    Point carPoint = new Point();
    List<Car> cars = new ArrayList<>();

    // TODO: Make this general for all cars
    void updatePosAndImg(int x, int y, Car car){
        carPoint.x = x;
        carPoint.y = y;
        String url = imageMap.get(car.getClass().toString());
        try{
            carImage = ImageIO.read(DrawPanel.class.getResourceAsStream(url));
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {

        imageMap.put(Volvo240.class.toString(), "pics/Volvo240.jpg");
        imageMap.put(Saab95.class.toString(), "pics/Saab95.jpg");
        imageMap.put(Scania.class.toString(), "pics/Scania.jpg");


        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block

            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.


    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(carImage, carPoint.x, carPoint.y, null); // see javadoc for more info on the parameters
    }
}
