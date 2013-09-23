package net.moonausosigi.manager;

import javax.microedition.khronos.opengles.GL10;

import net.moonausosigi.baseclass.MScene;
import net.moonausosigi.opengl.MCamera2D;
import net.moonausosigi.scene.TitleScene;
import net.moonausosigi.util.mDebug;
import android.app.Activity;
import android.util.DisplayMetrics;

public class MSGFramework {
	
	private static MSGFramework _instance= null;
	private Activity _currentActivity = null;
	private MScene _currentScene = null;
	private MScene _nextScene = new TitleScene();
	public GL10 _gl10 = null;
	public MCamera2D _mainCamera = new MCamera2D();
	
	private long _curTime = 0;
	private long _oldTime = 0;
	
	private float _gameWidth = 480.0f;
	private float _gameHeight = 800.0f;
	private float _widthPixel = 0;
	private float _heightPixel = 0;
	private float _aspectRatio = 0;

	public static MSGFramework getInstance()
	{
		if(_instance == null)
		{
			_instance = new MSGFramework();
		} 
		return _instance;
	}
	
	public void SetActvity(Activity a){	_currentActivity = a;}
	public Activity getActivity() { return _currentActivity; }
	
	public void GameLoop(GL10 gl)
	{
		_gl10 = gl;
		long elespedTime = Tick();
		Open();
		Update(elespedTime,gl);
		Render(gl);
		_gl10 = null;
	}
	public long Tick()
	{
		_oldTime = _curTime;
		_curTime = System.currentTimeMillis();
		
		return  _curTime - _oldTime;
	}
	public void Open()
	{
		if(_nextScene != null)
		{
			if(_currentScene != null)
				_currentScene.Clear();
			_nextScene.Start();
			_currentScene = _nextScene;
			_nextScene = null;
			
			mDebug.Log("Open !");
		}
	}
	
	public void Update(long time,GL10 gl)	
	{ 
		if(_currentScene != null)
			_currentScene.Update(time,gl);	
	}

	public void Render(GL10 gl)	
	{ 
		if(_currentScene != null)
			_currentScene.Render(gl);		
	}
	
	public void GameEnd()
	{
		if(_currentScene != null)
			_currentScene.Clear();
	}
	
	public void setWindowSize(float gameWidth,float gameHeight)
    {
		if(_currentActivity == null) return ;
		DisplayMetrics dmetrics = new DisplayMetrics();
		_currentActivity.getWindowManager().getDefaultDisplay().getMetrics(dmetrics);
		_widthPixel = (float)dmetrics.widthPixels;
		_heightPixel = (float)dmetrics.heightPixels;
		_aspectRatio = gameWidth / gameHeight;
    }
	
	public float getWidthPixel() { return _widthPixel; }
	public float getHeightPixel() { return _heightPixel; }
	public float getGameWidth() { return _gameWidth; }
	public float getGameHeight() { return _gameHeight; }
	public float getAspectRatio() { return _aspectRatio; }
}
