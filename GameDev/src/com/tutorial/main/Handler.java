package com.tutorial.main;

import java.awt.Graphics;
import java.util.LinkedList;

//Loops through and updates all objects in game, renders them on screen
public class Handler 
{
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick()
	{
		// make i = to the amount of objects we have, so all are looped through
		for(int i = 0; i < object.size(); i++)
		{
			//think like arrays: gets current object in list, starting with 0 the first
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}
	public void render(Graphics graphics)
	{
		for(int i = 0; i < object.size(); i++)
		{
			//think like arrays: gets current object in list, starting with 0 the first
			GameObject tempObject = object.get(i);
			tempObject.render(graphics);
		}
	}
	
	public void addObject(GameObject object)
	{
		this.object.add(object);
	}
	public void removeObject(GameObject object)
	{
		this.object.remove(object);
	}
}
