
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class gameScene extends JPanel {

    private Horse player1;
    private Horse player2;
    private ImageIcon iconPlayer1;
    private ImageIcon iconPlayer2;
    private horseImage imageOfPlayer1;
    private horseImage imageOfPlayer2;
    private int x = 30, y1 = 82, y2 = 335, width = 100, height = 50;
    private JLabel player1Label;
    private JLabel player2Label;
    private JLabel finishField;
    private loginWindow name1;
    private loginWindow name2;

    private customRectangle[] squares;

    private customRectangle[] obstacles;
    private horseImage[] horseEnemy;
    private ImageIcon enemyImageIcon;


    public gameScene(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        this.setBackground(Color.orange.darker().darker().darker());

        this.player1 = new Horse(this.x, this.y1, this.width, this.height,
                Color.orange.darker().darker().darker());
        this.player2 = new Horse(this.x, this.y2, this.width, this.height,
                Color.orange.darker().darker().darker());

        iconPlayer1 = new ImageIcon("horsePlayer2Image.gif");
        iconPlayer2 = new ImageIcon("horsePlayer2Image.gif");

        this.imageOfPlayer1 = new horseImage(iconPlayer1, this.x, this.y1);
        this.imageOfPlayer2 = new horseImage(iconPlayer2, this.x, this.y2);

        //obstacles
        this.obstacles = new customRectangle[10000];
        this.horseEnemy = new horseImage[10000];
        Random rnd = new Random();

        this.enemyImageIcon = new ImageIcon("obstacle image.gif");
        for (int i = 0; i < obstacles.length; i++) {

            int randomIndex = rnd.nextInt(0, 468);
            horseImage obstacleImage = new horseImage(enemyImageIcon, 1000, randomIndex);
            this.horseEnemy[i] = obstacleImage;

            customRectangle enemy = new customRectangle(1000, randomIndex, 30, 30, Color.orange.darker().darker().darker());
            this.obstacles[i] = enemy;
        }
        //main Game Loop
        this.gameLoop();
    }

    protected void paintComponent(Graphics G) {
        super.paintComponent(G);

        //middle line
        G.setColor(Color.WHITE);
        G.fillRect(0, 232, 1000, 3);

        //player1 Label
        this.player1Label = new JLabel();
        player1Label.setBounds(50, 0, 80, 25);
        Font myDeafaultFont = new Font("Arial", Font.BOLD, 15);
        player1Label.setFont(myDeafaultFont);
        player1Label.setText(loginWindow.name1);
        this.add(player1Label);
        player1Label.setBackground(Color.WHITE);
        player1Label.setForeground(Color.orange.darker().darker().darker());
        player1Label.setOpaque(true);

        //player 2 Label
        this.player2Label = new JLabel();
        player2Label.setBounds(50, 235, 80, 25);
        player2Label.setFont(myDeafaultFont);
        player2Label.setText(loginWindow.name2);
        this.add(player2Label);
        player2Label.setBackground(Color.WHITE);
        player2Label.setForeground(Color.orange.darker().darker().darker());
        player2Label.setOpaque(true);


        //players
        this.player1.paint(G);
        this.player2.paint(G);


        //Finish Field
        this.finishField = new JLabel();
        finishField.setBounds(900, 212, 85, 40);
        Font finishFont = new Font("Arial", Font.BOLD, 40);
        finishField.setFont(finishFont);
        finishField.setText("END");
        this.add(finishField);
        finishField.setBackground(null);
        finishField.setForeground(Color.WHITE);
        finishField.setOpaque(true);

        //start field
        squares = new customRectangle[20];
        int x = 0;
        int y = 0;
        int width = 25;
        int height = 25;
        for (int i = 0; i < squares.length; i += 2) {
            G.setColor(Color.WHITE);
            G.fillRect(x, y, width, height);
            y += 50;
        }
        y = 25;
        for (int i = 1; i < squares.length; i += 2) {
            G.setColor(Color.BLACK);
            G.fillRect(x, y, width, height);
            y += 50;
        }
        x = 25;
        y = 0;
        for (int i = 0; i < squares.length; i += 2) {
            G.setColor(Color.BLACK);
            G.fillRect(x, y, width, height);
            y += 50;
        }
        y = 25;
        for (int i = 1; i < squares.length; i += 2) {
            G.setColor(Color.WHITE);
            G.fillRect(x, y, width, height);
            y += 50;
        }

        //drawing horses
        this.imageOfPlayer1.paint(G);
        this.imageOfPlayer2.paint(G);

        //drawing obstacles
        for (int i = 0; i < obstacles.length; i++) {
            this.obstacles[i].paint(G);
            this.horseEnemy[i].paint(G);
        }
    }

    public void gameLoop() {
        new Thread(() -> {
            playerMovement playerMovement = new playerMovement(this.player1, this.player2,
                    this.imageOfPlayer1, this.imageOfPlayer2);
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(playerMovement);
            first:
            while (true) {
                try {
                    repaint();
                    Thread.sleep(1);
                    this.limits();
                    this.moveObstacles();
                    if (win1()) {
                        player1Label.setVisible(false);
                        player2Label.setVisible(false);
                        finishField.setVisible(false);
                        player1Win player1Win = new player1Win(0, 0, 1000, 500);
                        this.add(player1Win);
                        break;
                    }
                    if (win2()) {
                        this.removeAll();
                        player1Label.setVisible(false);
                        player2Label.setVisible(false);
                        finishField.setVisible(false);
                        player2Win player2Win = new player2Win(0, 0, 1000, 500);
                        this.add(player2Win);
                        break;
                    }
                    for (int i = 0; i < obstacles.length; i++) {
                        if (player1.checkCollision(obstacles[i])) {
                            player1.setX(30);
                            imageOfPlayer1.setX(30);
                        }
                        if (player2.checkCollision(obstacles[i])) {
                            player2.setX(30);
                            imageOfPlayer2.setX(30);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //player1 win
    public boolean win1() {
        if (this.player1.getX() > (983 - player1.getWidth()))
            return true;
        return false;

    }

    //player2 win
    public boolean win2() {
        if (this.player2.getX() > (983 - player2.getWidth()))
            return true;
        return false;
    }

    public void moveObstacles() {
        new Thread(() -> {
            while (true) {
                for (int i = 0; i < obstacles.length; i++) {
                    try {
                        obstacles[i].moveLeft();
                        this.horseEnemy[i].moveLeft();
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void limits() {
        if (this.player1.getY() < 0) {
            player1.moveDown();
            imageOfPlayer1.moveDown();
        }

        if (this.player1.getY() > 227 - player1.getHeight()) {
            player1.moveUp();
            imageOfPlayer1.moveUp();
        }

        if (this.player1.getX() < 0) {
            player1.moveRight();
            imageOfPlayer1.moveRight();
        }

        if (this.player2.getY() < 232) {
            player2.moveDown();
            imageOfPlayer2.moveDown();
        }

        if (this.player2.getY() > 455 - player2.getHeight()) {
            player2.moveUp();
            imageOfPlayer2.moveUp();
        }

        if (this.player2.getX() < 0) {
            player2.moveRight();
            imageOfPlayer2.moveRight();
        }
    }

}
