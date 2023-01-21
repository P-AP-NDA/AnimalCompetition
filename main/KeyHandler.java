package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, qPressed, rPressed;
    public boolean shiftPressed;
    public boolean testKeyPress;

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_UP) {

            upPressed = true;

        }else if(keyCode == KeyEvent.VK_DOWN) {

            downPressed = true;

        }else if(keyCode == KeyEvent.VK_RIGHT) {

            rightPressed = true;

        }else if(keyCode == KeyEvent.VK_LEFT) {

            leftPressed = true;

        }
        else if(keyCode == KeyEvent.VK_SHIFT) { 

            shiftPressed = true;
            
        }
        else if(keyCode == KeyEvent.VK_Q) {

            testKeyPress = true;

        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_UP) {

            upPressed = false;

        }else if(keyCode == KeyEvent.VK_DOWN) { 

            downPressed = false;

        }else if(keyCode == KeyEvent.VK_RIGHT) {

            rightPressed = false;

        }else if(keyCode == KeyEvent.VK_LEFT) {

            leftPressed = false;

        }else if(keyCode == KeyEvent.VK_SHIFT) { 

            shiftPressed = false;

        }
        else if(keyCode == KeyEvent.VK_R) {

            testKeyPress = false;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        System.out.println("A key has been pressed");

    }
    
}
