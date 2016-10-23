package main.game;

import java.util.List;

public class STPlayer {
    private int _playerID;
    private String _playerName;
    private List<STCard> _cardsInHand;

    public List<STCard> setCardsInHand;

    public STPlayer(int playerID) {
        this._playerID = playerID;
    }
    public STPlayer(int playerID, String playerName)
    {
        this._playerID = playerID;
        this._playerName = playerName;
    }

    public void setPlayerID(int playerID) {
        this._playerID = playerID;
    }
    public int getPlayerID() {
        return this._playerID;
    }

    public void setPlayerName(String playerName){this._playerName = playerName;}
    public String getPlayerName(){return this._playerName;}

    public void setCardsInHand(List<STCard> cardsInHand) {
        this._cardsInHand = cardsInHand;
    }
    public List<STCard> getCardsInHand() {
        return _cardsInHand;
    }

}
