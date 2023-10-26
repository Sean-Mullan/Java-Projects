package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject
{
	Random ran = new Random();
	
	public Player(int x, int y, ID id) 
	{
		super(x, y, id);
	}

	
	public void tick() 
	{
		x += veloX;
		y += veloY;
	}

	
	public void render(Graphics graphics) 
	{
		if(id == ID.Player)graphics.setColor(Color.white);
		else if(id == ID.Player2)graphics.setColor(Color.red);
		graphics.fillRect(x, y, 32, 32);
	}
}
