package main.game;

import javax.swing.*;

public class CardView extends JPanel{
    STCard card;

    public CardView(STCard card) {
        this.card  = card;
        JLabel cardName= new JLabel(String.valueOf(card));

        add(cardName);
    }
}
