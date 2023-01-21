package entity;

import java.awt.image.BufferedImage;

import java.awt.Rectangle;

public class Entity {
    
    public int xCoordOfWorld, yCoordOfWorld;
    public int bearXCoord, bearYCoord;
    public int speedOf;

    public BufferedImage up1, up2, up3, down1, down2, down3, right1, right2, left1, left2;
    public String directionOf;

    public int countSprites = 0;
    public int spriteNumber = 1;

    public Rectangle area;
    public boolean isColliding = false;
}
