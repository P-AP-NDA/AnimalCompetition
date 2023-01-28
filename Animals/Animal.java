package Animals;

//Imports
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;

public class Animal {
    
    //Variables traits
    private String name;
    private int health;
    private int defense;
    private int attack;
    private int critChance;
    private int chanceOfSurviving;
    private int fearChance;
    private int chanceOfDodge;
    private int speed;
    private String imagePath;
    private String firstToAttack = "";

    //Create an arraylist moveset for the individual movesets of different animals
    ArrayList<Move> moveset = new ArrayList<Move>();

    private BufferedImage Image1;

    //Constructor method for the Animal class
    public Animal(int health, int defense, int attack, int critChance, int chanceOfSurviving, int fearChance, int chanceOfDodge, int speed, String name, String imagePath, String firstToAttack) {
        this.health = health;
        this.defense = defense;
        this.attack = attack;
        this.critChance = critChance;
        this.chanceOfSurviving = chanceOfSurviving;
        this.fearChance = fearChance;
        this.chanceOfDodge = chanceOfDodge;
        this.speed  = speed;
        this.name = name;
        this.imagePath = imagePath;
        this.getImage();
        this.firstToAttack = firstToAttack;
    }

    //Below are getter and setter methods that will set and return the traits of the animal.

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public int getCritChance() {
        return this.critChance;
    }

    public void setChanceOfSurviving(int chanceOfSurviving) {
        this.chanceOfSurviving = chanceOfSurviving;
    }

    public int getChanceOfSurviving() {
        return this.chanceOfSurviving;
    }

    public void setFearChance(int fearChance) {
        this.fearChance = fearChance;
    }

    public int getFearChance() {
        return this.fearChance;
    }

    public void setChanceOfDodge(int chanceOfDodge) {
        this.chanceOfDodge = chanceOfDodge;
    }

    public int getChanceOfDodge() {
        return this.chanceOfDodge;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public void setMoveList(ArrayList<Move> moves) {
        this.moveset = moves;
    }

    public ArrayList<Move> getMoveList() {
        return moveset;
    }

    public void setFirstToAttack(String firstToAttack) {
        this.firstToAttack = firstToAttack;
    }
    public String getFirstToAttack() {
        return this.firstToAttack;
    }

    //This method is going to print the battle information to the console
    public void testPrintInformation() {

        System.out.println(this.name+":");
        System.out.println("Health: " + this.health + "\n" + "defense: " + this.defense + "\n" + "attack: " + this.attack + "\n") ;
        System.out.println("Speed: " + this.speed + "\n" + "CritcalChance: " + this.critChance + "\n" + "Chance of Dodge: " + this.chanceOfDodge);
        System.out.println("Chance Of Suriving: " + this.chanceOfSurviving + "\n" + "fear chance: " + this.fearChance);
        System.out.println(this.moveset);

    }

    // Description: draws the sprite of the players animal
    // @params: Graphics2D g2
    public void drawSpritePlayer(Graphics2D g2) {


        g2.drawImage(this.Image1, 170, 200, 200, 200, null);


    }

    // Description: draws the sprite of the opponents animal
    // @params: Graphics2D g2
    public void drawSpriteOpponent(Graphics2D g2) {

        //Draw image
        g2.drawImage(this.Image1, 740, 30, 200, 200, null);


    }


    //Description: this method will get the image of the animal sprites (that are passed into the animal object)
    public void getImage() {

        try {
            //get image
            this.Image1 = ImageIO.read(getClass().getResourceAsStream(this.imagePath));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Description: get random move by a given name of type String
    // @params: moveName: String
    // @returns: object of type Move

    public Move getMoveByName(String moveName) {

        for(int i = 0; i < this.moveset.size(); i++) {
            
            if(this.moveset.get(i).getMoveName() == moveName) {
                return this.moveset.get(i);
            }
        }
        return null;

    }

    // Description: get a random move by using a random index value
    // @returns: object of type Move

    public Move getRandomMove() {

        int min = 0;
        int max = 3;
        int random_index = (int)Math.floor(Math.random() * (max - min + 1) + min);

        return this.moveset.get(random_index);
    }
    
    public void eraseOpponentSprite(Graphics2D g2) {

        g2.drawImage(null, 740, 30, 200, 200, null);
        
    }

}
