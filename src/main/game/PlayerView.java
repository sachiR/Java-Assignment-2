package main.game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerView extends JPanel{
    STPlayer player;
    STGame game;
    JLabel playerName = new JLabel("YOU");

    public PlayerView(STPlayer playerID) {
        this.player = playerID;

        add(playerName);
    }

    private void addAllCard() {
        List<STCard> cards = player.getCardsInHand();

        for (int i = 0; i < cards.size(); i++){
            STCard card = cards.get(i);
            CardView cardView = new CardView(card);
            cardView.setBackground(new Color(0, 153, 0));
            add(cardView);
        }

    }
}
