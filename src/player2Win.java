import javax.swing.*;
import java.awt.*;

public class player2Win extends JPanel {

    private ImageIcon player2Win;
    private int x, y, width, height;

    public player2Win(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        this.setBounds(this.x, this.y, this.width, this.height);
        this.player2Win = new ImageIcon("Player2 win.png");
        this.setVisible(true);

       // Button1 button1 = new Button1(0,0, 1000,500);
     //   this.add(button1);
       /* //play again button
        JButton button = new JButton();
        button.setText("PLAY AGAIN");
        button.setBackground(Color.YELLOW);
        button.setBounds(this.width/2-100, 100, 200, 30);
        this.add(button);

        //Timer settings
        JLabel label = new JLabel();
        label.setBounds(this.width/2-20, this.height/2-120,
                40, 40);
        Font myDeafaultFont = new Font("Arial", Font.BOLD, 20);
        label.setFont(myDeafaultFont);
        label.setText("");
        this.add(label);
        label.setBackground(Color.orange.darker());
        label.setForeground(Color.BLACK);
        label.setOpaque(true);

        //what happen when pressing on button
        button.addActionListener((event) -> {
            new Thread(() -> {
                int timer = 3;
                while (true) {
                    try {
                        if (timer>0)
                            label.setText(String.valueOf(timer));
                        Thread.sleep(1000);
                        timer--;
                        if (timer == 0)
                            label.setText("GO");
                        if (timer == -1) {
                            button.setVisible(false);
                            gameScene game = new gameScene(0, 0, 1000, 500);
                            this.add(game);
                            break;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });*/
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player2Win.paintIcon(null, g, this.x, this.y);
    }
}
