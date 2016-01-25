import jsw.app.Window;
import jsw.util.Size;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;

public class Main {
    public static void main(String[] args) {
        glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err));
        glfwInit();

        Window window = null;
        try {
            window = new Window(new Size(1024, 720), "My window");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert window != null;

        window.show();

        GL.createCapabilities();

        glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
        while (!window.isShouldClose()){
            glfwWaitEvents();
        }

        window.destroy();
    }
}
