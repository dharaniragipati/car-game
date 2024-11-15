package carrace;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Obstacle {
	private int x, y;
    private static final int LANE_WIDTH=80; // Three lane x-positions
    private Random random = new Random();

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveDown() {
        y += 10; // Speed of the obstacle
    }

    public void resetPosition() {
        y = -50; // Reset above the screen
       // x = LANES[random.nextInt(LANES.length)]; // Randomly choose one of the lanes
    
        int numLanes=5;
        x=LANE_WIDTH*random.nextInt(numLanes);
    }
    public int getX() { return x; }
    public int getY() { return y; }

    public Rectangle getBounds() {
        return new Rectangle(x, y, LANE_WIDTH, 50); // Adjust to obstacle size
    }
}

