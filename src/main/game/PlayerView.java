package main.game;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerView extends JPanel{
    STPlayer player;
    STGame game;
    JLabel playerName = new JLabel("YOU");

    public PlayerView(STPlayer playerID) {
        add(playerName);

        addAllCard();
    }

    private void addAllCard() {
        List<STCard> cards = player.getCardsInHand();

//        for(int i = 0; i < game.getPlayer(0).getCardsInHand().size(); i++){
//            CardView cardView = new CardView(game.getPlayer(0).getCardsInHand().get(i).toString());
//        }
    }
}
