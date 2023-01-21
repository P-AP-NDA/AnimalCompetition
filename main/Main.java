package main;

import javax.swing.JFrame;
import main.KeyHandler;


public class Main {

    public static void main(String[] args){

        JFrame screen = new JFrame();
        JFrame battleScreen = new JFrame();

        battleScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        battleScreen.setResizable(false);
        battleScreen.setTitle("battle");

        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.setTitle("game");

        GameWindow gameWindow = new GameWindow();
        battleScreen bScreen = new battleScreen();

        screen.add(gameWindow);
        battleScreen.add(bScreen);

        screen.pack();
        battleScreen.pack();

        screen.setLocationRelativeTo(null);
        screen.setVisible(false); 

        battleScreen.setLocationRelativeTo(null);
        battleScreen.setVisible(true);

        gameWindow.startGameThread();
        bScreen.startGameThread();



        }
}