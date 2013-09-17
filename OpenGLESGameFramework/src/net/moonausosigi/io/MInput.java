package net.moonausosigi.io;

import java.util.ArrayList;

import net.moonausosigi.manager.MSGFramework;
import android.view.MotionEvent;

public class MInput {

	public static ArrayList<MTouchEvent> _touchEvents = new ArrayList<MTouchEvent>();
	
	public static void RegisterEvent(MTouchEvent target)
	{
		if(_touchEvents != null)
		{
			if(_touchEvents.contains(target) == false)
				_touchEvents.add(target);
		}
	}
	
	public static void UnRegisterEvent(MTouchEvent target)
	{
		if(_touchEvents != null)
		{
			if(_touchEvents.contains(target) == true)
				_touchEvents.remove(target);
		}
	}
	
	public static void TouchEvent(MotionEvent e)
	{
		int action = e.getAction();
		
		float x = (MSGFramework.getInstance().getGameWidth() / MSGFramework.getInstance().getWidthPixel()) * e.getX();
		float y = (MSGFramework.getInstance().getGameHeight() / MSGFramework.getInstance().getHeightPixel()) * e.getY();
		
		switch(action)
		{
		case MotionEvent.ACTION_DOWN:
			for(int i=0;i<_touchEvents.size(); i++)
				_touchEvents.get(i).TouchDown(x,y); 
			break;	
		case MotionEvent.ACTION_UP:
			for(int i=0;i<_touchEvents.size(); i++)
				_touchEvents.get(i).TouchUp(x,y);  
			break;
		case MotionEvent.ACTION_MOVE:
			for(int i=0;i<_touchEvents.size(); i++)
				_touchEvents.get(i).TouchMove(x,y); 
			break;
		}
	}
	
	public interface MTouchEvent
	{
		void TouchDown(float x,float y);
		void TouchUp(float x,float y);
		void TouchMove(float x,float y);
	}
}
