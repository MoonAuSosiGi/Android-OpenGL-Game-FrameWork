package net.moonausosigi.ui;

import javax.microedition.khronos.opengles.GL10;

import net.moonausosigi.baseclass.MComponent;
import net.moonausosigi.manager.MSGFramework;

public class Anchor extends MComponent {

	public enum Anchor_dir{
		LEFT_TOP,
		CENTER_TOP,
		RIGHT_TOP,
		LEFT_CENTER,
		CENTER_CENTER,
		RIGHT_CENTER,
		LEFT_BOTTOM,
		CENTER_BOTTOM,
		RIGHT_BOTTOM,
		NONE
	}
	
	public Anchor_dir _dir = Anchor_dir.NONE;
	public float _width = MSGFramework.getInstance().getGameWidth();
	public float _height = MSGFramework.getInstance().getGameHeight();

	@Override
	public void Start() {
		super.Start();
		SetAnchor();
	}

	@Override
	public void Update(long time, GL10 gl) {
		super.Update(time, gl);
		SetAnchor();
	}
	
	private void SetAnchor()
	{
		switch(_dir)
		{
		case LEFT_TOP:		this._transform._pos.Set(0,0,this._transform._pos.z);						break;
		case CENTER_TOP:	this._transform._pos.Set(_width/2.0f,0,this._transform._pos.z);				break;
		case RIGHT_TOP:		this._transform._pos.Set(_width,0,this._transform._pos.z);					break;
		case LEFT_CENTER:	this._transform._pos.Set(0,_height/2.0f,this._transform._pos.z);			break;
		case CENTER_CENTER:	this._transform._pos.Set(_width/2.0f,_height/2.0f,this._transform._pos.z);	break;
		case RIGHT_CENTER:	this._transform._pos.Set(_width,_height/2.0f,this._transform._pos.z);		break;
		case LEFT_BOTTOM:	this._transform._pos.Set(0,_height,this._transform._pos.z);					break;
		case CENTER_BOTTOM:	this._transform._pos.Set(_width/2.0f,_height,this._transform._pos.z);		break;
		case RIGHT_BOTTOM:	this._transform._pos.Set(_width,_height,this._transform._pos.z);			break;
		default: break;
		}
	}
	
	
}
