package jsw.app;

import jsw.graphics.Renderer;
import org.lwjgl.glfw.GLFWErrorCallback;

import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.glfw.GLFW.*;

/**
 * Created by on 25.01.2016.
 */
public class Application {
    private static Application instance;

    public static Application instance(){
        if(instance == null){
            instance = new Application();
        }
        return instance;
    }

    private Map<Long, GLFWWindowHost> windows = new HashMap<>();
    private Renderer renderer;

    private Application(){
        glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err));
        glfwInit();
        renderer = new Renderer();
    }

    public void close(){
        for(GLFWWindowHost wnd : windows.values()){
            wnd.close();
        }
        glfwTerminate();
    }

    public void run(){
        while (windows.size() > 0){
            glfwWaitEvents();
        }
    }

    public void registerWindow(GLFWWindowHost window){
        windows.put(window.getHandle(), window);
    }

    public GLFWWindowHost getWindow(long handle){
        return windows.get(handle);
    }

    public void deleteWindow(GLFWWindowHost window){
        windows.remove(window.getHandle());
    }

    public Renderer getRenderer() {
        return renderer;
    }
}
