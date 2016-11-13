package britnesissom.extremepool;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class OpenGLActivity extends AppCompatActivity {

    private GLSurfaceView mGLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGLView = new MyGLSurfaceView(this);
        setContentView(mGLView);
    }
}

class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer mRenderer;

    public MyGLSurfaceView(Context context) {
        super(context);

        setEGLContextClientVersion(2);

        mRenderer = new MyGLRenderer();

        setRenderer(mRenderer);
    }
}

class MyGLRenderer implements GLSurfaceView.Renderer {

    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        //Initial Draw/Graphic Configs
        GLES20.glClearColor(0.0f, 0.4f, 0.4f, 1.0f);
    }

    public void onSurfaceChanged(GL10 unused, int width, int height) {
        //Switch between portrait/landscape
        GLES20.glViewport(0, 0, width, height);
    }

    public void onDrawFrame(GL10 unused) {
        //Executes on each frame
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }
}