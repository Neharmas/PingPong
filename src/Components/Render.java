package src.Components;

import Util.Vector2;

import javax.swing.*;
import java.awt.*;

public class Render extends JPanel implements BaseComponent{
    private int width;
    private int height;

    public Render(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);

        int pixelSize = 10;  // Size of each pixel

        for (int x = 0; x < pixels.length; x++) {
            for (int y = 0; y < pixels[0].length; y++) {
                int pixelColor = pixels[x][y];
                g.setColor(new Color(pixelColor));
                g.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
    }
    public void render(Vector2 position) {
        pixels = new int[width][height];
    }
}
