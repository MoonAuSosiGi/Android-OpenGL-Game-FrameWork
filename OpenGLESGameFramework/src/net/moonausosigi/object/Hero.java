package net.moonausosigi.object;


import net.moonausosigi.baseclass.MObject;
import net.moonausosigi.basiccomponent.Texture;
import net.moonausosigi.io.MInput;
import net.moonausosigi.io.MInput.MTouchEvent;
import net.moonausosigi.main.R;
import net.moonausosigi.ui.Anchor;
import net.moonausosigi.ui.Anchor.Anchor_dir;

public class Hero extends MObject implements MTouchEvent{


	public Hero()
	{
		super();
		
		Texture texture = new Texture();
		texture._drawPivot.Set(0.5f, 0.5f, 0);
		texture.LoadTexture(R.drawable.nemo);
		this.AddComponent(texture);
		Anchor anchor = new Anchor();
		anchor._dir = Anchor_dir.CENTER_CENTER;
		this.AddComponent(anchor);
		MInput.RegisterEvent(this);
	}

	@Override
	public void TouchDown(float x, float y) {
		
		
	}

	@Override
	public void TouchUp(float x, float y) {

		
	}

	@Override
	public void TouchMove(float x, float y) {

		
	}

}
