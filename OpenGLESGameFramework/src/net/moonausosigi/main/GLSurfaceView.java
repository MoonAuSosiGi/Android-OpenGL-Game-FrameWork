package net.moonausosigi.main;

import android.content.Context;

public class GLSurfaceView extends android.opengl.GLSurfaceView {

	private GLRenderer _renderer = null;
	public GLSurfaceView(Context context) {
		super(context);
		
		_renderer = new GLRenderer();
		setRenderer(_renderer);
	
	}

}
