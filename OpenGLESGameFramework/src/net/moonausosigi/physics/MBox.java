package net.moonausosigi.physics;

import net.moonausosigi.math.MVector3;

public class MBox {

	public MVector3 leftTop = null;
	public MVector3 rightBottom = null;
	
	
	public class MRect{
		public float left = 0;
		public float top = 0;
		public float right = 0;
		public float bottom = 0;
		
		public MRect(){}
		public MRect(float left,float top,float right,float bottom)
		{
			this.left = left;
			this.top = top;
			this.right = right;
			this.bottom = bottom;
		}
	}
	
	public MBox(float left,float top,float right,float bottom)
	{
		setBox(new MRect(left, top, right, bottom));
	}
	
	public MBox(MRect rect)
	{
		setBox(rect);
	}
	
	
	public void setBox(MRect box)
	{
		if(box == null) return ;
		leftTop = new MVector3(box.left,box.top,0);
		rightBottom = new MVector3(box.right,box.bottom,0);
	}

}
