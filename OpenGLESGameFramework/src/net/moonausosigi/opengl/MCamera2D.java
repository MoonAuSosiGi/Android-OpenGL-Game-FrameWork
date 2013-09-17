package net.moonausosigi.opengl;

import javax.microedition.khronos.opengles.GL10;

import net.moonausosigi.manager.MSGFramework;
import net.moonausosigi.math.MVector3;
import android.opengl.GLU;

public class MCamera2D {

	public MVector3 _pos = MVector3.Zero();
	
	public void Reset()
	{
		_pos.Set(0.0f, 0.0f, 0.0f);
	}
	
	public void Shot(GL10 gl)
	{
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();
		
		GLU.gluOrtho2D(gl, 
				_pos.x,
				_pos.x + MSGFramework.getInstance().getGameWidth(), 
				_pos.y + MSGFramework.getInstance().getGameHeight(), 
				_pos.y);
	}
	
	public void Move(float diffx,float diffy)
	{
		_pos.x += diffx;
		_pos.y += diffy;
	}	 
}
