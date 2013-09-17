package net.moonausosigi.scene;

import javax.microedition.khronos.opengles.GL10;

import net.moonausosigi.baseclass.MScene;
import net.moonausosigi.object.Hero;
import net.moonausosigi.util.mDebug;

public class TitleScene extends MScene {

	Hero hero = null;
	@Override
	public void Start() {
		
		mDebug.Log("START");	
		
		hero = new Hero();
	}
	
	@Override
	public void Update(long time,GL10 gl)
	{
		hero.Update(time, gl);
	}
	
	@Override
 	public void Clear(){
		hero.Destroy();
	}
}
