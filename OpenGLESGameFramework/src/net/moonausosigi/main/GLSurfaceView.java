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
	
		//GLSurfaceView 는 독자적인 렌더링 쓰레드를 생성하고 관리할 수 있도록 한다.
		//queueEvent 는 UI 쓰레드와 렌더링 쓰레드 사이에 안정된 커뮤니케이션을 위해 사용한다고 한다. - 권장사항
		
		
		queueEvent(new Runnable() {
			
			@Override
			public void run() {
				
				MInput.TouchEvent(event);
				
			}
		});
		return true;
	}
	
	

}
