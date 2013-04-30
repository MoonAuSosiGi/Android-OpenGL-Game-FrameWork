package net.moonausosigi.math;


public class MVector3 {

	public float x = 0f;
	public float y = 0f;
	public float z = 0f;
	
	public MVector3(){}
	public MVector3(MVector3 v){ this.x = v.x; this.y = v.y; this.z = v.z; }
	public MVector3(float x,float y,float z){ this.x = x ; this.y = y; this.z = z; }

	public float Scale(){ return (float)Math.sqrt(x*x + y*y + z*z); } // |V|
	
	public MVector3 Normalize()
	{
		float scale = this.Scale();
		if(MMath.isZero(scale))			
			return new MVector3(0,0,0);
		else
		{
			return new MVector3(
					x / scale,
					y / scale,
					z / scale);
		}
	}
	
	public static MVector3 VectorPlus(MVector3 vector1, MVector3 vector2)
	{ 
		if(vector1 == null || vector2 == null) return null;
		else	return new MVector3(vector1.x + vector2.x ,vector1.y + vector2.y,vector1.z + vector2.z); 
	}
	public static MVector3 VectorMinus(MVector3 vector1, MVector3 vector2)
	{
		if(vector1 == null || vector2 == null) return null;
		else	return new MVector3(vector1.x - vector2.x ,vector1.y - vector2.y,vector1.z - vector2.z);
	}
	
	public static float VectorDot(MVector3 vector1,MVector3 vector2)
	{
		if(vector1 == null || vector2 == null) return 0.0f;
		else	return vector1.x * vector2.x + vector1.y * vector2.y + vector1.z * vector2.z;
	}
	
	public static MVector3 VectorProduct(MVector3 vector1,MVector3 vector2)
	{
		if(vector1 == null || vector2 == null) return null;
		else return new MVector3(vector1.y * vector2.z - vector1.z * vector2.y,
								vector1.z * vector2.x - vector1.x * vector2.z,
								vector1.x * vector2.y - vector1.y * vector2.x);
	}
	
	public static float VectorAngle(MVector3 vector1,MVector3 vector2)
	{
		if(vector1 == null || vector2 == null) return 0.0f;
		else return (float)Math.acos((double)(vector1.Dot(vector2) / (vector1.Scale() * vector2.Scale())));
	}
	
	//외적으로도 각도를 구할 수 있다.
	
//	public static float VectorAngle(MVector3 vector1,MVector3 vector2)
//	{
//		if(vector1 == null || vector2 == null) return 0.0f;
//		else return (float)Math.asin((double)(vector1.Product(vector2).Scale() / (vector1.Scale() * vector2.Scale())));
//	}

	public MVector3 Plus(MVector3 vector)
	{	
		if(vector == null) return null;
		else return new MVector3(x+vector.x,y+vector.y,z+vector.z);
	}
	public MVector3 Minus(MVector3 vector)
	{	
		if(vector == null) return null;
		else return new MVector3(x-vector.x,y-vector.y,z-vector.z);
	}
	
	public float Dot(MVector3 vector)
	{
		if(vector == null) return 0.0f;
		else return x * vector.x + y * vector.y + z * vector.z;
	}
	
	public float Dot(float vecScale1, float vecScale2,float angle)
	{
		return vecScale1 * vecScale2 * (float)Math.cos((double)angle);
	}
	
	public MVector3 Product(MVector3 vector)
	{
		if(vector == null) return null;
		else return new MVector3( y * vector.z - z * vector.y,
								  z * vector.x - x * vector.z,
								  x * vector.y - y * vector.x);
	}
	
	public MVector3 Product(float scalar)
	{
		return new MVector3(x*scalar,y*scalar,z*scalar);
	}
	
	@Override
	public boolean equals(Object v) {
		

		if(v == null || v instanceof MVector3 == false)
		{
			return false;
		}

		MVector3 vec = (MVector3)v;
		
		if(Float.compare(x,vec.x) == 0 
		&& Float.compare(y,vec.y) == 0
		&& Float.compare(z,vec.z) == 0)
		{
			return true;
		}
		else 
			return false;
	
	}
	
	@Override
	public String toString()
	{
		return "x "+x+" y "+y+" z "+z;
	}
}
