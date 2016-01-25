package jsw.app;

import jsw.util.Point;
import jsw.util.Size;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;

/**
 * Created by on 25.01.2016.
 */
public class Window extends GLFWWindowHost {
    public Window(Size size, String title) throws Exception {
        super(size, title);
    }

    @Override
    protected void onClose() {

    }

    @Override
    protected void refresh() {
        glClear(GL_COLOR_BUFFER_BIT);
        swapBuffers();
    }

    @Override
    protected void onMove(Point point) {

    }

    @Override
    protected void onResize(Size size) {

    }

    @Override
    protected void onKeyPress(int key, int scancode, int action, int mods) {

    }
}
