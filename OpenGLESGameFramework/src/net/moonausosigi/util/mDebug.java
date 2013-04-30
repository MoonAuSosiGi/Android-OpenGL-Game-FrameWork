package net.moonausosigi.util;

public class mDebug {

	public static void Log(String message)
	{
		android.util.Log.d("mDebug", message);
	}
	
	public static void Log(String tag,String message)
	{
		android.util.Log.d(tag, message);
	}
	
	public static void Warning(String message)
	{
		android.util.Log.w("mDebug", message);
	}
	
	public static void Warning(String tag,String message)
	{
		android.util.Log.w(tag, message);
	}
}
