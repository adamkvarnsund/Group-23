package controller;

import java.util.List;
import java.awt.*;
import javax.swing.*;

import Model.Vehicle;

public class StopButton extends JButton{
    private final int X = Config.getWidth();

    public StopButton(List<Vehicle> cars) {
        super("Stop all cars");

        setBackground(Color.red);
        setForeground(Color.black);
        setPreferredSize(new Dimension(X/5-15,200));

        addActionListener(actionListener -> {
            for (Vehicle car : cars) {car.stopEngine();}
        });
    }
}
