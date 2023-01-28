package main;

//Imports
import java.awt.GridLayout;
import javax.swing.*;
import java.lang.Math;
import Animals.Animal;
import java.util.Timer;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.TimerTask;

import Animals.Move;

public class GUI extends JFrame implements ActionListener {
    

    BattleWindow battleWindow = new BattleWindow(); //initiate battleWindow


    // 4 buttons for each move of the animals
    JButton attack1button = new JButton(battleWindow.player.getMoveList().get(0).getMoveName());
    JButton attack2button = new JButton(battleWindow.player.getMoveList().get(1).getMoveName());
    JButton attack3button = new JButton(battleWindow.player.getMoveList().get(2).getMoveName());
    JButton attack4button = new JButton(battleWindow.player.getMoveList().get(3).getMoveName());

    //player's health and opponent's health labels
    JLabel healthOpponent = new JLabel("Health: "+battleWindow.opponent.getHealth());
    JLabel healthPlayer = new JLabel("Health: "+battleWindow.player.getHealth());

    //player's traits and stats
    JLabel speed = new JLabel("Speed: "+battleWindow.player.getSpeed());
    JLabel dialogueBox = new JLabel("");
    JLabel defense = new JLabel("Defense: "+battleWindow.player.getDefense());
    JLabel attack = new JLabel("Attack: "+battleWindow.player.getAttack());
    JLabel critChance = new JLabel("Crit Chance: "+battleWindow.player.getCritChance());
    JLabel chanceOfDodge = new JLabel("Chance Of Dodge: "+battleWindow.player.getChanceOfDodge());
    JLabel chanceOfSurviving = new JLabel("Chance Of Surviving: "+battleWindow.player.getChanceOfSurviving());
    JLabel fearChance = new JLabel("Fear Chance: "+battleWindow.player.getFearChance());

