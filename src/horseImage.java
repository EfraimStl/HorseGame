import javax.swing.*;
import java.awt.*;

public class horseImage {

    private double x;
    private int y;
    private ImageIcon horse;

    public horseImage(ImageIcon horse, int x, int y){
        this.horse = horse;
        this.x = x;
        this.y = y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void paint(Graphics G){
        horse.paintIcon(null, G, (int) this.x, this.y);
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
        this.x-=0.1;
    }
}
