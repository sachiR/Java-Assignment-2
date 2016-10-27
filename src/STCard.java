import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class STCard {
    public enum enumCategory{
        Hardness,
        Specific_Gravity,
        Cleavage,
        Crustal_Abundance,
        Economic_Value
    }
    public enum enumCardType{
        Play,
        Trump
    }

    private static final int CARD_WIDTH = 90;
    private static final int CARD_HEIGHT = 180;

    private HashMap<Integer, String> OneCleavage = new HashMap<Integer, String>() {
        {   put(0,"none");
            put(1,"poor/none");
            put(2,"1 poor");
            put(3,"2 poor");
            put(4,"1 good");
            put(5,"1 good, 1 poor");
            put(6,"2 good");
            put(7,"3 good");
            put(8,"1 perfect");
            put(9,"1 perfect, 1 good");
            put(10,"1 perfect, 2 good");
            put(11,"2 perfect, 1 good");
            put(12,"3 perfect");
            put(13,"4 perfect");
            put(14,"6 perfect");
        }
    };
    private HashMap<Integer, String> OneCrustalAbundance = new HashMap<Integer, String>() {
        {   put(0,"ultra-trace");
            put(1,"trace");
            put(2,"low");
            put(3,"moderate");
            put(4,"high");
            put(5,"very high");
        }
    };
    private HashMap<Integer, String> OneEconomicValue = new HashMap<Integer, String>() {
        {   put(0,"trivial");
            put(1,"low");
            put(2,"moderate");
            put(3,"high");
            put(4,"very high");
            put(5,"i`m rich");
        }
    };
    private HashMap<String, String> OneCategory = new HashMap<String, String>() {
        {   put(enumCategory.Hardness.toString() ,  "Hardness");
            put(enumCategory.Specific_Gravity.toString() ,  "Specific gravity");
            put(enumCategory.Cleavage.toString() ,  "Cleavage");
            put(enumCategory.Crustal_Abundance.toString() ,  "Crustal abundance");
            put(enumCategory.Economic_Value.toString() ,  "Economic value");
        }
    };

    private int cardID;
    private enumCardType cardType;

    private String cardTitle;
    private String chemistry;
    private String classification;
    private String crystalSystem;
    private ArrayList<String> occurrence;

    private String hardness;
    private String specificGravity;
    private String cleavage;
    private String crustalAbundance;
    private String economicValue;

    private String trumpCategory;

    private String fileName;
    private String imageName;

    private String subTitle;

    // Import ImageIcon
    //private ImageIcon           _cardBottomImage;        // = new ImageIcon("Images/YourCompanyLogo.png");
    //private ImageIcon           _cardTopImage;

    // In init() method write this code
    //jLabelYourCompanyLogo.setIcon(iconLogo);

    public STCard(){
        //this._cardTopImage = new ImageIcon(((new ImageIcon("images\\Slide66.jpg")).getImage()).getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH));
    }

    public STCard(int cardID, String cardTitle){
        this();
        this.cardID = cardID;
        this.cardType = enumCardType.Play;
        this.cardTitle = cardTitle;
    }

    public STCard(int cardID, String cardTitle, String trumpCategory){
        this();
        this.cardID = cardID;
        this.cardType = enumCardType.Trump;
        this.cardTitle = cardTitle;
    }

    public ImageIcon getCardBottomImage(){
        ImageIcon img = new ImageIcon("images\\" + this.imageName + ".jpg");
        return new ImageIcon(img.getImage().getScaledInstance(CARD_WIDTH,CARD_HEIGHT, Image.SCALE_SMOOTH));
    }

    public ImageIcon getCardTopImage(){
        ImageIcon img = new ImageIcon("images\\Slide66.jpg");
        return new ImageIcon(img.getImage().getScaledInstance(20,25, Image.SCALE_SMOOTH));
    }

    public int getCardID(){return this.cardID;}

    public enumCardType getCardType(){return this.cardType;}

    public  String getCardTitle(){return this.cardTitle;}

    public void setCardTitle(String cardTitle){this.cardTitle = cardTitle;}

    public void setChemistry(String Chemistry){this.chemistry = Chemistry;}

    public String getChemistry(){return this.chemistry;}

    public void setClassification(String Classification){this.classification = Classification;}

    public String getClassification(){return this.classification;}

    public void setCrystalSystem(String crystalSystem){this.crystalSystem = crystalSystem;}

    public String getCrystalSystem(){return this.crystalSystem;}

    public void setOccurrence(ArrayList<String> occurrence){this.occurrence = occurrence;}

    public ArrayList<String> getOccurrence(){return this.occurrence;}

    public void setHardness(String hardness){this.hardness = hardness;}

    public String getHardness(){return this.hardness;}

    public Double getHardnessToNum(){
        Double retValue = -1.0;
        if(this.getCardType()==enumCardType.Play){
            try {
                String temp = this.hardness;
                String[] h = temp.split("-");
                for(int i = 0 ; i< h.length ; i++){
                    if(retValue<Double.parseDouble(h[i].toString())){
                        retValue = Double.parseDouble(h[i].toString());
                    }
                }
            } catch (Exception e){

            }
        }
        return retValue;
    }

    public void setSpecificGravity(String specificGravity){this.specificGravity = specificGravity;}

    public String getSpecificGravity(){return this.specificGravity;}

    public Double getSpecificGravityToNum(){
        Double retValue = -1.0;
        if(this.getCardType() == enumCardType.Play){
            try {
                String temp = this.specificGravity;

                String[] h = temp.split("-");
                for(int i = 0 ; i< h.length ; i++){
                    if(retValue<Double.parseDouble(h[i].toString())){
                        retValue = Double.parseDouble(h[i].toString());
                    }
                }
            } catch (Exception e){

            }
        }
        return retValue;
    }

    public void setCleavage(String cleavage){this.cleavage = cleavage;}

    public String getCleavage(){return this.cleavage;}

    public int getCleavageToNum(){
        int retval = -1;
        if(this.getCardType() == enumCardType.Play){
            try{
                String temp = this.cleavage;
                retval = getKeyByValue(OneCleavage, temp);
            } catch (Exception ex){
                System.out.println(ex.toString());
            }
        }
        return retval;
    }

    public void setCrustalAbundance(String crustalAbundance){this.crustalAbundance = crustalAbundance;}

    public String getCrustalAbundance(){return this.crustalAbundance;}

    public int getCrustalAbundanceToNum(){
        int retval = -1;
        if(this.getCardType() == enumCardType.Play){
            try {
                String temp = this.crustalAbundance;
                retval = getKeyByValue(OneCrustalAbundance, temp);
            } catch (Exception ex){
            }
        }
        return retval;
    }

    public void setEconomicValue(String economicValue){this.economicValue = economicValue;}

    public String getEconomicValue(){return this.economicValue;}

    public int getEconomicValueToNum(){
        int retval = -1;
        if(this.getCardType() == enumCardType.Play){
            try {
                String temp = this.economicValue;
                retval = getKeyByValue(OneEconomicValue, temp);          //Get Corresponding Integer Value from Enum
            } catch (Exception ex){
            }
        }
        return retval;
    }

    public void setFileName(String fileName){this.fileName = fileName;}

    public String getFileName(){return this.fileName;}

    public void setImageName(String imageName){
        this.imageName = imageName;
    }

    public String getImageName(){return this.imageName;}


    //--------------This is only for Trump Cards--------------
    //public enumCategory getTrumpCategory() { return trumpCategory; }
    public String getTrumpCategory() {
        return trumpCategory;
    }

    public void setTrumpCategory(String trumpCategory) {
        this.trumpCategory = trumpCategory;
    }

    public enumCategory getTrumpCategoryEnum(){
        for (String key : OneCategory.keySet()) {

            //System.out.println(enumCategory.valueOf(OneCategory.get(key)));

            if(this.trumpCategory.equals(OneCategory.get(key))){
                return enumCategory.valueOf(key);
            }

        }
        return null;
    }

    public void setSubTitle(String subTitle){this.subTitle = subTitle;}

    public String getSubTitle(){return this.subTitle;}

    //-------------- END--------------------------------------

    public String toString(){
        String temp = null;
        if(this.getCardType()==enumCardType.Play){
            temp = "=================================================";
            temp += "\nCard ID              : " + this.getCardID();
            temp += "\nCard Title           : " + this.getCardTitle();
            temp += "\nCard Formular        : " + this.getChemistry();
            temp += "\n-------------------------------------------------";
            temp += "\nCard Type            : " + this.getCardType();
            temp += "\n-------------------------------------------------";
            temp += "\nClassification       : " + this.getClassification();
            temp += "\nCrystal System       : " + this.getCrystalSystem();
            temp += "\nOccurrence           : " ;
            for(int i = 0; i < this.getOccurrence().size(); i++){
                temp += "\n\t\t" + this.getOccurrence().get(i);
            }
            temp += "\n-------------------------------------------------";
            temp += "\nHardness             : " + this.getHardness() + " (Value/Max = " + this.getHardnessToNum() + ")";
            temp += "\nSpecific Gravity     : " + this.getSpecificGravity() + " (Value/Max = " + this.getSpecificGravityToNum()+ ")" ;
            temp += "\nCleavage             : " + this.getCleavage() + " (Value/Max = " + this.getCleavageToNum()+ ")" ;
            temp += "\nCrustal Abundance    : " + this.getCrustalAbundance() + " (Value/Max = " + this.getCrustalAbundanceToNum()+ ")" ;
            temp += "\nEconomic Value       : " + this.getEconomicValue() + " (Value/Max = " + this.getEconomicValueToNum()+ ")" ;
            temp += "\n-------------------------------------------------";
        } else {
            temp = "=================================================";
            temp += "\nCard ID              : " + this.getCardID();
            temp += "\nCard Title           : " + this.getCardTitle();
            temp += "\nSub Title            : " + this.getSubTitle();
            temp += "\n-------------------------------------------------";
            temp += "\nCard Type            : " + this.getCardType();
            temp += "\n-------------------------------------------------";
            temp += "\nTrump Category       : " + this.getTrumpCategory();
            temp += "\nTrump Category       : " + this.getTrumpCategoryEnum();

            temp += "\n-------------------------------------------------";
        }
        temp += "\nFile Name            : " + this.getFileName();
        temp += "\nImage Name           : " + this.getImageName();
        temp += "\n=================================================";

        return temp;
    }

    private int getKeyByValue(HashMap<Integer, String> map, String value) {
        for (Integer key : map.keySet()) {
            if(value.equals(map.get(key))){
                return key;
            }
        }
        return -1;
    }
}
