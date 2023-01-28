package mapImage;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import main.BattleWindow;

import java.awt.Graphics2D;

public class mapImage {

   //Create a new instance of battle window and tile
   BattleWindow BattleWindow;
   public mapTile[] tile;


   //Description: sets mapTile array to be of length 10 (so 10 tiles can be made available)
   //@param battleWindow
    public mapImage(BattleWindow BattleWindow) {

        this.BattleWindow = BattleWindow;
        tile = new mapTile[10];
        //call getTileImage method in the constructor to recieve the image paths for the tiles/images
        getTileImage();
    }


    //Description: this method will assign the different elements of the tile array to the individual tiles (images)
    //@param none
    public void getTileImage() { 

        
        //surround with try-catch
        try {

            //Create a new mapTile for background 1
            tile[0] = new mapTile();
            //Assign image 1
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/battleBackground.png"));

            //Create a new mapTile for background 2
            tile[1] = new mapTile();
            //Assign image 2
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/grassy.png"));
            
            //Create a new mapTile for background 3
            tile[2] = new mapTile();
            //Assign image 3
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/sandy.png"));
            
            //Create a new mapTile for background 4
            tile[3] = new mapTile();
            //Assign image 4
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/GUI/button.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Description: creates a random number to alternate between enviroments and draws the background imageand dialogue box image to the screen.
    //@param Graphics2D g2
    public void createTile(Graphics2D g2) { 

        //Initalize x and y pos
        int screenX = 0;
        int screenY = 0;

        //Create new random object of type random
        Random random = new Random();
        
        //Creates random number
        int randNum = random.nextInt(3);
        
        //Draws the image to the screen
        g2.drawImage(tile[randNum].image, screenX, screenY, 1024, 576, null);
        g2.drawImage(tile[3].image, 0, 425, 525, 150, null);
        

    }
}

