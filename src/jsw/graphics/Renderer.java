package jsw.graphics;

import jsw.graphics.shaders.BoxShader;
import jsw.util.Vector2f;
import jsw.util.Vector4f;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

/**
 * Created by on 25.01.2016.
 */
public class Renderer {
    private static final float[] QUAD_POSITIONS = {
            -0.5f, 0.5f,
            0.5f, 0.5f,
            0.5f, -0.5f,
            -0.5f, -0.5f
    };

    private static final int[] QUAD_INDICES = {
            0, 1, 2,
            0, 2, 3
    };

    private BoxShader boxShader = new BoxShader();

    private List<Integer> vaos = new ArrayList<>();
    private List<Integer> vbos = new ArrayList<>();

    int quadVao, quadPosVbo, quadIndVbo;

    public Renderer(){
        initQuad();
    }

    private void initQuad(){
        quadVao = glGenVertexArrays();
        vaos.add(quadVao);
        glBindVertexArray(quadVao);

        quadPosVbo = GL15.glGenBuffers();
        vbos.add(quadPosVbo);
        glBindBuffer(GL15.GL_ARRAY_BUFFER, quadPosVbo);
        FloatBuffer buffer = BufferUtils.createFloatBuffer(8);
        buffer.put(QUAD_POSITIONS);
        buffer.flip();
        glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);
        glVertexAttribPointer(0, 2, GL11.GL_FLOAT, false, 0, 0);
        glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);

        quadIndVbo = GL15.glGenBuffers();
        vbos.add(quadIndVbo);
        GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, quadIndVbo);
        IntBuffer buffer1 = BufferUtils.createIntBuffer(6);
        buffer1.put(QUAD_INDICES);
        buffer1.flip();
        GL15.glBufferData(GL15.GL_ELEMENT_ARRAY_BUFFER, buffer1, GL15.GL_STATIC_DRAW);
    }

    public void drawBox(Vector2f position, Vector2f size, Vector4f color){
        boxShader.start();

        boxShader.setPosition(position);
        boxShader.setSize(size);
        boxShader.setColor(color);

        glBindVertexArray(quadVao);
        glEnableVertexAttribArray(0);
        GL11.glDrawElements(GL11.GL_TRIANGLES, 6, GL11.GL_UNSIGNED_INT, 0);
        glDisableVertexAttribArray(0);
        glBindVertexArray(0);
        boxShader.stop();
    }

    public void cleanUp(){
        for (int vao : vaos){
            GL30.glDeleteVertexArrays(vao);
        }
        for(int vbo : vbos){
            GL15.glDeleteBuffers(vbo);
        }
    }
}
