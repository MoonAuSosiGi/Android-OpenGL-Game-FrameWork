package net.moonausosigi.baseclass;

import javax.microedition.khronos.opengles.GL10;

import android.graphics.Canvas;

public abstract class MScene {
	
	public abstract void Start();
	
	public void Render(Canvas c)
	{

	}
	
	public void Render(GL10 gl)
	{
		
	}
	
	public void Update(long time,GL10 gl)
	{

	}
	
	
	
	public void Update(long time){

	}
	
	public void Clear()
	{

	}
}
