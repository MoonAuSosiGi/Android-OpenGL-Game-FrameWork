package net.moonausosigi.main;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import net.moonausosigi.util.mDebug;

import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;


public class GLRenderer implements Renderer {

	@Override
	public void onDrawFrame(GL10 gl) {
		
		//지속적으로 호출되는 메소드
		
		//화면 클리어 
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		gl.glClearColor(199.0f/255.0f,1.0f,1.0f,1.0f);
		
		gl.glLoadIdentity();

		//모든  gl 명령을 실행하라 
		gl.glFlush();
		
		 
		
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		
		mDebug.Log("OnSurfaceChanged","Width : "+width+" height : "+height);
		//화면 회전 , 혹은 크기 변경시 실행 (뷰포트 설정 등 )
		
		//뷰포트 설정 
		gl.glViewport(0, 0, width, height);

		//행렬 모드 투영
		gl.glMatrixMode(GL10.GL_PROJECTION);
		//행렬 초기화 
		gl.glLoadIdentity();
		
		//클리핑 영역 설정 ( 직교 투영 방식 )
	//	gl.glOrthof(0 ,width ,height ,0 ,1 ,-1 );
		
		GLU.gluPerspective(gl, 45.0f, (float)width/(float)height,0.1f,100.0f);
		
		//행렬 모드 모델 뷰  - 이제부터 변환과정이 실제로 그리는 것에 영향을 미치게 한다.
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {

		//초기화 코드
		//렌더링 될 때 변경되지 않는 것에 대한 설정 코드가 오면 적합함  

		//Smooth Shading 이 가능하게 설정 
		gl.glShadeModel(GL10.GL_SMOOTH);
		
		gl.glClearDepthf(1.0f); //찾아보기
		gl.glEnable(GL10.GL_DEPTH_TEST); 
		gl.glDepthFunc(GL10.GL_LEQUAL);
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,GL10.GL_NICEST);
		
	}
}
