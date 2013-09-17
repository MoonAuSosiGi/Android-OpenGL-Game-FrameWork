package net.moonausosigi.physics;

import net.moonausosigi.math.MVector3;

public class MLine {

	public MVector3 lineStart;
	public MVector3 lineEnd;
	
	
	public MLine()
	{
		lineStart = new MVector3();
		lineEnd = new MVector3();
	}

	public MLine(MVector3 start,MVector3 end)
	{
		lineStart = start;
		lineEnd = end;
	}
	
	public MLine(float startX,float startY,float endX,float endY)
	{
		lineStart = new MVector3(startX, startY, 0);
		lineEnd = new MVector3(endX,endY,0);
	}
}
