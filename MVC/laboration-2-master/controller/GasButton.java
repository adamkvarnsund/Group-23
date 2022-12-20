package controller;

import Model.Vehicle;
import java.util.List;
import javax.swing.*;

public class GasButton extends JButton{
    public GasButton(List<Vehicle> cars, GasSpinner spinner){
        super("Gas");
        addActionListener(actionlistener -> {
            for (Vehicle car : cars) {
                car.gas(spinner.getGasAmount());
            }
        });
    }
}
