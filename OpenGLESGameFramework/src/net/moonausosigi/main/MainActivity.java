package net.moonausosigi.main;

import net.moonausosigi.manager.MSGFramework;
import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		MSGFramework.getInstance().SetActvity(this);
		
		//GLSurfaceView
		setContentView(new GLSurfaceView(getApplicationContext()));
		MSGFramework.getInstance().setWindowSize(800.0f,480.0f);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		MSGFramework.getInstance().GameEnd();
	}
	
}
