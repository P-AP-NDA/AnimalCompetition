package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JPanel;


import entity.Player;
import gameTile.gametileManager;

public class GameWindow extends JPanel implements Runnable {
    
   public final int tileSizeOrginal = 16;
   final int scale = 3;

    public final int tileSize = tileSizeOrginal * scale;
    public final int columns = 16;
    public final int rows = 12;
    public final int width  = tileSize * columns;
    public final int height = tileSize * rows;

    //Settings for WORLD MAP
    public final int maxColumnsWorld = 90;
    public final int maxRowsWorld = 50;
    public final int widthOfWorld = tileSize * maxColumnsWorld;
    public final int heightOfWorld = tileSize * maxRowsWorld;

    //fps
    int fps = 60;
    

    //player information
    public int playerX = 100;
    public int playerY = 100;
    public int playerspeed = 4;

    gametileManager gametileM = new gametileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public checkCollision collisionChecker = new checkCollision(this);
    public Player player = new Player(this, keyH);

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

        gametileM.createTile(g2);

        player.changeSprite(g2);

        g2.dispose();
    }

}
