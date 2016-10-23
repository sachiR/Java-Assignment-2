package dim.game.A1;

import java.util.ArrayList;
import java.util.Random;

public class deck {
    private static final int NUM_OF_PLAYER_CARDS = 60;
    private ArrayList<Card> cards;
    private ArrayList<TrumpCard> trumpCards;


    public deck(){
        cards = new ArrayList<Card>();
        trumpCards = new ArrayList<TrumpCard>();
        for (int i = 0; i < NUM_OF_PLAYER_CARDS; i++) {
            cards.add(new Card(i));
        }
    }

    public ArrayList<Card> dealCards(int nCards) {
        ArrayList<Card> ret = new ArrayList<Card>();
        trumpCards = new ArrayList<TrumpCard>();
        Random rand = new Random();
        for(int i = 0; i < nCards; i++) {
            if (cards.size() > 0 || trumpCards.size() > 0) {
                int idx = rand.nextInt(cards.size());
                Card card = cards.remove(idx);
                ret.add(card);
                //System.out.println("card = " + card);
            } else {
                return null;
            }
        }
        return ret;
    }
}