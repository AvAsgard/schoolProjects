import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * CS 121 Project 1: Traffic Animation
 *
 * Animates a [put your description here]
 *
 * @author BSU CS 121 Instructors
 * @author Cameron Bentley
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 100; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	private int xOffset = 0;

	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 10;

	private final Color BACKGROUND_COLOR = Color.black;
	private final Color LANE_COLOR = Color.gray;
	private final ImageIcon CROMULONS_ICON = new ImageIcon("cromulon.png");

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height
		
		int laneStart = (int) (height*0.333);
		int laneEnd = (int) (height*0.333);

		// Fill the graphics page with the background color.
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);
		
		g.drawImage(CROMULONS_ICON.getImage(), 75, 30, width/12, height/12, null);
		//Ask Dr. Anderson
		
		g.setColor(LANE_COLOR);
		//g.fillRect(0, laneStart, width, laneEnd);

		// Calculate the new xOffset position of the moving object.
		xOffset  = (xOffset + stepSize) % width;

		// TODO: Use width, height, and xOffset to draw your scalable objects
		// at their new positions on the screen

		
		
		// This draws a green square. Replace it with your own object.
		int squareSide = height / 5;
		int squareY = height / 2; // - squareSide / 2;
		
		//g.setColor(Color.DARK_GRAY);
		//g.fillRect(xOffset, squareY, squareSide, squareSide);

		String str = "Show me what you got!";
		
		g.setFont(new Font("Serif", Font.BOLD, width/20));
		
		FontMetrics metrics = g.getFontMetrics();
		
		int x = (width - metrics.stringWidth(str))/2;
		int y = (height/2 + metrics.getHeight()) / 2;
		
		
		//Randomly generated stars from the end of the 1/3 to the 2/3 of the total height of the window
		for(int i=0; i<width; i+=50) {
			Random rand = new Random();
			int starHeight = rand.nextInt(height/3)+laneStart;
			g.setColor(Color.WHITE);
			g.fillOval(i, starHeight, 5, 5);
		}

		
		
		
		//Car
		g.setColor(Color.WHITE);
		g.drawString(str,x,y);
		
	
		
		g.setColor(Color.DARK_GRAY);
		g.fillArc( (int) (xOffset + 0.15*squareSide),  (int) (squareY + squareSide/2.5), (squareSide/5), (squareSide/5), 0, 360);
		
		g.setColor(Color.DARK_GRAY);
		g.fillArc( (int) (xOffset + 0.65*squareSide),  (int) (squareY + squareSide/2.5), (squareSide/5), (squareSide/5), 0, 360);

		
		g.setColor(Color.GRAY);
		g.fillArc(xOffset, squareY, squareSide, squareSide, 0, 180);
		
		Color c = new Color(211,211,211);

		g.setColor(c);
		g.fillArc(xOffset + (squareSide/4), squareY - squareSide/5, squareSide/2, squareSide/2, 0, 180);	
		

		g.setColor(new Color(102,51,0));
		g.fillRect(xOffset + squareSide/9, squareY + (squareSide/8), squareSide/4, squareSide/8);
		
		
		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}