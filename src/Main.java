import jsw.app.Application;
import jsw.app.Window;
import jsw.util.Size;
import jsw.util.Vector2f;
import jsw.util.Vector4f;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;

public class Main {
    public static void main(String[] args) {
        Application.instance();

        Window window1 = null, window2 = null;
        try {
            window1 = new Window(new Size(1024, 720), "My window 1");
            window2 = new Window(new Size(640, 480), "My window 2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert window1 != null;
        assert window2 != null;

        window1.show();
        window2.show();

        Application.instance().run();

        Application.instance().close();
    }
}
