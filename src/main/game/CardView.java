package main.game;

import javax.swing.*;

public class CardView extends JPanel{
    STCard card;

    public CardView(STCard card) {
        this.card  = card;
        JLabel cardID= new JLabel("1");

        add(cardID);
    }
}
