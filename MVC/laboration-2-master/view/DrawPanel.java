package view;
import java.awt.*;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import Model.*;
import controller.Observer;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements Observer{

    private List<Vehicle> sprites;

    // Initializes the panel and reads the images
    public DrawPanel(List<Vehicle> sprites) {
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(800, 800-240));
        setBackground(Color.green);
        this.sprites = sprites;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Vehicle car : sprites)
            try {
                BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream(car.getPictureFile()));
                g.drawImage(image, (int) car.getX(), (int) car.getY(), null);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void update() {
        repaint();
    }
}
