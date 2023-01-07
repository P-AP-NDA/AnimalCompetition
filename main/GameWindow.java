package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JPanel;

import entity.Player;

public class GameWindow extends JPanel implements Runnable {
    
   public final int tileSizeOrginal = 16;
    final int scale = 3;

   public final int tileSize = tileSizeOrginal * scale;
    final int columns = 16;
    final int rows = 12;
    final int width  = tileSize * columns;
    final int height = tileSize * rows;

    //fps
    int fps = 60;

    //player information
    public int playerX = 100;
    public int playerY = 100;
    public int playerspeed = 4;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Player player = new Player(this, keyH);

    public GameWindow() {

        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() { 

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while(gameThread != null) {

            double interval = 1000000000/fps;
            double nextDraw = System.nanoTime() + interval;


            update();

            repaint();

            double timeRemaining = nextDraw - System.nanoTime();
            timeRemaining = timeRemaining/1000000;

            if(timeRemaining < 0) {
                timeRemaining = 0;
            }

            try {

                Thread.sleep( (long) timeRemaining);

                nextDraw += interval;

            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        }

    }
    

    public void update(){

        player.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;

        player.changeSprite(g2);

        g2.dispose();
    }

}
