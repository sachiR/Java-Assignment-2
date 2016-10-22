package main.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class STGame {

    private static final int NUMBER_OF_CARDS_FOR_EACH_PLAYER = 8;
    private STDeck _deck;
    private ArrayList<STPlayer> _players;
    private int _dealerID;
    private int _nextPlayerID = -1;
    //private String _dealerName;

    public STGame(){
        this._deck = new STDeck();
        this._players = Players();
        this._dealerID = SelectDealer();
        this._nextPlayerID = calculateNextPlayerID(this._dealerID);
    }

    public ArrayList<STPlayer> getPlayers(){return this._players;}

    private int SelectDealer() {
        Random rnd = new Random();
        return rnd.nextInt(this._players.size());
    }
    public int getDealerID(){return this._dealerID;}
    public STPlayer getPlayer(int index){return this._players.get(index); }
    public int getNextPlayer(){ return calculateNextPlayerID(this._nextPlayerID); }

    private ArrayList<STPlayer> Players() {
        System.out.println("Enter The Number Of Players... (3 to 5)");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        ArrayList<STPlayer> p = new ArrayList<>();
        p.add(new STPlayer(0, "Sachini Perera"));

        for(int i = 1; i < n; i++){
            System.out.println("Enter The Name of the Player " + i );
            Scanner reader = new Scanner(System.in); // Reading from System.in
            String line = reader.nextLine ();
            p.add(new STPlayer(i, line));
        }
        return p;
    }

    public void DealCardsToEachPlayer(){
        int p =  calculateNextPlayerID(this._dealerID);
        for(int j = 0; j < this._players.size(); j++)
        {
            List<STCard> c = new ArrayList<STCard>();  // arList<STCard>();
            for (int i = 0; i < NUMBER_OF_CARDS_FOR_EACH_PLAYER; i++)
            {
                c.add(this._deck.getCard(i));
                this._deck.getCards().remove(i);     // .RemoveAt(i);
            }
            this._players.get(p).setCardsInHand(c);      // .CardsInHand = c;
            p = calculateNextPlayerID(p);
        }
    }

    private int calculateNextPlayerID(int p) {
        p++;
        if(p >= this._players.size()) {
            p = 0;
        }
        return p;
    }
}
