package entity;

import main.GameWindow;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

import javafx.scene.image.Image;

import java.awt.image.BufferedImage;

public class bear extends Entity {

    GameWindow gameWindow;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public bear(GameWindow gameWindow, KeyHandler keyh) {

        this.gameWindow = gameWindow;
        this.keyH = keyH;

        screenX = gameWindow.width/2 - (gameWindow.tileSize/2);
        screenY = gameWindow.height/2 - (gameWindow.tileSize/2);



    }

    public void setDefaultValues() { 

        xCoordOfWorld = gameWindow.tileSize * 23;
        yCoordOfWorld = gameWindow.tileSize * 21;
        speedOf = 4;
        directionOf = "down";

    }

    public void getImageOfBear() { 

        try {
            
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/bear/down1.png"));








        } catch (IOException e) {
            
            e.printStackTrace();

        }






    }



    public void updateMovement() { 

        







    }


    public void changeSprite() {






    }



}
