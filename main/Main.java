package main;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args){

        JFrame screen = new JFrame();

        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setResizable(false);
        screen.setTitle("game");

        GameWindow gameWindow = new GameWindow();

        screen.add(gameWindow);

        screen.pack();

        screen.setLocationRelativeTo(null);
        screen.setVisible(true); 

        gameWindow.startGameThread();

        }
}