package main;

//Imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JPanel;
import Animals.Animal;
import mapImage.mapImage;
import Animals.Move;


public class BattleWindow extends JPanel implements Runnable {
    
    //Variables for screen
    public final int tileSizeOrginal = 16;
    final int scale = 3;

    public final int imageHeight = 576;
    public final int imageWidth = 768;
    public final int columns = 16;
    public final int rows = 12;
    public final int width  = 1024;
    public final int height = 576;

    public final int maxColumnsWorld = 90;
    public final int maxRowsWorld = 90;

    //Create opponent and player of type animal. Initialize new mapImage
    mapImage mImage = new mapImage(this);
    Animal opponent = getRandomOpponent();
    Animal player = getRandomPlayer();

    //Set up dimensions and logistics of the game window.
    public BattleWindow() {

        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        

    }

    // Description: the first attack sequence between the two animals (player animal and opponent animal). This is going to determine a random animal for the opponent.
    // @returns: Random opponent of type Animal 

    public Animal getRandomOpponent() {

        //initialize bee and it's moveset by putting each move of type Move into an ArrayList

        Animal bee = new Animal(300, 200, 300, 10, 30, 10, 7, 56, "Bee", "/res/AnimalImages/bee.png", "");
        Move beeMove1 = new Move("Damage", "Bite", "", 30, 0);
        Move beeMove2 = new Move("Trait Change", "Buzz", "ChanceOfDodge", 0, 10);
        Move beeMove3 = new Move("Damage", "Sting", "", 30, 0);
        Move beeMove4 = new Move("Trait Change", "Fly", "Speed", 30, 5);
        
        //Create arraylist of beeMoves
        ArrayList<Move> beeMoves = new ArrayList<Move>();

        //Add beeMoves
        beeMoves.add(beeMove1);
        beeMoves.add(beeMove2);
        beeMoves.add(beeMove3);
        beeMoves.add(beeMove4);
        bee.setMoveList(beeMoves); //set movelist


        //initialize bear and it's moveset by putting each move of type Move into an ArrayList
        Animal bear = new Animal(500, 200, 400, 10, 10, 10, 3, 2, "Bear", "/res/AnimalImages/bear.png", "");

        Move bearMove1 = new Move("Damage", "Claw", "", 40, 0);
        Move bearMove2 = new Move("Damage", "Slash", "", 20, 0);
        Move bearMove3 = new Move("Damage", "Tackle", "", 15, 0);
        Move bearMove4 = new Move("Damage", "Bite", "", 30, 0);

        //Create arraylist of bearmoves
        ArrayList<Move> bearMoves = new ArrayList<Move>();

        //Add bearMoves
        bearMoves.add(bearMove1);
        bearMoves.add(bearMove2);
        bearMoves.add(bearMove3);
        bearMoves.add(bearMove4);
        bear.setMoveList(bearMoves); //set movelist

        //initialize snake and it's moveset by putting each move of type Move into an ArrayList
        Animal snake = new Animal(500, 200, 400, 10, 10, 10, 5, 3, "Snake", "/res/AnimalImages/snake.png", "");

        Move snakeMove1 = new Move("Damage", "Constrict", "", 5, 0);
        Move snakeMove2 = new Move("Damage", "Venom Strike", "", 15, 0);
        Move snakeMove3 = new Move("Trait Change", "Snake Dance", "Speed", 0, 7);
        Move snakeMove4 = new Move("Damage", "Bite", "Speed", 30, 0);

        //Create arraylist of snakemoves
        ArrayList<Move> snakeMoves = new ArrayList<Move>();
        
        //Add snakeMoves
        snakeMoves.add(snakeMove1);
        snakeMoves.add(snakeMove2);
        snakeMoves.add(snakeMove3);
        snakeMoves.add(snakeMove4);
        snake.setMoveList(snakeMoves); //set movelist

        //initialize elephant and it's moveset by putting each move of type Move into an ArrayList
        Animal elephant = new Animal(250, 300, 350, 20, 10, 10, 10, 10, "Elephant", "/res/AnimalImages/elephant.png", "");
        Move elephantMove1 = new Move("Damage", "Stomp", "", 40, 0);
        Move elephantMove2 = new Move("Damage", "Stampede", "", 50, 0);
        Move elephantMove3 = new Move("Trait Change", "Elephant Dance", "Speed", 0, 7);
        Move elephantMove4 = new Move("Damage", "Horn Charge", "Speed", 70, 0);

        //Create arraylist of elephantmoves
        ArrayList<Move> elephantMoves = new ArrayList<Move>();
        
        //Add elephantMoves
        elephantMoves.add(elephantMove1);
        elephantMoves.add(elephantMove2);
        elephantMoves.add(elephantMove3);
        elephantMoves.add(elephantMove4);
        elephant.setMoveList(elephantMoves); //set movelist

        //initialize an arraylist of all animals
        ArrayList<Animal> animals = new ArrayList<Animal>();
        animals.add(bee); //add bee, bear, snake, elephant
        animals.add(bear);
        animals.add(snake);
        animals.add(elephant);


        int min = 0; // min of range
        int max = 3; // max of range
        int random_index = (int)Math.floor(Math.random() * (max - min + 1) + min); //get random value between 0 and 3

        return animals.get(random_index); // return random animal from the array

    }

