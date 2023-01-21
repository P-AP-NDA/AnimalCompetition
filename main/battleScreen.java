package main;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class battleScreen extends JPanel implements Runnable{

    public final int tileSizeOrginal = 16;
    final int scale = 3;

    public final int tileSize = tileSizeOrginal * scale;
    public final int columns = 16;
    public final int rows = 12;
    public final int width  = tileSize * columns;
    public final int height = tileSize * rows;

    Thread gameThread;
    

    public battleScreen() {

        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }





    @Override
    public void run() {
        
        
    }
    
}
