package main.game;

import javax.swing.*;
import java.awt.*;

public class PlayPanel extends JPanel{
    private int players;

    public PlayPanel(int numOfPlayers){
        setLayout(new FlowLayout());
        this.players = numOfPlayers;
        STGame game = new STGame(numOfPlayers);
        JLabel playLabel = new JLabel("The Number of players are " + numOfPlayers);
        add(playLabel);
        JLabel dealerLabel = new JLabel("The Dealer is "+ game.getDealerID());
        add(dealerLabel);
        JLabel nextPlayer = new JLabel("The next player is " + game.getNextPlayer());
        add(nextPlayer);

    }
}
