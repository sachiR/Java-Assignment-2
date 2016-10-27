import java.util.List;

public class STPlayer {
    private int playerID;
    private String playerName;
    private List<STCard> cardsInHand;

    public List<STCard> setCardsInHand;

    public STPlayer(int playerID) {
        this.playerID = playerID;
    }

    public STPlayer(int playerID, String playerName) {
        this.playerID = playerID;
        this.playerName = playerName;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getPlayerID() {
        return this.playerID;
    }

    public void setPlayerName(String playerName){this.playerName = playerName;}

    public String getPlayerName(){return this.playerName;}

    public void setCardsInHand(List<STCard> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    public List<STCard> getCardsInHand() {
        return cardsInHand;
    }

}
