package controller;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class Timekeeper {
    private final int delay = Config.getDelay();
    private final Timer timer;
    private final List<Observer> observers;

    public Timekeeper() {
        observers = new ArrayList<>();
        timer = new Timer(delay, e -> {
            for (Observer o : observers) {o.update();}
        });
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void start() {
        timer.start();
    }
}
