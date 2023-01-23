package main;


import java.awt.GridLayout;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javax.swing.*;
import java.awt.CardLayout;
import main.MouseListener;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener{


    public GUI() {

        JFrame screen = new JFrame();
        JPanel panelCont = new JPanel();
        JPanel movesetPanel = new JPanel();
        JPanel attributesPanel = new JPanel();
        JPanel playerHealthPanel = new JPanel();
        JPanel opponentHealthPanel = new JPanel();
        screen.setResizable(false);
        screen.setTitle("game");
        BattleWindow battleWindow = new BattleWindow();
        CardLayout cardLayout = new CardLayout();
        GridLayout movesLayout = new GridLayout(2,3);
        GridLayout attributesLayout = new GridLayout(7, 2);

        JButton attack1button = new JButton(battleWindow.player.getMoveList().get(0));
        JButton attack2button = new JButton(battleWindow.player.getMoveList().get(1));
        JButton attack3button = new JButton(battleWindow.player.getMoveList().get(2));
        JButton attack4button = new JButton(battleWindow.player.getMoveList().get(3));
        JLabel healthPlayer = new JLabel("Health: "+battleWindow.player.getHealth());
        JLabel healthOpponent = new JLabel("Health: "+battleWindow.opponent.getHealth());
        JLabel defense = new JLabel("Defense: "+battleWindow.player.getDefense());
        JLabel attack = new JLabel("Attack: "+battleWindow.player.getAttack());
        JLabel speed = new JLabel("Speed: "+battleWindow.player.getSpeed());
        JLabel critChance = new JLabel("Crit Chance: "+battleWindow.player.getCritChance());
        JLabel chanceOfDodge = new JLabel("Chance Of Dodge: "+battleWindow.player.getChanceOfDodge());
        JLabel chanceOfSurviving = new JLabel("Chance Of Surviving: "+battleWindow.player.getChanceOfSurviving());
        JLabel fearChance = new JLabel("Fear Chance: "+battleWindow.player.getFearChance());
        JLabel dialogueBox = new JLabel("");
    


        attack1button.addActionListener(e -> dialogueBox.setText(battleWindow.player.getName() + " used " + battleWindow.player.getMoveList().get(0)));
        attack2button.addActionListener(e -> dialogueBox.setText(battleWindow.player.getName() + " used " + battleWindow.player.getMoveList().get(1)));
        attack3button.addActionListener(e -> dialogueBox.setText(battleWindow.player.getName() + " used " + battleWindow.player.getMoveList().get(2)));
        attack4button.addActionListener(e -> dialogueBox.setText(battleWindow.player.getName() + " used " + battleWindow.player.getMoveList().get(3)));
        

        panelCont.setLayout(cardLayout);
        //panelCont.add(gameWindow, "1");
        panelCont.add(battleWindow, "2");
            cardLayout.show(panelCont, "1");
            movesetPanel.setSize(300, 150);
            movesetPanel.add(attack1button);
            movesetPanel.add(attack2button);
            movesetPanel.add(attack3button);
            movesetPanel.add(attack4button);
            movesetPanel.setLayout(movesLayout);
            attributesPanel.add(defense);
            attributesPanel.add(attack);
            attributesPanel.add(speed);
            attributesPanel.add(critChance);
            attributesPanel.add(chanceOfDodge);
            attributesPanel.add(chanceOfSurviving);
            attributesPanel.add(fearChance);
            attributesPanel.setLayout(attributesLayout);
            screen.add(movesetPanel);
            movesetPanel.setLocation(724, 426);
            screen.add(attributesPanel);
            screen.add(dialogueBox);
            dialogueBox.setSize(150, 100);
            dialogueBox.setLocation(190, 460);
            attributesPanel.setSize(200, 150);
            attributesPanel.setLocation(525, 425);
            screen.add(playerHealthPanel);
            screen.add(opponentHealthPanel);
            playerHealthPanel.add(healthPlayer);
            opponentHealthPanel.add(healthOpponent);
            playerHealthPanel.setSize(100, 30);
            playerHealthPanel.setLocation(75, 150);
            opponentHealthPanel.setSize(100, 30);
            opponentHealthPanel.setLocation(600, 50);
            screen.add(panelCont);
            screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            screen.pack();
            screen.setLocationRelativeTo(null);
            screen.setVisible(true);

    }

    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}

