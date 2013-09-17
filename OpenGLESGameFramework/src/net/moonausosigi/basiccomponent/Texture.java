package net.moonausosigi.basiccomponent;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

import net.moonausosigi.baseclass.MComponent;
import net.moonausosigi.manager.MSGFramework;
import net.moonausosigi.math.MMath;
import net.moonausosigi.math.MVector3;
import net.moonausosigi.util.mDebug;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

public class Texture extends MComponent{
	
    private FloatBuffer _vertexBuffer;
    private FloatBuffer _textureBuffer;
    //private FloatBuffer _colorBuffer;
    
    public float _angle = 0.0f;
    public MVector3 _drawPivot = MVector3.Zero();
    public MVector3 _anglePivot = MVector3.Zero();
    
    private int[] _textures = new int[1];
    private int _imgWidth, _imgHeight;
    private boolean _textureLoaded = false;
    

    @Override
    public void Start()
    {
    	ByteBuffer byteBuf;

        byteBuf = ByteBuffer.allocateDirect(48);
        byteBuf.order( ByteOrder.nativeOrder() );
        _vertexBuffer = byteBuf.asFloatBuffer();

        byteBuf = ByteBuffer.allocateDirect(32);
        byteBuf.order(ByteOrder.nativeOrder());
        _textureBuffer = byteBuf.asFloatBuffer();

//        byteBuf = ByteBuffer.allocateDirect(64);
  //      byteBuf.order(ByteOrder.nativeOrder());
    //    _colorBuffer = byteBuf.asFloatBuffer();
    }
    
    @Override
    public void Update(long time,GL10 gl)
    {
    	if(_transform == null && _textureLoaded == false) return ;
    	DrawTexture(gl, _transform._pos.x, _transform._pos.y, _angle, _anglePivot.x, _anglePivot.y, _transform._scale.x, _transform._scale.y);
    }
    
    @Override
    public void Destroy()
    {
    	_vertexBuffer.clear();
    	_textureBuffer.clear();
    	_vertexBuffer = null;
    	_textureBuffer = null;
    	_textures = null;
    	_anglePivot = null;
    }
        
    public void DrawTexture(GL10 gl, float x,float y)
    {
    	DrawTexture(gl,x,y,0.0f,0.0f,0.0f,1.0f,1.0f);
    }
    
    public void DrawTexture(GL10 gl, float x,float y, float scaleX, float scaleY)
    {
    	DrawTexture(gl,x,y,0.0f,0.0f,0.0f,scaleX,scaleY);
    }
    
    public void DrawTexture(GL10 gl, float x,float y,float angle)
    {
    	DrawTexture(gl,x,y,angle,0.0f,0.0f,1.0f,1.0f);
    }
    
    public void DrawTexture(GL10 gl, float x,float y,float angle,float pivotX,float pivotY) 
    {
    	DrawTexture(gl,x,y,angle,pivotX,pivotY,1.0f,1.0f);
    }
	
	public void DrawTexture( GL10 gl, float x, float y,float angle,float pivotX,float pivotY, float scalex, float scaley )
	{
		float[] vertices = {
				x-(_imgWidth*_drawPivot.x)				,	y+_imgHeight-(_imgHeight*_drawPivot.y)	,	0.0f,	// LEFT  | BOTTOM
				x+_imgWidth-(_imgWidth*_drawPivot.x)	,	y+_imgHeight-(_imgHeight*_drawPivot.y)	,	0.0f,	// RIGHT | BOTTOM
				x-(_imgWidth*_drawPivot.x)				,	y-(_imgHeight*_drawPivot.y)				,	0.0f,	// LEFT  | TOP
				x+_imgWidth-(_imgWidth*_drawPivot.x)	,	y-(_imgHeight*_drawPivot.y)				,	0.0f	// RIGHT | TOP
		};

		float[] texture = {
				0.0f	, 1.0f,
				1.0f	, 1.0f,
				0.0f	, 0.0f,
				1.0f	, 0.0f
		};

		_vertexBuffer.put( vertices );
		_vertexBuffer.position( 0 );

		_textureBuffer.put( texture );
		_textureBuffer.position( 0 );

		gl.glPushMatrix();
		
		if(MMath.isZero(angle))
		{
			gl.glTranslatef( x - pivotX, y - pivotY, 0 );
			gl.glRotatef( angle, 0, 0, 1 );
			gl.glTranslatef( -(x - pivotX), -(y - pivotY), 0 );
		}

		gl.glTranslatef( x + (_imgWidth / 2), y + (_imgHeight / 2), 0 );
		gl.glScalef( scalex, scaley, 1.0f );
		gl.glTranslatef( -(x + (_imgWidth / 2)), -(y + (_imgHeight / 2)), 0 );
	
		gl.glBindTexture( GL10.GL_TEXTURE_2D, _textures[0] );
		//gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ZERO);
		gl.glVertexPointer( 3, GL10.GL_FLOAT, 0, _vertexBuffer );
		gl.glTexCoordPointer( 2, GL10.GL_FLOAT, 0, _textureBuffer );
		gl.glDrawArrays( GL10.GL_TRIANGLE_STRIP, 0, 4 );
		gl.glPopMatrix();
	}
	
	public void LoadTexture(int file)
	{
		this.LoadTexture(MSGFramework.getInstance()._gl10, file);
	}
	
	 private void LoadTexture( GL10 gl, int filename )
	 {
		 if(gl == null)
		 {
			 mDebug.Log("ERROR");
		 }
		Bitmap bitmap = null;
        InputStream is = MSGFramework.getInstance().getActivity().getResources().openRawResource( filename );

        try {
            bitmap = BitmapFactory.decodeStream(is);
        } finally {
            try {
                is.close();
                is = null;
            } catch (IOException e) {
            }
        }
        _imgWidth = bitmap.getWidth();
        _imgHeight = bitmap.getHeight();

        gl.glGenTextures( 1, _textures, 0 );
        gl.glBindTexture( GL10.GL_TEXTURE_2D, _textures[0] );

        gl.glTexParameterf( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST );
        gl.glTexParameterf( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR );

        gl.glTexParameterf( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_S, GL10.GL_REPEAT );
        gl.glTexParameterf( GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_WRAP_T, GL10.GL_REPEAT );

        GLUtils.texImage2D( GL10.GL_TEXTURE_2D, 0, bitmap, 0 );
        bitmap.recycle();
        
        _textureLoaded = true;
    }
	
}
