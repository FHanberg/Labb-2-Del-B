package carview;

import carmodel.Saab95;
import carmodel.Scania;
import carmodel.Volvo240;

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

class DrawPanel extends JPanel{

    public static int CAR_WIDTH = 100;
    public static int CAR_HEIGHT = 60;

    private List<Point> positions;
    private List<String> imageDir;

    private Map<String, String> imageMap = new HashMap<>();

    public void updatePosAndImg(String carName, String carXPos, String carYPos){
        imageDir.add(imageMap.get(carName));
        positions.add(new Point(Integer.parseInt(carXPos), Integer.parseInt(carYPos)));
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
    }

    // This method is called each time the panel updates/refreshes/repaints itself

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
