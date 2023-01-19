package main;

import entity.Entity;

public class checkCollision {

    GameWindow gw;


    public checkCollision(GameWindow gw) {

        this.gw = gw;



    }


    public void checkTile(Entity entity) {

        int entityLeftWorldX = entity.xCoordOfWorld + entity.area.x;
        int entityRightWorldX = entity.xCoordOfWorld + entity.area.x + entity.area.width;
        int entityTopWorldY = entity.yCoordOfWorld + entity.area.y;
        int entityBottomWorldY = entity.yCoordOfWorld + entity.area.y + entity.area.height;

        int entityLeftCol = entityLeftWorldX/gw.tileSize;
        int entityRightCol = entityRightWorldX/gw.tileSize;
        int entityTopRow = entityTopWorldY/gw.tileSize;
        int entityBottomRow = entityTopWorldY/gw.tileSize;

        int tileNum1, tileNum2;

        switch(entity.directionOf) {

            case "up":
                entityTopRow = (entityTopWorldY - entity.speedOf)/gw.tileSize;
                tileNum1 = gw.gametileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gw.gametileM.mapTileNum[entityRightCol][entityTopRow];

                if(gw.gametileM.tile[tileNum1].collision == true || gw.gametileM.tile[tileNum2].collision == true) {
                    entity.isColliding = true;
                }
                break;

            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speedOf)/gw.tileSize;
                tileNum1 = gw.gametileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gw.gametileM.mapTileNum[entityRightCol][entityBottomRow];

                if(gw.gametileM.tile[tileNum1].collision == true || gw.gametileM.tile[tileNum2].collision == true) {
                    entity.isColliding = true;
                }
                break;

            case "right":
                entityRightCol = (entityRightWorldX + entity.speedOf)/gw.tileSize;
                tileNum1 = gw.gametileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gw.gametileM.mapTileNum[entityRightCol][entityBottomRow];

                if(gw.gametileM.tile[tileNum1].collision == true || gw.gametileM.tile[tileNum2].collision == true) {
                    entity.isColliding = true;
                }
                break;

            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speedOf)/gw.tileSize;
                tileNum1 = gw.gametileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gw.gametileM.mapTileNum[entityLeftCol][entityBottomRow];

                if(gw.gametileM.tile[tileNum1].collision == true || gw.gametileM.tile[tileNum2].collision == true) {
                    entity.isColliding = true;
                }
                break;







        }


    }


    public void checkTeleport(Entity entity) {










    }
    
}
