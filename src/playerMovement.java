
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class playerMovement implements KeyListener {

  private Horse player1;
   private Horse player2;
   private horseImage imageOfPlayer1;
   private horseImage imageOfPlayer2;

   public playerMovement(Horse player1, Horse player2, horseImage imageOfPlayer1,
                         horseImage imageOfPlayer2){
        this.player1 = player1;
        this.player2 = player2;
        this.imageOfPlayer1 = imageOfPlayer1;
        this.imageOfPlayer2 = imageOfPlayer2;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                player1.moveUp();
                imageOfPlayer1.moveUp();
                break;
            case KeyEvent.VK_DOWN:
                player1.moveDown();
                imageOfPlayer1.moveDown();
                break;
            case KeyEvent.VK_RIGHT:
                player1.moveRight();
                imageOfPlayer1.moveRight();
                break;

            case KeyEvent.VK_W:
                player2.moveUp();
                imageOfPlayer2.moveUp();
                break;
            case KeyEvent.VK_S:
                player2.moveDown();
                imageOfPlayer2.moveDown();
                break;
            case KeyEvent.VK_D:
                player2.moveRight();
                imageOfPlayer2.moveRight();
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

    }
}
