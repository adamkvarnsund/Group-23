package controller;

import javax.swing.*;

public class GasSpinner extends JSpinner{
    public GasSpinner() {
        super(new SpinnerNumberModel(0, 0, 100, 1));
    }

    public double getGasAmount() {
        double value = (int)getValue();
        return value / 100;
    }
}
