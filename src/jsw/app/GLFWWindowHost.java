package jsw.app;

import jsw.util.Point;
import jsw.util.Size;
import org.lwjgl.glfw.*;

import static org.lwjgl.glfw.GLFW.*;

/**
 * Created by on 25.01.2016.
 */
public abstract class GLFWWindowHost {
    private long handle;

    private Size size;
    private String title;

    public GLFWWindowHost(Size size, String title) throws Exception {
        this.size = size;
        this.title = title;

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_DECORATED, GLFW_TRUE);

        handle = glfwCreateWindow(size.getWidth(), size.getHeight(), title, 0, 0);
        if(handle == 0)
            throw new Exception("Window creation failed.");

        Application.registerWindow(this);

        glfwMakeContextCurrent(handle);

        glfwSwapInterval(1);

        glfwSetWindowCloseCallback(handle, new GLFWWindowCloseCallback() {
            @Override
            public void invoke(long window) {
                GLFWWindowHost host = Application.getWindow(window);
                host.onClose();
            }
        });
        glfwSetWindowRefreshCallback(handle, new GLFWWindowRefreshCallback() {
            @Override
            public void invoke(long window) {
                GLFWWindowHost host = Application.getWindow(window);
                host.refresh();
            }
        });
        glfwSetWindowPosCallback(handle, new GLFWWindowPosCallback() {
            @Override
            public void invoke(long window, int xpos, int ypos) {
                GLFWWindowHost host = Application.getWindow(window);
                host.onMove(new Point(xpos, ypos));
            }
        });
        glfwSetWindowSizeCallback(handle, new GLFWWindowSizeCallback() {
            @Override
            public void invoke(long window, int width, int height) {
                GLFWWindowHost host = Application.getWindow(window);
                host.setSize(new Size(width, height));
                host.onResize(new Size(width, height));
            }
        });
        glfwSetKeyCallback(handle, new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                GLFWWindowHost host = Application.getWindow(window);
                host.onKeyPress(key, scancode, action, mods);
            }
        });

    }

    public long getHandle() {
        return handle;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
        glfwSetWindowSize(handle, size.getWidth(), size.getHeight());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        glfwSetWindowTitle(handle, title);
    }

    public boolean isShouldClose(){
        return glfwWindowShouldClose(handle) == GLFW_TRUE;
    }

    public void show(){
        glfwShowWindow(handle);
    }

    public void swapBuffers(){
        glfwSwapBuffers(handle);
    }

    public void destroy(){
        glfwDestroyWindow(handle);
    }

    protected abstract void onClose();

    protected abstract void refresh();

    protected abstract void onMove(Point point);

    protected abstract void onResize(Size size);

    protected abstract void onKeyPress(int key, int scancode, int action, int mods);
}
