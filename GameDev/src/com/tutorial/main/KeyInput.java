package com.tutorial.main;

//import classes that allow function in response to many key presses
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//inherit all KeyAdapter functions
public class KeyInput extends KeyAdapter
{
	private Handler handler;
	
	public KeyInput(Handler handler)
	{
		//the handler in the constructor is equal to our private handler
		this.handler = handler;
	}
	
	//built in from keyadapter - must be lowercase at start
	public void keyPressed(KeyEvent event)
	{
		int key = event.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++)
		{
			//cycles through every object in game with tempobject
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID()== ID.Player)
			{
				//key events for player 1
				if(key == KeyEvent.VK_W) tempObject.setVeloY(-5);
				if(key == KeyEvent.VK_A) tempObject.setVeloX(-5);
				if(key == KeyEvent.VK_S) tempObject.setVeloY(+5);
				if(key == KeyEvent.VK_D) tempObject.setVeloX(+5);
			}
			if(tempObject.getID()== ID.Player2)
			{
				//key events for player 2
				if(key == KeyEvent.VK_UP) tempObject.setVeloY(-5);
				if(key == KeyEvent.VK_LEFT) tempObject.setVeloX(-5);
				if(key == KeyEvent.VK_DOWN) tempObject.setVeloY(+5);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVeloX(+5);
			}
		}
	}
	public void keyReleased(KeyEvent event)
	{
		int key = event.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++)
		{
			//cycles through every object in game with tempobject
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID()== ID.Player)
			{
				//key events for player 1
				if(key == KeyEvent.VK_W) tempObject.setVeloY(0);
				if(key == KeyEvent.VK_A) tempObject.setVeloX(0);
				if(key == KeyEvent.VK_S) tempObject.setVeloY(0);
				if(key == KeyEvent.VK_D) tempObject.setVeloX(0);
			}
			if(tempObject.getID()== ID.Player2)
			{
				//key events for player 2
				if(key == KeyEvent.VK_UP) tempObject.setVeloY(0);
				if(key == KeyEvent.VK_LEFT) tempObject.setVeloX(0);
				if(key == KeyEvent.VK_DOWN) tempObject.setVeloY(0);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVeloX(0);
			}
		}
	}
}
