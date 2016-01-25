package jsw.util;

/**
 * Created by on 25.01.2016.
 */
public class Vector2f {
    public static final Vector2f X_AXIS = new Vector2f(1, 0);
    public static final Vector2f Y_AXIS = new Vector2f(0, 1);

    private float x;
    private float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float length(){
        return (float) Math.sqrt(x * x + y * y);
    }

    public Vector2f normalize(){
        float length = length();
        x /= length;
        y /= length;
        return this;
    }

    public Vector2f add(Vector2f r){
        return new Vector2f(x + r.x, y + r.y);
    }

    public Vector2f add(float r){
        return new Vector2f(x + r, y + r);
    }

    public Vector2f sub(Vector2f r){
        return new Vector2f(x - r.x, y - r.y);
    }

    public Vector2f sub(float r){
        return new Vector2f(x - r, y +-r);
    }

    public Vector2f mul(Vector2f r){
        return new Vector2f(x * r.x, y * r.y);
    }

    public Vector2f mul(float r){
        return new Vector2f(x * r, y * r);
    }

    public Vector2f div(Vector2f r){
        return new Vector2f(x / r.x, y / r.y);
    }

    public Vector2f div(float r){
        return new Vector2f(x / r, y / r);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String toString(){
        return "(" + x + " " + y + ")";
    }
}
