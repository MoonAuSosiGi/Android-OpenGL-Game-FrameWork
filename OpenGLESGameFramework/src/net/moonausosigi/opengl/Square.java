	package net.moonausosigi.opengl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import net.moonausosigi.baseclass.MObject;

public class Square extends MObject{

	private float vertices[] = {
			-1.0f,	1.0f,	0.0f,
			-1.0f,	-1.0f,	0.0f,
			1.0f,	-1.0f,	0.0f,
			1.0f,	1.0f,	0.0f
	};
	
	/*
	 * 		v0 (-1,1,0) ??---------??v3(1,1,0)
	 * 					| \			|		
	 * 					|  \		|		
	 * 					|   \		|		
	 * 					|	 \		|		
	 * 					|	  \		|			   
	 * 					|		\   |
	 * 					|		  \ |
	 * 		v1(-1,-1,0)	??---------??v2(1,-1,0)
	 * 
	 * 
	 * http://www.gisdeveloper.co.kr/731?category=29
	 */
	//6/2(1+2)
	//Index buffer
	private short[] indices = { 0,	1,	2,	0,	2,	3 }; // 0 -> 1 -> 2 그린 ??0 -> 2 -> 3 그려??	
	
	private FloatBuffer vertexBuffer = null;
	private ShortBuffer indexBuffer = null;
	public Square(){
		
		ByteBuffer vertexBufferByte = ByteBuffer.allocateDirect(vertices.length * 4);
		vertexBufferByte.order(ByteOrder.nativeOrder());
		vertexBuffer = vertexBufferByte.asFloatBuffer();
		vertexBuffer.put(vertices);
		vertexBuffer.position(0);
		
		ByteBuffer indexBufferByte = ByteBuffer.allocateDirect(indices.length * 2);
		indexBufferByte.order(ByteOrder.nativeOrder());
		indexBuffer = indexBufferByte.asShortBuffer();
		indexBuffer.put(indices);
		indexBuffer.position(0);
	}
/*	@Override
	public void Start() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Update(long time) {
		
		
	}
	
	@Override	
	public void Render(GL10 gl){
	
		//?�점 �?�� ?�서�?반시�?방향?�로 �?�� 
		gl.glFrontFace(GL10.GL_CCW);
		gl.glEnable(GL10.GL_CULL_FACE);
		gl.glCullFace(GL10.GL_BACK);
	
		//?�점 배열???�해 모델???�더�??�겠??
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		// ?�점 배열 �?��
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
		// 그려??!
		gl.glDrawElements(GL10.GL_TRIANGLES,indices.length, GL10.GL_UNSIGNED_SHORT, indexBuffer);
		
		//?�나쪄용
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glDisable(GL10.GL_CULL_FACE);
	}
	
	@Override
	public void Clear() {
		
		if(vertexBuffer != null)
			vertexBuffer.clear();
		if(indexBuffer != null)
			indexBuffer.clear();
		
		vertexBuffer = null;
		indexBuffer = null;
	}*/
}
