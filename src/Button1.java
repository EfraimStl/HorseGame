import javax.swing.*;
import java.awt.*;

public class Button1 extends JPanel{

    private int WINDOW_WIDTH = 1000;
    private int WINDOW_HEIGHT = 500;
    private ImageIcon openPage;

    public Button1(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);

        this.openPage = new ImageIcon("Open Image1.png");

        //start button
        JButton button = new JButton();
        button.setText("CLICK HERE TO START");
        button.setBackground(Color.YELLOW);
        button.setBounds(this.WINDOW_WIDTH/2-100, 100, 200, 30);

        this.add(button);

        //Timer settings
        JLabel label = new JLabel();
        label.setBounds(this.WINDOW_WIDTH/2-20, this.WINDOW_HEIGHT/2-120,
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
        });

    }

        protected void paintComponent(Graphics G){
            super.paintComponent(G);
            this.openPage.paintIcon(this, G, 0, -5 );
        }
    }
