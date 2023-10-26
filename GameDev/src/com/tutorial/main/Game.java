package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1550691097823471818L;
	//Width and height of display window, height is sum to make changing easier
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	//Threads make thread of multiple executions at once, all with different priorities
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private Random ran;
	
	public Game()
	{
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		//Game requires a window to run in, window requires a game, use THIS to self reference
		new Window(WIDTH, HEIGHT, "Let's make a Game!", this);
		ran = new Random();
		handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player));
		handler.addObject(new Player(WIDTH/2+32,HEIGHT/2-32,ID.Player2));
	}

	public synchronized void start()
	{
		//THIS refers to this instance of our game class
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop()
	{
		//TRY to do something, if you CATCH it not working, do what's in catch
		try 
		{
			thread.join();
			running = false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	
	//Updates the game every frame
	public void run()
	{
		//Maths for figuring out if a frame has passed
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running == true)
		{
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta >= 1) //Has a frame passed?
			{
				tick(); //Update the game
				delta--; //reset delta to check again
			}
			if(running == true)
			{
				render();
				frames++; //Add to the FPS
			}
			//Counts FPS
			if(System.currentTimeMillis() - timer > 1000) //1 second has passed
			{
				timer += 1000;
				System.out.println("FPS: "+frames);
				//Reset frames to prevent it not being in seconds
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick()
	{
		handler.tick();
	}

	private void render()
	{
		//create buffer to allow game to load
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics graphics = bs.getDrawGraphics();
		
		graphics.setColor(Color.black);
		//Fills window with chosen colour
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(graphics);
		
		graphics.dispose();
		//Displays what is rendered
		bs.show();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Game();
	}

}
