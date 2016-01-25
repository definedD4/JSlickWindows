package jsw.util;

/**
 * Created by on 25.01.2016.
 */
public class Color {
    private byte r, g, b, a;

    public Color() {
        r = 0;
        g = 0;
        b = 0;
        a = 0;
    }

    public Color(byte r, byte g, byte b, byte a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public byte getR() {
        return r;
    }

    public byte getG() {
        return g;
    }

    public byte getB() {
        return b;
    }

    public byte getA() {
        return a;
    }

    private static final Color BLACK = new Color((byte)0  , (byte)0  , (byte)0  , (byte)255);
    private static final Color WHITE = new Color((byte)255, (byte)255, (byte)255, (byte)255);
    private static final Color RED   = new Color((byte)255, (byte)0  , (byte)0  , (byte)255);
    private static final Color GREEN = new Color((byte)0  , (byte)255, (byte)0  , (byte)255);
    private static final Color BLUE  = new Color((byte)0  , (byte)0  , (byte)255, (byte)255);
}
