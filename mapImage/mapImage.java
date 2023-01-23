package mapImage;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.BattleWindow;

import java.awt.Graphics2D;

public class mapImage {
    
   BattleWindow BattleWindow;
   public mapTile[] tile;


    public mapImage(BattleWindow BattleWindow) {

        this.BattleWindow = BattleWindow;
        tile = new mapTile[10];
        getTileImage();
    }


    public void getTileImage() { 

        try {

            tile[0] = new mapTile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/battleBackGround.png"));

            tile[1] = new mapTile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/GUI/button.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createTile(Graphics2D g2) { 

        int screenX = 0;
        int screenY = 0;
            
        g2.drawImage(tile[0].image, screenX, screenY, 1024, 576, null);
        g2.drawImage(tile[1].image, 0, 425, 525, 150, null);
        

    }
}

