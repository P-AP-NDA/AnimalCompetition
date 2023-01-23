package Animals;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;

public class Animal {
    
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

    ArrayList<String> moveset = new ArrayList<String>();

    private BufferedImage Image1;

    public Animal(int health, int defense, int attack, int critChance, int chanceOfSurviving, int fearChance, int chanceOfDodge, int speed, String name, String imagePath) {
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
    }

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

    public void setMoveList(ArrayList<String> moves) {
        this.moveset = moves;
    }

    public ArrayList<String> getMoveList() {
        return moveset;
    }

    public void testPrintInformation() {

        System.out.println(this.name+":");
        System.out.println("Health: " + this.health + "\n" + "defense: " + this.defense + "\n" + "attack: " + this.attack + "\n") ;
        System.out.println("Speed: " + this.speed + "\n" + "CritcalChance: " + this.critChance + "\n" + "Chance of Dodge: " + this.chanceOfDodge);
        System.out.println("Chance Of Suriving: " + this.chanceOfSurviving + "\n" + "fear chance: " + this.fearChance);
        System.out.println(this.moveset);

    }

    public void drawSpritePlayer(Graphics2D g2) {


        g2.drawImage(this.Image1, 170, 200, 200, 200, null);


    }

    public void drawSpriteOpponent(Graphics2D g2) {


        g2.drawImage(this.Image1, 740, 30, 200, 200, null);


    }

    public void getImage() {

        try {
            this.Image1 = ImageIO.read(getClass().getResourceAsStream(this.imagePath));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
