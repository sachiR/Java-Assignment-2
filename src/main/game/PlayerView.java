package main.game;

import javax.swing.*;

public class PlayerView extends JPanel{
    STPlayer playerID;
    STGame game;
    JLabel playerName = new JLabel("YOU");

    public PlayerView(STPlayer playerID) {
        this.playerID = playerID;
        add(playerName);

        addAllCard();
    }

    private void addAllCard() {
        playerID.getCardsInHand();

        for(int i = 0; i < game.getPlayer(0).getCardsInHand().size(); i++){
            game.getPlayer(0).getCardsInHand().get(i).toString();
            CardView cardView = new CardView(game.getPlayer(0).getCardsInHand().get(i).toString());
        }
    }
}
