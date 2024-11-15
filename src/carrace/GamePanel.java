package carrace;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener,KeyListener
{
	 private Image roadImage, carImage, obstacleImage;
	    private Timer timer;
	    private Car car;
	    private ArrayList<Obstacle> obstacles;
	    private int roadY = 0;
	    private int score = 0;

	    public GamePanel() {
	        loadImages();
	        car = new Car(100, 300);
	        obstacles = new ArrayList<>();
	        int numLanes=getWidth()/80;
	        for(int i=0;i<numLanes;i++)
	        {
	        	obstacles.add(new Obstacle(i*80,-100*(i+1)));
	        }

	        // Add two obstacles
	        obstacles.add(new Obstacle(100, -100)); // First obstacle
	        obstacles.add(new Obstacle(400, -400));
	        //obstacles.add(new Obstacle(800, -600));
	      //  obstacles.add(new Obstacle(800, -800));// Second obstacle

	        setFocusable(true);
	        requestFocusInWindow();
	        addKeyListener(this);

	        timer = new Timer(20, this); // Game update interval (lower = faster)
	        timer.start();
	    }

	    private void loadImages() {
	        roadImage = new ImageIcon(getClass().getResource("/road2.jpg")).getImage();
	        carImage = new ImageIcon(getClass().getResource("/car.jpg")).getImage();
	        obstacleImage = new ImageIcon(getClass().getResource("/front car.jpg")).getImage();
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        drawRoad(g);
	        drawCar(g);
	        drawObstacles(g);
	        drawScore(g); // Display score
	    }

	    private void drawRoad(Graphics g) {
	        if (roadImage != null) {
	            g.drawImage(roadImage, 0, roadY, getWidth(), getHeight(), this);
	            g.drawImage(roadImage, 0, roadY - getHeight(), getWidth(), getHeight(), this);
	        }
	    }

	    private void drawCar(Graphics g) {
	        if (carImage != null) {
	            g.drawImage(carImage, car.getX(), car.getY(), 80, 120, this);
	        }
	    }

	    private void drawObstacles(Graphics g) {
	        for (Obstacle obstacle : obstacles) {
	            g.drawImage(obstacleImage, obstacle.getX(), obstacle.getY(), 50, 50, this);
	        }
	    }

	    private void drawScore(Graphics g) {
	        g.setColor(Color.WHITE);
	        g.setFont(new Font("Arial", Font.BOLD, 20));
	        g.drawString("Score: " + score, 10, 30);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        roadY += 5;
	        if (roadY >= getHeight()) {
	            roadY = 0;
	        }

	        for (Obstacle obstacle : obstacles) {
	            obstacle.moveDown();
	            if (obstacle.getY() > getHeight()) {
	                obstacle.resetPosition();
	                score += 10; // Increment score when obstacle resets
	            }

	            if (car.getBounds().intersects(obstacle.getBounds())) {
	                timer.stop();
	                JOptionPane.showMessageDialog(this, "Game Over! You hit an obstacle.\nScore: " + score);
	                score = 0; // Reset score
	                return;
	            }
	        }

	        repaint();
	    }

	    @Override
	    public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	            car.moveLeft();
	        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	            car.moveRight(getWidth());
	        }
	        repaint();
	    }

	    @Override public void keyReleased(KeyEvent e) {}
	    @Override public void keyTyped(KeyEvent e) {}
	    
	}
		
	


