package jsw.util;

/**
 * Created by on 25.01.2016.
 */

/**
 * Immutable class that represents point in 2D space with integer coordinates.
 */
public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point add(Point other){
        return new Point(x + other.x, y + other.y);
    }

    public Point sub(Point other){
        return new Point(x - other.x, y - other.y);
    }
}
