package net.moonausosigi.math;



public class MMath {

	//직선 기울기 리턴
	public static float LineSlope(MVector3 point1,MVector3 point2)
	{
		return (point2.y - point1.y) / (point2.x - point1.x);
	}
	
	//점과 점 사이의 길이 
	public static float PointPointDistance(MVector3 point1,MVector3 point2)
	{
		return (float)Math.sqrt( (point2.x - point1.x) * (point2.x - point1.x) + (point2.y - point1.y) * (point2.y - point1.y) );
	}
	
	//var 가 지정값 이내에 있는가?
	public static boolean isRange(float min,float max,float var)
	{
		if(min <= var && var <= max)
			return true;
		else
			return false;
	}
	
	// 0 체크 
	public static boolean isZero(float var)
	{
		return (Float.compare(0, var) == 0);
	}

}
