package carrace;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;

public class Car {
	 private int x, y;

	    public Car(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	    public void moveLeft() {
	        if (x > 0) {
	            x -= 30;
	        }
	    }

	    public void moveRight(int panelWidth) {
	        if (x + 80 < panelWidth) { // Adjust for car width
	            x += 30;
	        }
	    }

	    public int getX() { return x; }
	    public int getY() { return y; }

	    public Rectangle getBounds() {
	        return new Rectangle(x, y, 80, 100); // Adjust to car image size
	    }
    }

