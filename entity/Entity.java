package entity;

import java.awt.image.BufferedImage;

public class Entity {
    
    public int xCoord, yCoord;
    public int speedOf;

    public BufferedImage up1, up2, up3, down1, down2, down3, right1, right2, left1, left2;
    public String directionOf;

    public int countSprites = 0;
    public int spriteNumber = 1;
}
