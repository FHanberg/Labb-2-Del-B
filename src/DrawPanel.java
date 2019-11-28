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

    private List<Point> positions;
    private List<String> imageDir;

    // Just a single image, TODO: Generalize
    Map<String, String> imageMap = new HashMap<>();

    // TODO: Make this general for all cars
    void updatePosAndImg(int x, int y, String carClass){
        positions.add(new Point(x, y));
        imageDir.add(imageMap.get(carClass));
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {

        imageMap.put(Volvo240.class.toString(), "pics/Volvo240.jpg");
        imageMap.put(Saab95.class.toString(), "pics/Saab95.jpg");
        imageMap.put(Scania.class.toString(), "pics/Scania.jpg");

        positions = new ArrayList<>();
        imageDir = new ArrayList<>();

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
        for(int i = 0; i < imageDir.size(); i++){

            BufferedImage img = null;
            try {
                img = ImageIO.read(DrawPanel.class.getResourceAsStream(imageDir.get(i)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            g.drawImage(img, positions.get(i).x, positions.get(i).y, null); // see javadoc for more info on the parameters
        }
        positions.clear();
        imageDir.clear();
    }
}
