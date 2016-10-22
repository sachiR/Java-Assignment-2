package main.game;

import javax.swing.*;
import java.awt.*;

public class PlayPanel extends JPanel{
    MainGUI mainGUI = new MainGUI();
    Integer numOfPlayers = mainGUI.userTesting();
    STGame game = new STGame(numOfPlayers);
    JLabel dealerID = new JLabel("The Dealer is "+String.valueOf(game.getDealerID()));

    public PlayPanel(){
        setSize(800, 700);
        setLayout(new BorderLayout());
        add(dealerID);
    }
}
