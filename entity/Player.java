package entity;

import main.GameWindow;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.awt.Color;

public class Player extends Entity {
    
    GameWindow gameWindow;
    KeyHandler keyH;



    public Player(GameWindow gameWindow, KeyHandler keyH) {

        this.gameWindow = gameWindow;
        this.keyH = keyH;

        defaultValues();
    }

    public void defaultValues() {

        xCoord = 100;
        yCoord = 100;
        speedOf = 4;
    }

    // public void getImageOfPlayer() {
        
    //     try {

    //         up1 = ImageIO.read(getClass().getResourceAsStream(""));


            
    //     } catch (IOException e) {

    //         e.printStackTrace();

    //     }   
    // }

    public void update() {

        if(keyH.upPressed == true) {

            yCoord -= speedOf;
            
        }else if(keyH.downPressed == true) {

            yCoord += speedOf;

        }else if(keyH.leftPressed == true) {

            xCoord -= speedOf;

        }else if(keyH.rightPressed == true) {
            
            xCoord += speedOf;

        }

    }

    public void draw(Graphics2D g2) {

        g2.setColor(Color.red);

        g2.fillRect(xCoord, yCoord, gameWindow.tileSize, gameWindow.tileSize);
        
    }

}