    //Constructor method for class GUI
    public GUI() {

        JFrame screen = new JFrame();
        JPanel panelCont = new JPanel();
        JPanel movesetPanel = new JPanel();
        JPanel attributesPanel = new JPanel();
        JPanel playerHealthPanel = new JPanel();
        JPanel opponentHealthPanel = new JPanel();
        screen.setResizable(false);
        screen.setTitle("game");
        CardLayout cardLayout = new CardLayout();
        GridLayout movesLayout = new GridLayout(2,3);
        GridLayout attributesLayout = new GridLayout(7, 2);
        
        
    


        attack1button.addActionListener(this);
        attack2button.addActionListener(this);
        attack3button.addActionListener(this);
        attack4button.addActionListener(this);

        panelCont.setLayout(cardLayout);
        //panelCont.add(gameWindow, "1");
        panelCont.add(battleWindow, "2");
            cardLayout.show(panelCont, "1");
            movesetPanel.setSize(300, 150);
            movesetPanel.add(attack1button); // add buttons to the movesetPanel
            movesetPanel.add(attack2button);
            movesetPanel.add(attack3button);
            movesetPanel.add(attack4button);
            movesetPanel.setLayout(movesLayout);
            attributesPanel.add(defense);
            attributesPanel.add(attack);  // add the traits to attributesPanel
            attributesPanel.add(speed);
            attributesPanel.add(critChance);
            attributesPanel.add(chanceOfDodge);
            attributesPanel.add(chanceOfSurviving);
            attributesPanel.add(fearChance);
            attributesPanel.setLayout(attributesLayout);
            screen.add(movesetPanel);
            movesetPanel.setLocation(724, 426);
            screen.add(attributesPanel); // add it to screen, set size, and set position
            screen.add(dialogueBox);
            dialogueBox.setSize(300, 300);
            dialogueBox.setLocation(160, 360);
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
    // Description: the first attack sequence between the two animals
    // @params: player: Type Animal
    //          opponent: Type Animal
    //          move: Type String

    public void attackFirst(Animal player, Animal opponent, String move) {
        Move movePlayer;   //initialize movePlayer and moveOpponent of Type Move
        Move moveOpponent;

        
        int critMultiplier = 2;

        if (player.getSpeed() >= opponent.getSpeed()) { // check who has the greater speed to determine who attacks first
            player.setFirstToAttack("Yes");
            opponent.setFirstToAttack("No");
            boolean critVal = new Random().nextInt(100) < player.getCritChance();    // algorithm to determine chance of certain traits occuring
            boolean dodgeValOpp = new Random().nextInt(100) < opponent.getChanceOfDodge();
            boolean fearVal = new Random().nextInt(100) <  player.getFearChance();
            boolean reduceDamageChanceOpp = new Random().nextInt(100) <  opponent.getChanceOfSurviving();
            if(fearVal) {
                player.setAttack(player.getAttack() - 5);
                attack.setText("Attack: "+player.getAttack());  
            }
            int playerDamage;
            int playerMovePower = 0;
            movePlayer = player.getMoveByName(move); //get move of type Move from player's array of movelist
            if(movePlayer.getMoveType() == "Damage") {  // if the move is a damage move 
                playerMovePower = movePlayer.getPower();
                if(critVal) {
                    playerDamage = (Math.round(((((((2 * 30)/5) + 2) * playerMovePower * (battleWindow.player.getAttack() / battleWindow.opponent.getDefense())) / 50) + 2))) * critMultiplier; // calc player damage to opponent with crit chance accounted for
                    dialogueBox.setText("It was a critical hit!");
                }else {
                    playerDamage = Math.round(((((((2 * 30)/5) + 2) * playerMovePower * (battleWindow.player.getAttack() / battleWindow.opponent.getDefense())) / 50) + 2)); // calc player damage to opponent without crit chance accounted for
                }
                dialogueBox.setText(player.getName() + " used " + movePlayer.getMoveName()); //set jlabel to the move used by player

                try {
                    Thread.currentThread();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {   // add a delay to display appropriate message to the jlabel
                    e.printStackTrace();
                }

                if(dodgeValOpp) {  // if opponent's dodge change is activated
                    opponent.setHealth(opponent.getHealth() - 0); // opponent takes no damage
                    dialogueBox.setText("Opponent dodged the attack!"); //send text to the diaglouge box
                }

                if (reduceDamageChanceOpp) { // if opponent's reduce damage chance is activated
                    playerDamage = (Math.round(((((((2 * 30)/5) + 2) * playerMovePower * (battleWindow.player.getAttack() / battleWindow.opponent.getDefense())) / 50) + 2))) / 2; //reduce the damage taken by half
                    dialogueBox.setText("The foe "+opponent.getName()+" has tanked the attack!"); //display message
                } else {
                    playerDamage = (Math.round(((((((2 * 30)/5) + 2) * playerMovePower * (battleWindow.player.getAttack() / battleWindow.opponent.getDefense())) / 50) + 2))); // or else regular damage
                }
                opponent.setHealth(opponent.getHealth() - playerDamage); // update opponent's health
                healthOpponent.setText("Health: " + battleWindow.opponent.getHealth());
                
            } else if (movePlayer.getMoveType() == "Trait Change") { // if the move used is non-damaging
                if (movePlayer.getTraitChange() == "Speed") { // if it increases speed
                    player.setSpeed(player.getSpeed() + movePlayer.getTraitChangeValue()); //update speed value
                    speed.setText("Speed: "+battleWindow.player.getSpeed()); //update speed jlabel on ui
                    dialogueBox.setText(player.getName() + " increased its speed by " + movePlayer.getTraitChangeValue()); //display message
                } else if (movePlayer.getTraitChange() == "ChanceOfDodge") { // if it increases chance of dodging
                    player.setChanceOfDodge(player.getChanceOfDodge() + movePlayer.getTraitChangeValue()); //update chance of dodge value
                    chanceOfDodge.setText("Chance Of Dodge: "+battleWindow.player.getChanceOfDodge()); //update speed jlabel on ui
                    dialogueBox.setText(player.getName() + " increased its chance of dodging by " + movePlayer.getTraitChangeValue()); //display message
                } else if (movePlayer.getTraitChange() == "CriticalChance") { //if it increases critical chance
                    player.setCritChance(player.getCritChance() + movePlayer.getTraitChangeValue()); //update chance of critical damage
                    critChance.setText("Crit Chance: "+battleWindow.player.getCritChance()); //update crit chance jlabel on ui
                    dialogueBox.setText(player.getName() + " increased its critical chance by " + movePlayer.getTraitChangeValue()); //display message
                } else if (movePlayer.getTraitChange() == "Attack") {
                    player.setAttack(player.getAttack() + movePlayer.getTraitChangeValue());
                    attack.setText("Attack: "+battleWindow.player.getAttack());
                    dialogueBox.setText(player.getName() + " raised it's attack by " + movePlayer.getTraitChangeValue());   // essentially the same principle is being used to compare the rest of the trait changes
                } else if (movePlayer.getTraitChange() == "Defense") {
                    player.setDefense(player.getDefense() + movePlayer.getTraitChangeValue());
                    defense.setText("Defense: "+battleWindow.player.getDefense());
                    dialogueBox.setText(player.getName() + " increased its defense by " + movePlayer.getTraitChangeValue());
                }
            }
        } else if (opponent.getSpeed() > player.getSpeed()) {   // same process all over again for if opponent's speed is greater than player's
            opponent.setFirstToAttack("Yes");
            player.setFirstToAttack("No");
            int opponentMovePower = 0;
            int opponentDamage;
            boolean critVal2 = new Random().nextInt(100) < opponent.getCritChance();
            boolean dodgeValPlayer = new Random().nextInt(100) < player.getChanceOfDodge();
            boolean fearVal2 = new Random().nextInt(100) <  opponent.getFearChance();
            boolean reduceDamageChancePlayer = new Random().nextInt(100) <  player.getChanceOfSurviving();
            if(fearVal2) {
                opponent.setAttack(opponent.getAttack() - 5);  
            }
            moveOpponent = opponent.getRandomMove();
            if(moveOpponent.getMoveType() == "Damage") {
                opponentMovePower = moveOpponent.getPower();
                if(critVal2) {
                    opponentDamage = Math.round(((((((2 * 30)/5) + 2) * opponentMovePower * (battleWindow.opponent.getAttack() / battleWindow.player.getDefense())) / 50) + 2)) * critMultiplier;
                }else{
                    opponentDamage = Math.round(((((((2 * 30)/5) + 2) * opponentMovePower * (battleWindow.opponent.getAttack() / battleWindow.player.getDefense())) / 50) + 2));
                }
                dialogueBox.setText("The foe " + opponent.getName() + " used " + moveOpponent.getMoveName());

                if(dodgeValPlayer) {
                    player.setHealth(player.getHealth() - 0);
                    dialogueBox.setText("Player dodged the attack!");
                }

                if (reduceDamageChancePlayer) {
                    opponentDamage = (Math.round(((((((2 * 30)/5) + 2) * opponentMovePower * (battleWindow.player.getAttack() / battleWindow.opponent.getDefense())) / 50) + 2))) / 2;
                    dialogueBox.setText(player.getName()+" has tanked the attack!");
                } else {
                    opponentDamage = (Math.round(((((((2 * 30)/5) + 2) * opponentMovePower * (battleWindow.player.getAttack() / battleWindow.opponent.getDefense())) / 50) + 2)));
                }
                
                
                player.setHealth(player.getHealth() - opponentDamage);
                healthPlayer.setText("Health: " + battleWindow.player.getHealth());
                
            } else if (moveOpponent.getMoveType() == "Trait Change") {
                if (moveOpponent.getTraitChange() == "Speed") {
                    opponent.setSpeed(opponent.getSpeed() + moveOpponent.getTraitChangeValue());
                    // speed.setText("Speed: "+battleWindow.player.getSpeed());
                    dialogueBox.setText("The foe "+opponent.getName() + " increased its speed by " + moveOpponent.getTraitChangeValue());
                } else if (moveOpponent.getTraitChange() == "ChanceOfDodge") {
                    opponent.setChanceOfDodge(opponent.getChanceOfDodge() + moveOpponent.getTraitChangeValue());
                    // chanceOfDodge.setText("Chance Of Dodge: "+battleWindow.player.getChanceOfDodge());
                    dialogueBox.setText("The foe "+opponent.getName() + " increased its chance of dodging by " + moveOpponent.getTraitChangeValue());
                } else if (moveOpponent.getTraitChange() == "CriticalChance") {
                    opponent.setCritChance(opponent.getCritChance() + moveOpponent.getTraitChangeValue());
                    // critChance.setText("Crit Chance: "+battleWindow.player.getCritChance());
                    dialogueBox.setText("The foe "+opponent.getName() + " increased its critical chance by " + moveOpponent.getTraitChangeValue());
                } else if (moveOpponent.getTraitChange() == "Attack") {
                    opponent.setAttack(opponent.getAttack() + moveOpponent.getTraitChangeValue());
                    // attack.setText("Attack: "+battleWindow.player.getAttack());
                    dialogueBox.setText("The foe "+opponent.getName() + " raised it's attack by " + moveOpponent.getTraitChangeValue());
                } else if (moveOpponent.getTraitChange() == "Defense") {
                    opponent.setDefense(opponent.getDefense() + moveOpponent.getTraitChangeValue());
                    // defense.setText("Defense: "+battleWindow.player.getDefense());
                    dialogueBox.setText("The foe "+opponent.getName() + " increased its defense by " + moveOpponent.getTraitChangeValue());
                }
            }
        }

    }

    // Description: the second attack sequence between the two animals
    // @params: player: Type Animal
    //          opponent: Type Animal
    //          move: Type String

    public void attackSecond(Animal player, Animal opponent, String move) { // second attack sequence
        Move movePlayer;
        Move moveOpponent;

        
        int critMultiplier = 2;

        if (player.getFirstToAttack() == "No") { // if player is going second, do the same calculations from the first attack sequence
            int playerDamage;
            int playerMovePower = 0;
            boolean critVal = new Random().nextInt(100) < player.getCritChance();
            boolean dodgeValOpp = new Random().nextInt(100) < player.getChanceOfDodge();
            movePlayer = player.getMoveByName(move);
            boolean fearVal = new Random().nextInt(100) <  player.getFearChance();
            boolean reduceDamageChanceOpp = new Random().nextInt(100) <  opponent.getChanceOfSurviving();
            if(fearVal) {
                player.setAttack(player.getAttack() - 5);
                attack.setText("Attack: "+player.getAttack());  
            }
            if(movePlayer.getMoveType() == "Damage") {
                playerMovePower = movePlayer.getPower();
                if(critVal) {
                    playerDamage = Math.round(((((((2 * 30)/5) + 2) * playerMovePower * (battleWindow.player.getAttack() / battleWindow.opponent.getDefense())) / 50) + 2)) * critMultiplier;
                }else{
                    playerDamage = Math.round(((((((2 * 30)/5) + 2) * playerMovePower * (battleWindow.player.getAttack() / battleWindow.opponent.getDefense())) / 50) + 2));
                }

                if(dodgeValOpp) {
                    opponent.setHealth(opponent.getHealth() - 0);
                    dialogueBox.setText("Opponent dodged the attack!");
                }

                if (reduceDamageChanceOpp) {
                    playerDamage = (Math.round(((((((2 * 30)/5) + 2) * playerMovePower * (battleWindow.player.getAttack() / battleWindow.opponent.getDefense())) / 50) + 2))) / 2;
                    dialogueBox.setText("The foe "+opponent.getName()+" has tanked the attack!");
                } else {
                    playerDamage = (Math.round(((((((2 * 30)/5) + 2) * playerMovePower * (battleWindow.player.getAttack() / battleWindow.opponent.getDefense())) / 50) + 2)));
                }
                opponent.setHealth(opponent.getHealth() - playerDamage);

                dialogueBox.setText(player.getName() + " used " + movePlayer.getMoveName());
                healthOpponent.setText("Health: " + battleWindow.opponent.getHealth());
                
            } else if (movePlayer.getMoveType() == "Trait Change") {
                if (movePlayer.getTraitChange() == "Speed") {
                    player.setSpeed(player.getSpeed() + movePlayer.getTraitChangeValue());
                    speed.setText("Speed: "+battleWindow.player.getSpeed());
                    dialogueBox.setText(player.getName() + " increased its speed by " + movePlayer.getTraitChangeValue());
                } else if (movePlayer.getTraitChange() == "ChanceOfDodge") {
                    player.setChanceOfDodge(player.getChanceOfDodge() + movePlayer.getTraitChangeValue());
                    chanceOfDodge.setText("Chance Of Dodge: "+battleWindow.player.getChanceOfDodge());
                    dialogueBox.setText(player.getName() + " increased its chance of dodging by " + movePlayer.getTraitChangeValue());
                } else if (movePlayer.getTraitChange() == "CriticalChance") {
                    player.setCritChance(player.getCritChance() + movePlayer.getTraitChangeValue());
                    critChance.setText("Crit Chance: "+battleWindow.player.getCritChance());
                    dialogueBox.setText(player.getName() + " increased its critical chance by " + movePlayer.getTraitChangeValue());
                } else if (movePlayer.getTraitChange() == "Attack") {
                    player.setAttack(player.getAttack() + movePlayer.getTraitChangeValue());
                    attack.setText("Attack: "+battleWindow.player.getAttack());
                    dialogueBox.setText(player.getName() + " raised it's attack by " + movePlayer.getTraitChangeValue());
                } else if (movePlayer.getTraitChange() == "Defense") {
                    player.setDefense(player.getDefense() + movePlayer.getTraitChangeValue());
                    defense.setText("Defense: "+battleWindow.player.getDefense());
                    dialogueBox.setText(player.getName() + " increased its defense by " + movePlayer.getTraitChangeValue());
                }
            }
        } else if (opponent.getFirstToAttack() == "No") { // if opponent is going second, do the same calculations from the first attack sequence
            int opponentMovePower = 0;
            int opponentDamage;
            boolean critVal2 = new Random().nextInt(100) < opponent.getCritChance();
            boolean dodgeValPlayer = new Random().nextInt(100) < player.getChanceOfDodge();
            boolean fearVal2 = new Random().nextInt(100) <  opponent.getFearChance();
            boolean reduceDamageChancePlayer = new Random().nextInt(100) <  player.getChanceOfSurviving();
            if(fearVal2) {
                opponent.setAttack(opponent.getAttack() - 5);
            }
            moveOpponent = opponent.getRandomMove();
            if(moveOpponent.getMoveType() == "Damage") {
                opponentMovePower = moveOpponent.getPower();
                if(critVal2) {
                    opponentDamage = Math.round(((((((2 * 30)/5) + 2) * opponentMovePower * (battleWindow.opponent.getAttack() / battleWindow.player.getDefense())) / 50) + 2)) + critMultiplier;
                }else{
                    opponentDamage = Math.round(((((((2 * 30)/5) + 2) * opponentMovePower * (battleWindow.opponent.getAttack() / battleWindow.player.getDefense())) / 50) + 2));
                }   
                dialogueBox.setText("The foe " + opponent.getName() + " used " + moveOpponent.getMoveName());
                try {
                    Thread.currentThread();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(dodgeValPlayer) {
                    player.setHealth(player.getHealth() - 0);
                    dialogueBox.setText("Player dodged the attack!");
                    
                }

                if (reduceDamageChancePlayer) {
                    opponentDamage = (Math.round(((((((2 * 30)/5) + 2) * opponentMovePower * (battleWindow.player.getAttack() / battleWindow.opponent.getDefense())) / 50) + 2))) / 2;
                    dialogueBox.setText(player.getName()+" has tanked the attack!");
                } else {
                    opponentDamage = (Math.round(((((((2 * 30)/5) + 2) * opponentMovePower * (battleWindow.player.getAttack() / battleWindow.opponent.getDefense())) / 50) + 2)));
                }

                
            
                player.setHealth(player.getHealth() - opponentDamage);
                healthPlayer.setText("Health: " + battleWindow.player.getHealth());
                
            } else if (moveOpponent.getMoveType() == "Trait Change") {
                if (moveOpponent.getTraitChange() == "Speed") {
                    opponent.setSpeed(opponent.getSpeed() + moveOpponent.getTraitChangeValue());
                    // speed.setText("Speed: "+battleWindow.player.getSpeed());
                    dialogueBox.setText("The foe "+opponent.getName() + " increased its speed by " + moveOpponent.getTraitChangeValue());
                } else if (moveOpponent.getTraitChange() == "ChanceOfDodge") {
                    opponent.setChanceOfDodge(opponent.getChanceOfDodge() + moveOpponent.getTraitChangeValue());
                    // chanceOfDodge.setText("Chance Of Dodge: "+battleWindow.player.getChanceOfDodge());
                    dialogueBox.setText("The foe "+opponent.getName() + " increased its chance of dodging by " + moveOpponent.getTraitChangeValue());
                } else if (moveOpponent.getTraitChange() == "CriticalChance") {
                    opponent.setCritChance(opponent.getCritChance() + moveOpponent.getTraitChangeValue());
                    // critChance.setText("Crit Chance: "+battleWindow.player.getCritChance());
                    dialogueBox.setText("The foe "+opponent.getName() + " increased its critical chance by " + moveOpponent.getTraitChangeValue());
                } else if (moveOpponent.getTraitChange() == "Attack") {
                    opponent.setAttack(opponent.getAttack() + moveOpponent.getTraitChangeValue());
                    // attack.setText("Attack: "+battleWindow.player.getAttack());
                    dialogueBox.setText("The foe "+opponent.getName() + " raised it's attack by " + moveOpponent.getTraitChangeValue());
                } else if (moveOpponent.getTraitChange() == "Defense") {
                    opponent.setDefense(opponent.getDefense() + moveOpponent.getTraitChangeValue());
                    // defense.setText("Defense: "+battleWindow.player.getDefense());
                    dialogueBox.setText("The foe "+opponent.getName() + " increased its defense by " + moveOpponent.getTraitChangeValue());
                }
            }
        }
    }

    // Description: the battle method which calls the two auxiliary methods firstAttack and secondAttack
    // @params: player: Type Animal
    //          opponent: Type Animal
    //          move: Type String

    public void battle(Animal player, Animal opponent, String move) {



            

        if(opponent.getHealth() > 0 && player.getHealth() > 0) { // check if player and opponent both have health

        
            TimerTask firstAttackTask = new TimerTask() { // delay the tasks via timer and timertask to start different threads
                public void run() {
                    attackFirst(player, opponent, move);
                }
            };

            TimerTask secondAttackTask = new TimerTask() {
                public void run() {
                    attackSecond(player, opponent, move);
                }
            };

            Timer timer1 = new Timer("Timer");
            Timer timer2 = new Timer("Timer");
            timer1.schedule(firstAttackTask, 5);
            timer2.schedule(secondAttackTask, 2000);
        

            opponent.testPrintInformation();
            player.testPrintInformation();
        }else if(player.getHealth() > 0 && opponent.getHealth() <= 0) { // if opponent's health goes to 0
            dialogueBox.setText("Player Wins!"); // player wins
            //set the opponent health to 0 b/c opponent is defeated
            opponent.setHealth(0);
            healthOpponent.setText("Health: " + opponent.getHealth());
            //disable the buttons
            attack1button.setEnabled(false); 
            attack2button.setEnabled(false);
            attack3button.setEnabled(false);
            attack4button.setEnabled(false);
        
        }else if(opponent.getHealth() > 0 && player.getHealth() <= 0) { //if player's health goes to 0
            dialogueBox.setText("Opponent Wins!"); // opponent wins
            //set the opponent health to 0 b/c player is defeated
            player.setHealth(0);
            healthPlayer.setText("Health: " + player.getHealth());
            // disable the buttons
            attack1button.setEnabled(false); 
            attack2button.setEnabled(false);
            attack3button.setEnabled(false);
            attack4button.setEnabled(false);
        }
            
    }

    // Description: this function will check if the move buttons have been pressed, if so, initiate battle by calling the function.
    // @params: java.awt.event.ActionEvent e

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(e.getSource() == attack1button) {
            battle(battleWindow.player, battleWindow.opponent, attack1button.getText());
        }else if(e.getSource() == attack2button) {
            battle(battleWindow.player, battleWindow.opponent, attack2button.getText());
        }else if(e.getSource() == attack3button) {
            battle(battleWindow.player, battleWindow.opponent, attack3button.getText());
        }else if(e.getSource() == attack4button) {
            battle(battleWindow.player, battleWindow.opponent, attack4button.getText());
        }
        
    }

}

