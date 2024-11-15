package carrace;

import javax.swing.JFrame;

public class CarGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         JFrame frame=new JFrame("Car Racing Game ");
         GamePanel gamePanel=new GamePanel();
         frame.add(gamePanel);
         frame.setSize(500,700);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
	}

}
