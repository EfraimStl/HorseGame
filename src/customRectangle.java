import java.awt.*;
import java.util.Random;

public class customRectangle {
    private double x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public customRectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;

    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public void paint(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.drawRect((int) this.x, this.y, this.width, this.height);
    }
    public void moveLeft(){
        this.x-=0.1;
    }
}
