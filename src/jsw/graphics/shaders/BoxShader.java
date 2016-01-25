package jsw.graphics.shaders;

import jsw.util.Vector2f;
import jsw.util.Vector4f;

/**
 * Created by on 25.01.2016.
 */
public class BoxShader extends ShaderProgram {
    private int loc_position, loc_size, loc_color;

    public BoxShader() {
        super("box_vs.glsl", "box_fs.glsl");
    }

    @Override
    protected void getAllUniformLocations() {
        loc_position = getUniformLocation("u_position");
        loc_size = getUniformLocation("u_size");
        loc_color = getUniformLocation("u_color");
    }

    @Override
    protected void bindAttributes() {
        bindAttribute(0, "in_pos");
    }

    public void setPosition(Vector2f position){
        loadVector2f(loc_position, position);
    }

    public void setSize(Vector2f size){
        loadVector2f(loc_size, size);
    }

    public void setColor(Vector4f color){
        loadVector4f(loc_color, color);
    }
}
