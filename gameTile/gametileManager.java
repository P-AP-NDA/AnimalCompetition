package gameTile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;


import main.GameWindow;

import java.awt.Graphics2D;

public class gametileManager {
    
    GameWindow gameWindow;
   public gametile[] tile;
   public int mapTileNum[][];


    public gametileManager(GameWindow gameWindow) {

        this.gameWindow = gameWindow;

        tile = new gametile[10];
        mapTileNum = new int[gameWindow.maxColumnsWorld][gameWindow.maxRowsWorld];
        getTileImage();
        mapLoading("/res/gameMaps/worldmap.txt");
    }


    public void getTileImage() { 

        try {

            tile[0] = new gametile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/grass.png"));

            tile[1] = new gametile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/water.png"));
            tile[1].collision = true;

            tile[2] = new gametile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tree.png"));
            tile[2].collision = true;

            tile[3] = new gametile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/teleporter.png"));
            tile[3].collision = true;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void mapLoading(String filePath) { 

        try {
            
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gameWindow.maxColumnsWorld && row < gameWindow.maxRowsWorld) { 

                String line = br.readLine();

                while(col < gameWindow.maxColumnsWorld) { 
                    String numbersOf[] = line.split(" ");

                    int num = Integer.parseInt(numbersOf[col]);

                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gameWindow.maxColumnsWorld) { 
                    col = 0;
                    row++;
                }
            }
            br.close();


        } catch (Exception e) {
            
        }
    }

    public void createTile(Graphics2D g2) { 

        int worldColumns = 0;
        int worldRow = 0;
        //boolean onMap1 = false;

        while(worldColumns < gameWindow.maxColumnsWorld && worldRow < gameWindow.maxRowsWorld) {

            int tileNum = mapTileNum[worldColumns][worldRow];

            int worldX = worldColumns * gameWindow.tileSize;
            int worldY = worldRow * gameWindow.tileSize;
            int screenX = worldX - gameWindow.player.xCoordOfWorld + gameWindow.player.screenX;
            int screenY = worldY - gameWindow.player.yCoordOfWorld + gameWindow.player.screenY;
            
            if(worldX + gameWindow.tileSize > gameWindow.player.xCoordOfWorld - gameWindow.player.screenX &&
               worldX - gameWindow.tileSize < gameWindow.player.xCoordOfWorld + gameWindow.player.screenX &&
               worldY + gameWindow.tileSize > gameWindow.player.yCoordOfWorld - gameWindow.player.screenY &&
               worldY - gameWindow.tileSize < gameWindow.player.yCoordOfWorld + gameWindow.player.screenY) { 
                g2.drawImage(tile[tileNum].image, screenX, screenY, gameWindow.tileSize, gameWindow.tileSize, null);
            }
            worldColumns++;
          

            if(worldColumns == gameWindow.maxColumnsWorld) { 
                worldColumns = 0;
                worldRow++;
          

            }
        }

    }
}
