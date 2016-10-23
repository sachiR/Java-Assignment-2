package dim.game.A1;

import java.util.ArrayList;

public class STPlayer {
    private ArrayList<Card> cards;
    private String playerId;

    public STPlayer(String playerId) {

        this.playerId = playerId;
    }

    public void setCards( ArrayList<Card> cards) {

        this.cards = cards;
    }
    public ArrayList getCards( ) {
        return cards;
    }

    public String toString(){
        return "Player ID = " + playerId +"\nCards:" + cards;
    }

}