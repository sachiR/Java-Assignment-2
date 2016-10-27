import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class STGame {
    private static final int NUMBER_OF_CARDS_FOR_EACH_PLAYER = 8;
    private STDeck deck;
    private ArrayList<STPlayer> players;
    private int dealerID;
    private int nextPlayerID = -1;
    private int lastPlayerID = -1;
    private STCard lastPlayCard;

    private STCard.enumCategory trumpCategory;
    private double trumpValue = 0.0;
    private String trumpValueInText;

    // ----- PROPERTIES FOR CHECKING----TO BE REMOVE --

    //-------------END ----


    //private String _dealerName;

    public STGame(){
        this.deck = new STDeck();
    }

    public STDeck getDeck(){return this.deck;}

    public void setPlayers(ArrayList<STPlayer> players){
        this.players = players;
        this.dealerID = selectDealer();
        this.nextPlayerID = calculateNextPlayerID(this.dealerID);
    }

    public ArrayList<STPlayer> getPlayers(){return this.players;}

    public void setTrumpCategory(STCard.enumCategory trumpCategory){this.trumpCategory = trumpCategory;}

    public STCard.enumCategory getTrumpCategory(){return this.trumpCategory;}

    public double getTrumpValue(){return trumpValue;}

    public String getTrumpValueInText(){return trumpValueInText;}

    public STCard getLastPlayCard() {return this.lastPlayCard;}

    public void setLastPlayCard(STCard lastPlayCard){this.lastPlayCard = lastPlayCard;}

    private int selectDealer() {
        Random rnd = new Random();
        return rnd.nextInt(this.players.size());
    }

    public int getDealerID(){return this.dealerID;}

    public STPlayer getPlayer(int index){return this.players.get(index); }

    public int getNextPlayerID(){ return this.nextPlayerID; }

    public int getLastPlayerID(){return this.lastPlayerID;}

    public void changePlayer(){
        lastPlayerID = nextPlayerID;
        nextPlayerID = calculateNextPlayerID(nextPlayerID);
    }

    public void dealCardsToEachPlayer(){
        int p  = -1 ;
        for(int j = 0; j < this.players.size(); j++)
        {
            p =  calculateNextPlayerID ( j == 0 ? this.dealerID : p);
            List<STCard> c = new ArrayList<STCard>();  // arList<STCard>();
            for (int i = 0; i < NUMBER_OF_CARDS_FOR_EACH_PLAYER; i++)
            {
                c.add(this.deck.getCard(i));
                this.deck.getCards().remove(i);     // .RemoveAt(i);
            }
            this.players.get(p).setCardsInHand(c);      // .CardsInHand = c;
            //p = calculateNextPlayerID(p);
        }
    }

    private int calculateNextPlayerID(int p) {
        p++;
        if(p >= this.players.size()) {
            p = 0;
        }
        return p;
    }

    public STCard getCardFromDeck(){
        STCard card = this.deck.getCard(0);
        this.deck.getCards().remove(0);
        return card;
    }

    public STCard playRandomCard(int playerid) {
        STCard cardToReturn = null;
        if(this.lastPlayCard == null){
            Random rnd = new Random();
            while (true) {
                int c = rnd.nextInt(this.getPlayer(playerid).getCardsInHand().size());
                String ct = this.getPlayer(playerid).getCardsInHand().get(c).getCardType().toString();

                if (ct == STCard.enumCardType.Play.toString()) {
                    int trumpcat = rnd.nextInt(5);
                    setTrumpCategory(STCard.enumCategory.values()[trumpcat]);
                    cardToReturn = this.getPlayer(playerid).getCardsInHand().get(c);
                    break;
                }
            }
        } else {
            cardToReturn = compareAndReturnACard();
            if(cardToReturn == null){
                cardToReturn = getTrumpCardIfExist();
                if(cardToReturn != null){
                    changeTrumpCategory(cardToReturn);
                }
            }
        }
        return cardToReturn;
    }

    private STCard getTrumpCardIfExist() {
        STCard cardToReturn = null;

        for (STCard cd : this.getPlayer(nextPlayerID).getCardsInHand()) {
            if(cd.getCardType() == STCard.enumCardType.Trump){
                cardToReturn = cd;
                break;
            }
        }
        return cardToReturn;
    }

    private boolean changeTrumpCategory(STCard card) {
        this.trumpCategory = card.getTrumpCategoryEnum();
        this.trumpValue =0.0;

        JOptionPane.showMessageDialog(null, "Change Trump Category to " + this.trumpCategory, "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);

        return true;
    }

    public STCard compareAndReturnACard(){
        STCard cardToReturn = null;

        for (STCard cd : this.getPlayer(nextPlayerID).getCardsInHand()) {
            double val1 = getTrumpValue(cd);
            if(val1 > this.trumpValue){
                JOptionPane.showMessageDialog(null, "Last card Value is " + this.trumpValueInText + " Selected Card Value is " + getTrumpValueInText(cd) , "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
                cardToReturn = cd;
                break;
            }

        }
        return cardToReturn;
    }

    public boolean validatePlayedCard(STCard card){
        if(this.lastPlayCard == null){return true;}

        if(card.getCardType() == STCard.enumCardType.Trump){
            changeTrumpCategory(card);
            return true;

        } else {
            double val1 = getTrumpValue(card);

            if(val1 > this.trumpValue){
                JOptionPane.showMessageDialog(null, "Last card Value is = " + this.trumpValue + " Selected Card Value is" + val1 , "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        return false;
    }

    public boolean afterCardPlay(STCard cardPlaied){
        try{
            int index = getIndexByCardIDOfCardInHand(nextPlayerID, cardPlaied.getCardID());
            this.getPlayer(nextPlayerID).getCardsInHand().remove(index);
            this.changePlayer();
            this.lastPlayCard = cardPlaied;

            this.trumpValue = getTrumpValue(cardPlaied);
            this.trumpValueInText = getTrumpValueInText(cardPlaied);

            JOptionPane.showMessageDialog(null, "Selected Card ID is  " + index + " And Card is" + cardPlaied.toString() , "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
            return true;

        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "ERROR !!" + ex.toString() , "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
        }

        return false;
    }

    private double getTrumpValue(STCard cardPlaied ){
        double retval = 0.0;
        switch (this.trumpCategory.ordinal()){
            case 0:
                retval = cardPlaied.getHardnessToNum();
                break;
            case 1:
                retval = cardPlaied.getSpecificGravityToNum();
                break;
            case 2:
                retval = cardPlaied.getCleavageToNum();
                break;
            case 3:
                retval = cardPlaied.getCrustalAbundanceToNum();
                break;
            case 4:
                retval = cardPlaied.getEconomicValueToNum();
                break;
        }
        return retval;
    }

    private String getTrumpValueInText(STCard cardPlayed ){
        String retval = null;

        switch (this.trumpCategory.ordinal()){
            case 0:
                retval = cardPlayed.getHardness();
                break;
            case 1:
                retval = cardPlayed.getSpecificGravity();
                break;
            case 2:
                retval = cardPlayed.getCleavage();
                break;
            case 3:
                retval = cardPlayed.getCrustalAbundance();
                break;
            case 4:
                retval = cardPlayed.getEconomicValue();
                break;
        }
        return retval;
    }

    public int getIndexByCardIDOfCardInHand(int playerID, int cardID){
        for(int i = 0; i<this.getPlayer(playerID).getCardsInHand().size(); i++){
            if(this.getPlayer(playerID).getCardsInHand().get(i).getCardID() == cardID ){
                return i;
            }
        }
        return -1;
    }
}
