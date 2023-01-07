package entity;

import main.GameWindow;
import main.KeyHandler;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class Player extends Entity {
    
    GameWindow gameWindow;
    KeyHandler keyH;


    public Player(GameWindow gameWindow, KeyHandler keyH) {

        this.gameWindow = gameWindow;
        this.keyH = keyH;

        defaultValues();
        getImageOfPlayer();
    }

    public void defaultValues() {

        xCoord = 100;
        yCoord = 100;
        speedOf = 4;
        directionOf = "down";
    }

    public void getImageOfPlayer() {

        
        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/up2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/up3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/down2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/down3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/right2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/left2.png"));
            

            
        } catch (IOException e) {

            e.printStackTrace();

        }   
    }

    public void update() {

        //KeyPressed boolean var to check if the key is currently being pressed - used for stopping sprite animation if player is not currently moving
        //isRightOrLeft boolean var to check if player is facing left or right- used to fix glitchy animation when moving left or right b/c of uneven asset number
        boolean keyPressed = false;
        boolean isRightOrLeft = false;

        if(keyH.upPressed == true) {

            yCoord -= speedOf;
            directionOf = "up";
            keyPressed = true;
            
        }else if(keyH.downPressed == true) {

            yCoord += speedOf;
            directionOf = "down";
            keyPressed = true;

        }else if(keyH.leftPressed == true) {

            xCoord -= speedOf;
            directionOf = "left";
            keyPressed = true;

        }else if(keyH.rightPressed == true) {
            
            xCoord += speedOf;
            directionOf = "right";
            keyPressed = true;

        }

        
        //If player is facing left or right, set isRightOrLeft to be true - (to account for uneven number of sprites thus a glitchy appearence when moving right or left)
        if(directionOf.equals("right") || directionOf.equals("left")) {
            isRightOrLeft = true;
        }

        if(keyPressed == true) {

        countSprites++;
        if(countSprites > 10 - speedOf) {
            if(spriteNumber == 1) {
                spriteNumber = 2;
            }
            else if(spriteNumber == 2 && isRightOrLeft == false) {
                spriteNumber = 3;
            }
            else if(spriteNumber == 2) {
                spriteNumber = 1;
            }
            else if(spriteNumber == 3) {
                spriteNumber = 1;
            }

            countSprites = 0;
        }

        }

        //Default asset when stopped
        if(keyPressed == false) {
            if(directionOf.equals("up")) {
                spriteNumber = 1;
            }
            if(directionOf.equals("down")) {
                spriteNumber = 1;
            }
            if(directionOf.equals("right")) {
                spriteNumber = 1;
            }
            if(directionOf.equals("left")) {
                spriteNumber = 1;
            }
        }
        
    }

    public void changeSprite(Graphics2D g2) {

        BufferedImage sprite = null;

        switch(directionOf) {

            case "down":
                if(spriteNumber == 1) {
                    sprite = down1;
                }
                if(spriteNumber == 2) {
                    sprite = down2;
                }
                if(spriteNumber == 3) {
                    sprite = down3;
                }
                break;
                
            case "up":
                if(spriteNumber == 1) {
                    sprite = up1;
                }
                if(spriteNumber == 2) {
                    sprite = up2;
                }
                if(spriteNumber == 3) {
                    sprite = up3;
                }
                break;

            case "right":
                if(spriteNumber == 1) {
                    sprite = right1;
                }
                if(spriteNumber == 2) {
                    sprite = right2;
                }
                break;

            case "left":
                if(spriteNumber == 1) {
                    sprite = left1;
                }
                if(spriteNumber == 2) {
                    sprite = left2;
                }
                break;
            
        }

        g2.drawImage(sprite, xCoord, yCoord, gameWindow.tileSize, gameWindow.tileSize, null);
        
    }

}
