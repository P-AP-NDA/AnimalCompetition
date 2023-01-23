package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.util.Random;
import Animals.Animal;
import mapImage.mapImage;


// import entity.Player;
// import gameTile.gametileManager;

public class BattleWindow extends JPanel implements Runnable {
    
    public final int tileSizeOrginal = 16;
    final int scale = 3;

    public final int imageHeight = 576;
    public final int imageWidth = 768;
    public final int columns = 16;
    public final int rows = 12;
    public final int width  = 1024;
    public final int height = 576;

    //Settings for WORLD MAP
    public final int maxColumnsWorld = 90;
    public final int maxRowsWorld = 90;
    // public final int widthOfWorld = tileSize * maxColumnsWorld;
    // public final int heightOfWorld = tileSize * maxRowsWorld;

    //fps
    int fps = 60;

    mapImage mImage = new mapImage(this);
    Animal opponent = getRandomOpponent();
    Animal player = getRandomPlayer();

    Thread gameThread;

    public BattleWindow() {

        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        

    }

    public void startGameThread() { 

        gameThread = new Thread(this);
        gameThread.start();
    }

    public Animal getRandomOpponent() {
        Animal bee = new Animal(300, 200, 300, 10, 30, 47, 20, 56, "Bee", "/res/AnimalImages/bee.png");
        ArrayList<String> beeMoves = new ArrayList<String>();
        beeMoves.add("Bite");
        beeMoves.add("Buzz");
        beeMoves.add("Sting");
        beeMoves.add("Slash");
        bee.setMoveList(beeMoves);
        Animal bear = new Animal(500, 200, 400, 10, 10, 40, 0, 2, "Bear", "/res/AnimalImages/bear.png");
        ArrayList<String> bearMoves = new ArrayList<String>();
        bearMoves.add("Claw");
        bearMoves.add("Slash");
        bearMoves.add("Tackle");
        bearMoves.add("Bite");
        bear.setMoveList(bearMoves);
        Animal snake = new Animal(500, 200, 400, 10, 10, 40, 0, 2, "Snake", "/res/AnimalImages/snake.png");
        ArrayList<String> snakeMoves = new ArrayList<String>();
        snakeMoves.add("Constrict");
        snakeMoves.add("Venom Strike");
        snakeMoves.add("Taunt");
        snakeMoves.add("Bite");
        snake.setMoveList(snakeMoves);
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(bee);
        animals.add(bear);
        animals.add(snake);


        int min = 0;
        int max = 2;
        int random_index = (int)Math.floor(Math.random() * (max - min + 1) + min);

        return animals.get(random_index);

    }
    public Animal getRandomPlayer() {
        Animal bee = new Animal(300, 200, 300, 10, 30, 47, 20, 56, "Bee", "/res/AnimalImages/bee.png");
        ArrayList<String> beeMoves = new ArrayList<String>();
        beeMoves.add("Bite");
        beeMoves.add("Buzz");
        beeMoves.add("Sting");
        beeMoves.add("Slash");
        bee.setMoveList(beeMoves);
        Animal bear = new Animal(500, 200, 400, 10, 10, 40, 0, 2, "Bear", "/res/AnimalImages/bear.png");
        ArrayList<String> bearMoves = new ArrayList<String>();
        bearMoves.add("Claw");
        bearMoves.add("Slash");
        bearMoves.add("Tackle");
        bearMoves.add("Bite");
        bear.setMoveList(bearMoves);
        Animal snake = new Animal(500, 200, 400, 10, 10, 40, 0, 2, "Snake", "/res/AnimalImages/snake.png");
        ArrayList<String> snakeMoves = new ArrayList<String>();
        snakeMoves.add("Constrict");
        snakeMoves.add("Venom Strike");
        snakeMoves.add("Taunt");
        snakeMoves.add("Bite");
        snake.setMoveList(snakeMoves);
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(bee);
        animals.add(bear);
        animals.add(snake);


        int min = 0;
        int max = 2;
        int random_index = (int)Math.floor(Math.random() * (max - min + 1) + min);

        return animals.get(random_index);

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

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;

        mImage.createTile(g2);
        opponent.drawSpriteOpponent(g2);
        player.drawSpritePlayer(g2);
        player.testPrintInformation();
        opponent.testPrintInformation();

        g2.dispose();
    }

}

