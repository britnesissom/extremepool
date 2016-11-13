package britnesissom.extremepool;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class MyGLRenderer implements GLSurfaceView.Renderer {

    //Shapes
    private Square mSquare;

    //View Matrices
    private final float[] mMVPMatrix = new float[16];
    private final float[] mProjectionMatrix = new float[16];
    private final float[] mViewMatrix = new float[16];

    //Compiles Shader Code
    public static int loadShader(int type, String shaderCode) {

        //Creates a Vertex or Fragment Shader
        int shader = GLES20.glCreateShader(type);

        GLES20.glShaderSource(shader, shaderCode);
        GLES20.glCompileShader(shader);

        return shader;
    }

    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        //Initial Draw/Graphic Configs
        GLES20.glClearColor(0.9f, 0.9f, 0.95f, 1.0f);

        mSquare = new Square();
    }

    public void onSurfaceChanged(GL10 unused, int width, int height) {
        //Switch between portrait/landscape
        GLES20.glViewport(0, 0, width, height);
        float ratio = (float) width/height;

        Matrix.frustumM(mProjectionMatrix, 0,-ratio,ratio, -1, 1, 3, 7);
    }

    public void onDrawFrame(GL10 unused) {
        //Executes on each frame
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);

        Matrix.setLookAtM(mViewMatrix, 0, 0, 0, -3, 0f, 0f, 0f, 0f, 1.0f, 0f);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);

        mSquare.draw(mMVPMatrix);
    }
}