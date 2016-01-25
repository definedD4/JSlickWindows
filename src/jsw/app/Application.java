package jsw.app;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by on 25.01.2016.
 */
public class Application {
    private static Map<Long, GLFWWindowHost> windows = new HashMap<>();

    public static void registerWindow(GLFWWindowHost window){
        windows.put(window.getHandle(), window);
    }

    public static GLFWWindowHost getWindow(long handle){
        return windows.get(handle);
    }
}
