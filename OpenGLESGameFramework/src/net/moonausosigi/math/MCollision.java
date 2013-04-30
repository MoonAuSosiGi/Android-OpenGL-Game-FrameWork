package net.moonausosigi.math;

public class MCollision {

	//점과 선이 수직으로 만나는가?
	public static boolean isPointLineShortDistance(MVector3 lineStart, MVector3 lineEnd,MVector3 point)
	{	
		float u = PointLineGetU(lineStart, lineEnd, point);
		if(u <0.0f || u >1.0f)
			return false;		
		else
			return true;
	}

	//수직으로 만나는 점이 있을 경우 해당 점을 리턴, 그게 아닐 경우 직선의 양 끝점에서 가장 가까운 점을 리턴 
	//추후에 이것은 변경될 가능성이 존재함.
	public static MVector3 getPointLineCollisionVector(MVector3 lineStart, MVector3 lineEnd,MVector3 point)
	{	
		if(isPointLineShortDistance(lineStart, lineEnd, point) == false) 
		{
			// 이 경우 수직으로 만나는 점이 존재하지 않는다.
			float start = MMath.PointPointDistance(lineStart, point);
			float end = MMath.PointPointDistance(lineEnd, point);

			if(start > end)	return lineEnd;
			else			return lineStart;
		}
		else
		{
			//수직으로 만나는 점이 존재한다.
			float u = PointLineGetU(lineStart, lineEnd, point);

			return new MVector3(lineStart.x + u * (lineEnd.x - lineStart.x),
					lineStart.y + u * (lineEnd.y - lineStart.y),
					point.z);

		}
	}

	//P1 과 P2 를 지나는 직선의 방정식은 P = P1 + u(P2-P1) u 를 구해 리턴. 
	public static float PointLineGetU(MVector3 lineStart, MVector3 lineEnd,MVector3 point)
	{
		float mag = MVector3.VectorMinus(lineEnd,lineStart).Scale();
 
		if(mag != 0)
			return ((point.x - lineStart.x) * (lineEnd.x-lineStart.x) + (point.y - lineStart.y) * (lineEnd.y-lineStart.y))/(mag*mag);
		else
			return 0;
	}
}
