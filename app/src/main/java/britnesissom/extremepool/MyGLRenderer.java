package britnesissom.extremepool;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class MyGLRenderer implements GLSurfaceView.Renderer {

    private Square mSquare;

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
    }

    public void onDrawFrame(GL10 unused) {
        //Executes on each frame
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        mSquare.draw();
    }
}