    // Description: the first attack sequence between the two animals (player animal and opponent animal). This is going to determine a random animal for the player.
    // @returns: Random player of type Animal 
    public Animal getRandomPlayer() {
        
        //initialize bee and it's moveset by putting each move of type Move into an ArrayList
        Animal bee = new Animal(300, 200, 300, 10, 30, 10, 5, 56, "Bee", "/res/AnimalImages/bee.png", "");
        Move beeMove1 = new Move("Damage", "Bite", "", 30, 0);
        Move beeMove2 = new Move("Trait Change", "Buzz", "ChanceOfDodge", 0, 10);
        Move beeMove3 = new Move("Damage", "Sting", "", 30, 0);
        Move beeMove4 = new Move("Trait Change", "Fly", "Speed", 30, 5);
        
        ArrayList<Move> beeMoves = new ArrayList<Move>();

        beeMoves.add(beeMove1);
        beeMoves.add(beeMove2);
        beeMoves.add(beeMove3);
        beeMoves.add(beeMove4);
        bee.setMoveList(beeMoves); //set movelist

        //initialize bear and it's moveset by putting each move of type Move into an ArrayList
        Animal bear = new Animal(500, 200, 400, 10, 10, 10, 4, 55, "Bear", "/res/AnimalImages/bear.png", "");

        Move bearMove1 = new Move("Damage", "Claw", "", 40, 0);
        Move bearMove2 = new Move("Damage", "Slash", "", 20, 0);
        Move bearMove3 = new Move("Damage", "Tackle", "", 15, 0);
        Move bearMove4 = new Move("Damage", "Bite", "", 30, 0);

        ArrayList<Move> bearMoves = new ArrayList<Move>();

        bearMoves.add(bearMove1);
        bearMoves.add(bearMove2);
        bearMoves.add(bearMove3);
        bearMoves.add(bearMove4);
        bear.setMoveList(bearMoves); //set movelist

        //initialize snake and it's moveset by putting each move of type Move into an ArrayList
        Animal snake = new Animal(500, 200, 400, 10, 10, 10, 2, 55, "Snake", "/res/AnimalImages/snake.png", "");

        Move snakeMove1 = new Move("Damage", "Constrict", "", 5, 0);
        Move snakeMove2 = new Move("Damage", "Venom Strike", "", 15, 0);
        Move snakeMove3 = new Move("Trait Change", "Snake Dance", "Speed", 0, 7);
        Move snakeMove4 = new Move("Damage", "Bite", "Speed", 30, 0);

        //Create an arraylist of snakemoves
        ArrayList<Move> snakeMoves = new ArrayList<Move>();
        
        //Addd snakeMoves
        snakeMoves.add(snakeMove1);
        snakeMoves.add(snakeMove2);
        snakeMoves.add(snakeMove3);
        snakeMoves.add(snakeMove4);

        snake.setMoveList(snakeMoves); //set movelist
        //initialize elephant and it's moveset by putting each move of type Move into an ArrayList
        Animal elephant = new Animal(250, 300, 350, 20, 10, 10, 10, 10, "Elephant", "/res/AnimalImages/elephant.png", "");
        Move elephantMove1 = new Move("Damage", "Stomp", "", 40, 0);
        Move elephantMove2 = new Move("Damage", "Stampede", "", 50, 0);
        Move elephantMove3 = new Move("Trait Change", "Elephant Dance", "Speed", 0, 7);
        Move elephantMove4 = new Move("Damage", "Horn Charge", "Speed", 70, 0);

        //Create an arraylist of elephant moves
        ArrayList<Move> elephantMoves = new ArrayList<Move>();
        //Add elephantMoves
        elephantMoves.add(elephantMove1);
        elephantMoves.add(elephantMove2);
        elephantMoves.add(elephantMove3);
        elephantMoves.add(elephantMove4);
        elephant.setMoveList(elephantMoves); //set movelist

        ArrayList<Animal> animals = new ArrayList<Animal>(); //initialize an arraylist of animals
        //add bee, bear, snake, elephant
        animals.add(bee); 
        animals.add(bear);
        animals.add(snake);
        animals.add(elephant);


        int min = 0; // min of range
        int max = 3; // max of range
        int random_index = (int)Math.floor(Math.random() * (max - min + 1) + min); //get randiom value between 0 and 3

        return animals.get(random_index); //return random animal from the list

    }

    @Override
    public void run() {

    }


    public void update(){

    }

    //Description: this method is going to draw the sprite of the player and the opponent to the screen as well as paint the background.
    //@param: Graphics g
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;

        mImage.createTile(g2); //paint background
        opponent.drawSpriteOpponent(g2); // paint the sprites
        player.drawSpritePlayer(g2); // paint the sprites

        g2.dispose();
    }

}

