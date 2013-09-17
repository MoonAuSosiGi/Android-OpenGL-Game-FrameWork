package net.moonausosigi.baseclass;

import net.moonausosigi.math.MVector3;

public class MTransform {

	public MVector3 _pos = new MVector3();
	public MVector3 _scale = MVector3.One();
	private MTransform _parent = null;
	private MObject _gameObject = null;
	
	public void setGameObject(MObject obj)
	{
		_gameObject = obj;
	}
	
	public MObject gameObject()
	{
		return _gameObject;
	}
	public void setParent(MTransform transform)
	{
		if(_parent != null && _parent._gameObject != null && transform._gameObject != null)
			_parent._gameObject.DettachChildObject(transform._gameObject);
		_parent = transform;
	}
	
	public MTransform getParent()
	{
		return _parent;
	}
}
