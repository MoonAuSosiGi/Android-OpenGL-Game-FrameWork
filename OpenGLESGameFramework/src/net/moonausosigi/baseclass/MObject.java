package net.moonausosigi.baseclass;

import java.util.Vector;

import javax.microedition.khronos.opengles.GL10;

import net.moonausosigi.math.MVector3;

public class MObject {

	public MVector3 _position = new MVector3();
	public MTransform _transform = new MTransform();
	public Vector<MComponent> _components = new Vector<MComponent>();
	public Vector<MObject> _childList = new Vector<MObject>();
	private boolean _destroy = false;

	
	/////////////
	public MObject()
	{
		_transform.setGameObject(this);
	}
	
	//new
	
	public static void GameObjectDestroy(MObject obj)
	{
		
	}
	public void Update(long time, GL10 gl)
	{
		if(_destroy || _components == null)
			return ;
		
		for(int i=0; i < _components.size(); i++)
			_components.get(i).Update(time, gl);
		
		if(_destroy)
		{
			for(int i=0; i < _components.size(); i++)
				_components.get(i).Destroy();
			_components.clear();
			_components = null;
			_position = null;
			_transform = null;
		}
	}
	
	public void AttachChildObject(MObject obj)
	{
		obj._transform.setParent(this._transform);
		if(!_childList.contains(obj))
			_childList.add(obj);
			
	}
	
	public void DettachChildObject(MObject obj)
	{
		if(_childList.contains(obj))
			_childList.remove(obj);
	}
	
	public void AddComponent(MComponent component)
	{
		component._transform = _transform;
		
		component.Start();
		_components.add(component);
	}
	
	public void Destroy()
	{
		this._destroy = true;
	}
}