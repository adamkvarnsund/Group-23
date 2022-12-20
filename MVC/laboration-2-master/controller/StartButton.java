package controller;

import java.util.List;
import java.awt.*;
import javax.swing.*;

import Model.Vehicle;

public class StartButton extends JButton{
    private final int X = Config.getWidth();

    public StartButton(List<Vehicle> cars) {
        super("Start all cars");

        setBackground(Color.blue);
        setForeground(Color.green);
        setPreferredSize(new Dimension(X/5-15,200));

        addActionListener(actionListener -> {
            for (Vehicle car : cars) {car.startEngine();}
        });
    }
}
