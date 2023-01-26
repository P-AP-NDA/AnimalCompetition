package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Graphics;
import main.GUI;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.util.Random;
import Animals.Animal;
import mapImage.mapImage;
import Animals.Move;


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
        Move beeMove1 = new Move("Damage", "Bite", "", 30, 0);
        Move beeMove2 = new Move("Trait Change", "Buzz", "Chance Of Dodge", 0, 10);
        Move beeMove3 = new Move("Damage", "Sting", "", 30, 0);
        Move beeMove4 = new Move("Trait Change", "Fly", "Speed", 30, 5);
        
        ArrayList<Move> beeMoves = new ArrayList<Move>();

        beeMoves.add(beeMove1);
        beeMoves.add(beeMove2);
        beeMoves.add(beeMove3);
        beeMoves.add(beeMove4);
        bee.setMoveList(beeMoves);

        Animal bear = new Animal(500, 200, 400, 10, 10, 40, 0, 2, "Bear", "/res/AnimalImages/bear.png");

        Move bearMove1 = new Move("Damage", "Claw", "", 40, 0);
        Move bearMove2 = new Move("Damage", "Slash", "", 20, 0);
        Move bearMove3 = new Move("Damage", "Tackle", "", 15, 0);
        Move bearMove4 = new Move("Damage", "Bite", "", 30, 0);

        ArrayList<Move> bearMoves = new ArrayList<Move>();

        bearMoves.add(bearMove1);
        bearMoves.add(bearMove2);
        bearMoves.add(bearMove3);
        bearMoves.add(bearMove4);
        bear.setMoveList(bearMoves);

        Animal snake = new Animal(500, 200, 400, 10, 10, 40, 0, 2, "Snake", "/res/AnimalImages/snake.png");

        Move snakeMove1 = new Move("Damage", "Constrict", "", 5, 0);
        Move snakeMove2 = new Move("Damage", "Venom Strike", "", 15, 0);
        Move snakeMove3 = new Move("Trait Change", "Snake Dance", "Speed", 0, 7);
        Move snakeMove4 = new Move("Damage", "Bite", "Speed", 30, 0);


        ArrayList<Move> snakeMoves = new ArrayList<Move>();
        
        snakeMoves.add(snakeMove1);
        snakeMoves.add(snakeMove2);
        snakeMoves.add(snakeMove3);
        snakeMoves.add(snakeMove4);

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
        Move beeMove1 = new Move("Damage", "Bite", "", 30, 0);
        Move beeMove2 = new Move("Trait Change", "Buzz", "Chance Of Dodge", 0, 10);
        Move beeMove3 = new Move("Damage", "Sting", "", 30, 0);
        Move beeMove4 = new Move("Trait Change", "Fly", "Speed", 30, 5);
        
        ArrayList<Move> beeMoves = new ArrayList<Move>();

        beeMoves.add(beeMove1);
        beeMoves.add(beeMove2);
        beeMoves.add(beeMove3);
        beeMoves.add(beeMove4);
        bee.setMoveList(beeMoves);

        Animal bear = new Animal(500, 200, 400, 10, 10, 40, 0, 2, "Bear", "/res/AnimalImages/bear.png");

        Move bearMove1 = new Move("Damage", "Claw", "", 40, 0);
        Move bearMove2 = new Move("Damage", "Slash", "", 20, 0);
        Move bearMove3 = new Move("Damage", "Tackle", "", 15, 0);
        Move bearMove4 = new Move("Damage", "Bite", "", 30, 0);

        ArrayList<Move> bearMoves = new ArrayList<Move>();

        bearMoves.add(bearMove1);
        bearMoves.add(bearMove2);
        bearMoves.add(bearMove3);
        bearMoves.add(bearMove4);
        bear.setMoveList(bearMoves);

        Animal snake = new Animal(500, 200, 400, 10, 10, 40, 0, 2, "Snake", "/res/AnimalImages/snake.png");

        Move snakeMove1 = new Move("Damage", "Constrict", "", 5, 0);
        Move snakeMove2 = new Move("Damage", "Venom Strike", "", 15, 0);
        Move snakeMove3 = new Move("Trait Change", "Snake Dance", "Speed", 0, 7);
        Move snakeMove4 = new Move("Damage", "Bite", "Speed", 30, 0);


        ArrayList<Move> snakeMoves = new ArrayList<Move>();
        
        snakeMoves.add(snakeMove1);
        snakeMoves.add(snakeMove2);
        snakeMoves.add(snakeMove3);
        snakeMoves.add(snakeMove4);

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

