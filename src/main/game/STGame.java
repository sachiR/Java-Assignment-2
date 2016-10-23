package main.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class STGame {
    private int numPlayers;
    private static final int NUMBER_OF_CARDS_FOR_EACH_PLAYER = 8;
    private STDeck _deck;
    private ArrayList<STPlayer> _players;
    private int _dealerID;
    private int _nextPlayerID = -1;


    public STGame(int numOfPlayers) {
        this.numPlayers = numOfPlayers;
        this._deck = new STDeck();
        this._players = (ArrayList<STPlayer>) InitialisePlayers();
        this._dealerID = SelectDealer();
        this._nextPlayerID = calculateNextPlayerID(this._dealerID);
    }
    private int SelectDealer() {
        Random rnd = new Random();
        return rnd.nextInt(this._players.size());
    }

    public ArrayList<STPlayer> getPlayers(){return this._players;}
    public int getDealerID(){return this._dealerID;}
    public STPlayer getPlayer(int index){return this._players.get(index); }
    public int getNextPlayer(){ return calculateNextPlayerID(this._nextPlayerID); }


    private List<STPlayer> InitialisePlayers() {
        List<STPlayer> players = new ArrayList<STPlayer>();
        for (int i = 0; i < this.numPlayers; i++){
            STPlayer p = new STPlayer(i);
            players.add(p);
        }
        System.out.println();
        return players;
    }

//    public void DealCardsToEachPlayer(){
//        int p =  calculateNextPlayerID(this._dealerID);
//        for(int j = 0; j < this._players.size(); j++)
//        {
//            List<STCard> c = new ArrayList<STCard>();  // arList<STCard>();
//            for (int i = 0; i < NUMBER_OF_CARDS_FOR_EACH_PLAYER; i++)
//            {
//                c.add(this._deck.getCard(i));
//                this._deck.getCards().remove(i);     // .RemoveAt(i);
//            }
//            this._players.get(p).setCardsInHand(c);      // .CardsInHand = c;
//            p = calculateNextPlayerID(p);
//        }
//    }

    private int calculateNextPlayerID(int p) {
        p++;
        if(p >= this._players.size()) {
            p = 0;
        }
        return p;
    }
}