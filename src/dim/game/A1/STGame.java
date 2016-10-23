package dim.game.A1;

import java.util.ArrayList;
import java.util.Random;

public class STGame {

    private static final int NUM_CARDS_TO_DEAL = 8;
    private int randomDealer;
    private int numPlayers;
    private STPlayer[] players;
    private dim.game.A1.deck deck;
    int yourPlayerId;

    public STGame(int numPlayers) {
        this.numPlayers = numPlayers ;
        deck = new deck();
    }

    public int selectDealer() {
        Random rand = new Random();//randomly selecting a dealer
        randomDealer = rand.nextInt((5 - 3)+1)+3;
        System.out.println("random dealer = " + randomDealer);
        System.out.println("");
        return randomDealer;
    }

    public void dealRandomCardsToEachPlayer() {
        players = new STPlayer[numPlayers];
        for(int i = 0; i < numPlayers; i++){
            players[i] = new STPlayer("player=" +i);
        }
        for (STPlayer player : players) {
            ArrayList<Card> cards = deck.dealCards(NUM_CARDS_TO_DEAL);
            player.setCards(cards);
        }
    }

    public void selectYouAsPlayer() {
        yourPlayerId = 0 ;
    }

    public STPlayer getHumPlayer() {
        return players[yourPlayerId];
    }

    public void playTheGame() {
    }

    private void showTurnPlayer() {
    }
}