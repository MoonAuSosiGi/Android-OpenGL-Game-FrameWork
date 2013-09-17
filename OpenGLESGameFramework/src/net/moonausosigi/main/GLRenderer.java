package net.moonausosigi.main;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import net.moonausosigi.manager.MSGFramework;
import net.moonausosigi.util.mDebug;
import android.opengl.GLSurfaceView.Renderer;
import android.view.MotionEvent;

public class GLRenderer implements Renderer {

	
	@Override
	public void onDrawFrame(GL10 gl) {
		
		//���������� ȣ��Ǵ� �޼ҵ�
		//ȭ�� Ŭ���� 
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		MSGFramework.getInstance()._mainCamera.Shot(gl);
		
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		//gl.glLoadIdentity();
		MSGFramework.getInstance().GameLoop(gl);		
		
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		
		mDebug.Log("OnSurfaceChanged","Width : "+width+" height : "+height);
		
		gl.glMatrixMode( GL10.GL_MODELVIEW );
		gl.glViewport(0, 0, width, height);

		gl.glEnable( GL10.GL_TEXTURE_2D );
		gl.glEnableClientState( GL10.GL_VERTEX_ARRAY );
		gl.glEnableClientState( GL10.GL_TEXTURE_COORD_ARRAY );
		gl.glEnable( GL10.GL_BLEND );
		gl.glEnable(GL10.GL_COLOR_BUFFER_BIT);
		gl.glEnable(GL10.GL_DEPTH_BUFFER_BIT);
		gl.glBlendFunc( GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA );
		

	
		
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		
		gl.glClearColor(199.0f/255.0f,1.0f,1.0f,1.0f);
		
		
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {

		//�ʱ�ȭ �ڵ�
		//������ �� �� ������� �ʴ� �Ϳ� ���� ���� �ڵ尡 ���� ������  

		gl.glShadeModel(GL10.GL_SMOOTH);
		gl.glEnable(GL10.GL_TEXTURE_2D); 
		gl.glClearDepthf(1.0f); //ã�ƺ���0
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,GL10.GL_NICEST);		
	}
	
	public void TouchEventDown(MotionEvent e)
	{
		
		for(int i=0;i<e.getPointerCount();i++)
		{
			mDebug.Log("x ("+(i+1)+") : "+e.getX(i)+" y ("+(i+1)+") : "+e.getY(i));
		}
	
	}

}
