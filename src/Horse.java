import java.awt.*;

public class Horse {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public Horse(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getX() {
        return x;
    }
    public void setX(int x){
        this.x = x;
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

    public void paint(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.drawRect(this.x, this.y, this.width, this.height);

    }
    public boolean checkCollision(customRectangle other) {
        boolean collision = false;
        Rectangle thisRectangle = new Rectangle(this.x, this.y, this.width, this.height);
        Rectangle otherRectangle = new Rectangle(other.getX(), other.getY() ,other.getWidth(), other.getHeight());
        if (thisRectangle.intersects(otherRectangle))
            collision = true;
        return collision;
    }

    public void moveUp(){
        this.y-=10;
    }
    public void moveDown(){
        this.y+=10;
    }
    public void moveRight(){
        this.x+=5;
    }
    public void moveLeft(){
        this.x-=5;
    }
}
