package carview;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CarData extends JPanel {
    JLabel label;
    List<String> dataDisplay = new ArrayList<>();

    CarData(){
        label = new JLabel();
        this.add(label);
    }

    void updateText(String carName, String speed){
        dataDisplay.add(carName.replace("class carmodel.", "")+ ": " + speed + "u/t");
    }

    void displayText(){
        String fullString = "<html><body>";
        for (int i = 0; i < dataDisplay.size(); i++) {
            fullString = fullString + dataDisplay.get(i) + "<br>";
        }
        fullString = fullString + "</body></html>";
        label.setText(fullString);
        this.repaint();
        dataDisplay.clear();
    }
}
