package com.tutorial.main;

import java.awt.Graphics;

public abstract class GameObject 
{
	//Protected means will only be accessed by classes inherited/ extending from Gameobject
	protected int x, y;
	protected ID id;
	protected int veloX, veloY;
	
	public GameObject(int x, int y, ID id)
	{
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics graphics);
	
	//setters and getters let us move x and y position around
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setID(ID id)
	{
		this.id = id;
	}
	public ID getID()
	{
		return id;
	}
	public void setVeloX(int veloX)
	{
		this.veloX = veloX;
	}
	public void setVeloY(int veloY)
	{
		this.veloY = veloY;
	}
	public int getVeloX()
	{
		return veloX;
	}
	public int getVeloY()
	{
		return veloY;
	}
}
