package main.game;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class STGame {
    private int numPlayers;
    private static final int NUMBER_OF_CARDS_FOR_EACH_PLAYER = 8;
    //private STDeck _deck;
    private ArrayList<STPlayer> players;
    private int dealerID;
    private int nextPlayerID;


    public STGame(int numOfPlayers) {
        this.numPlayers = numOfPlayers;
        // this._deck = new STDeck();
        this.players = (ArrayList<STPlayer>) InitialisePlayers();
        this.dealerID = SelectDealer();
        this.nextPlayerID = calculateNextPlayerID(this.dealerID);
    }

    private int SelectDealer() {
        Random rnd = new Random();
        return rnd.nextInt(this.players.size());
    }

    public ArrayList<STPlayer> getPlayers() {
        return this.players;
    }

    public int getDealerID() {
        return this.dealerID;
    }

    public STPlayer getPlayer(int index) {
        return this.players.get(index);
    }

    public int getNextPlayer() {
        return this.nextPlayerID;
    }

    private int calculateNextPlayerID(int p) {
        p++;
        if (p > this.numPlayers) {
            p = 0;
        }
        nextPlayerID = p;
        return p;
    }

    private List<STPlayer> InitialisePlayers() {
        List<STPlayer> players = new ArrayList<STPlayer>();
        for (int i = 0; i < this.numPlayers; i++) {
            STPlayer p = new STPlayer(i);
            players.add(p);
        }
        System.out.println();
        return players;
    }

//    public void DealCardsToEachPlayer(){
//        int p =  calculateNextPlayerID(this.dealerID);
//        for(int j = 0; j < this.players.size(); j++)
//        {
//            List<STCard> c = new ArrayList<STCard>();  // arList<STCard>();
//            for (int i = 0; i < NUMBER_OF_CARDS_FOR_EACH_PLAYER; i++)
//            {
//                c.add(this._deck.getCard(i));
//                this._deck.getCards().remove(i);     // .RemoveAt(i);
//            }
//            this.players.get(p).setCardsInHand(c);      // .CardsInHand = c;
//            p = calculateNextPlayerID(p);
//        }
//    }

}