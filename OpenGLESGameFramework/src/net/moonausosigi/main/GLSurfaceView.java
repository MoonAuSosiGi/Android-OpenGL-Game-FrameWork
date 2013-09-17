package net.moonausosigi.main;

import net.moonausosigi.io.MInput;
import android.content.Context;
import android.view.MotionEvent;

public class GLSurfaceView extends android.opengl.GLSurfaceView {

	private GLRenderer _renderer = null;
	public GLSurfaceView(Context context) {
		super(context);
		_renderer = new GLRenderer();
		setRenderer(_renderer);
	}
	@Override
	public boolean onTouchEvent(final MotionEvent event) {
	
		//GLSurfaceView �� �������� ������ �����带 �����ϰ� ������ �� �ֵ��� �Ѵ�.
		//queueEvent �� UI ������� ������ ������ ���̿� ������ Ŀ�´����̼��� ���� ����Ѵٰ� �Ѵ�. - �������
		
		
		queueEvent(new Runnable() {
			
			@Override
			public void run() {
				
				MInput.TouchEvent(event);
				
			}
		});
		return true;
	}
	
	

}
