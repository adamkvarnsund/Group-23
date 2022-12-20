package controller;
import Model.Vehicle;

import java.util.List;
import java.awt.*;
import javax.swing.*;

public class ControlPanel extends JPanel{
    private final int WIDTH = Config.getWidth();
    private final int HEIGHT = Config.getHeight();

    public ControlPanel(List<Vehicle> cars, GasSpinner gasSpinner) {
        setLayout(new GridLayout(2, 4));
        JButton brakeButton = new JButton("Brake");
        JButton turboOnButton = new JButton("Saab Turbo on");
        JButton turboOffButton = new JButton("Saab Turbo off");
        JButton liftBedButton = new JButton("Scania Lift Bed");
        JButton lowerBedButton = new JButton("Lower Lift Bed");

        add(new GasButton(cars, gasSpinner), 0);
        add(turboOnButton, 1);
        add(liftBedButton, 2);
        add(brakeButton, 3);
        add(turboOffButton, 4);
        add(lowerBedButton, 5);

        setPreferredSize(new Dimension((WIDTH/2)+4, HEIGHT));
        setBackground(Color.CYAN);
    }
}
