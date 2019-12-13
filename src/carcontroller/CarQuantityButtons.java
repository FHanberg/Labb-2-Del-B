package carcontroller;

import carmodel.ICarWorld;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarQuantityButtons extends JPanel {
    private JButton removeCar = new JButton("Remove Car");
    private JButton addCar = new JButton("Add Car");

    private ICarWorld carWorld;
    private int width;

    public CarQuantityButtons(ICarWorld carWorld, int width){

        this.carWorld = carWorld;
        this.width = width;
        initComponents();
    }

    private void initComponents(){
        this.setPreferredSize(new Dimension(width, 200));
        this.setLayout(new GridLayout(2, 1));

        this.add(addCar, 0);
        this.add(removeCar, 1);

        {
            addCar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carWorld.addRandomCar();
                }
            });

            removeCar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    carWorld.removeCar();
                }
            });
        }
    }
}
