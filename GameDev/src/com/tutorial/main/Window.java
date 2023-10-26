package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -240840600533728354L;

	public Window (int width,int height,String title, Game game)
	{
		JFrame frame = new JFrame(title);
		//functions in Jframe
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		//Makes sure Jframe stops when window closes
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Stops window being made bigger by user
		frame.setResizable(false);
		//Makes sure window is in centre
		frame.setLocationRelativeTo(null);
		//Adds game form Game class into frame
		frame.add(game);
		//makes window visible
		frame.setVisible(true);
		game.start();
	}

}
