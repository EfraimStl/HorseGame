import javax.swing.*;

public class Window extends JFrame {

    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 500;


    public Window() {
        Button1 button1 = new Button1(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        //finishPage finishPage = new finishPage(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("My Game");
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       // this.add(finishPage);
       this.add(button1);
    }

    public static void main(String[] args) {

        loginWindow window = new loginWindow();

    }
}
