package jsw.app;

import jsw.util.Point;
import jsw.util.Size;
import jsw.util.Vector2f;
import jsw.util.Vector4f;

import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;

/**
 * Created by on 25.01.2016.
 */
public class Window extends GLFWWindowHost {
    public Window(Size size, String title) throws Exception {
        super(size, title);
        glClearColor(0.0f, 0.4f, 0.7f, 1.0f);
    }

    @Override
    protected void onClose() {

    }

    @Override
    protected void refresh() {
        glClear(GL_COLOR_BUFFER_BIT);

        Application.instance().getRenderer().drawBox(new Vector2f(-0.3f, -0.2f), new Vector2f(0.5f, 0.4f), new Vector4f(1.0f, 0.0f, 0.0f, 1.0f));

        swapBuffers();
    }

    @Override
    protected void onMove(Point point) {

    }

    @Override
    protected void onResize() {

    }

    @Override
    protected void onKeyPress(int key, int scancode, int action, int mods) {

    }
}
