package dim.game.A1;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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

    private HashMap<Integer, String> _lstCleavage = new HashMap<Integer, String>() {
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
    private HashMap<Integer, String> _lstCrustalAbundance = new HashMap<Integer, String>() {
        {   put(0,"ultratrace");
            put(1,"trace");
            put(2,"low");
            put(3,"moderate");
            put(4,"high");
            put(5,"very high");
        }
    };
    private HashMap<Integer, String> _lstEconomicValue = new HashMap<Integer, String>() {
        {   put(0,"trivial");
            put(1,"low");
            put(2,"moderate");
            put(3,"high");
            put(4,"very high");
            put(5,"i`m rich");
        }
    };
    private HashMap<String, String> _lstCategory = new HashMap<String, String>() {
        {   put(enumCategory.Hardness.toString() ,  "Hardness");
            put(enumCategory.Specific_Gravity.toString() ,  "Specific gravity");
            put(enumCategory.Cleavage.toString() ,  "Cleavage");
            put(enumCategory.Crustal_Abundance.toString() ,  "Crustal abundance");
            put(enumCategory.Economic_Value.toString() ,  "Economic value");
        }
    };

    private int                 _cardID;
    private enumCardType        _cardType;

    private String              _cardTitle;
    private String              _chemistry;
    private String              _classification;
    private String              _crystalSystem;
    private ArrayList<String>   _occurrence;

    private String              _hardness;
    private String              _specificGravity;
    private String              _cleavage;
    private String              _crustalAbundance;
    private String              _economicValue;

    private String              _trumpCategory;

    private String              _fileName;
    private String              _imageName;

    private String              _subTitle;

    //private HashMap<String, List<String>> _cardProperties;

    public STCard(){}
    public STCard(int cardID, String cardTitle){
        this();
        this._cardID = cardID;
        this._cardType = enumCardType.Play;
        this._cardTitle = cardTitle;
    }
    public STCard(int cardID, String cardTitle, String trumpCategory){
        this();
        this._cardID = cardID;
        this._cardType = enumCardType.Trump;
        this._cardTitle = cardTitle;

        //this._trumpCategory = trumpCategory;
    }


    public int getCardID(){return this._cardID;}

    public enumCardType getCardType(){return this._cardType;}

    public  String getCardTitle(){return this._cardTitle;}
    public void setCardTitle(String cardTitle){this._cardTitle = cardTitle;}

    public void setChemistry(String Chemistry){this._chemistry = Chemistry;}
    public String getChemistry(){return this._chemistry;};

    public void setClassification(String Classification){this._classification = Classification;}
    public String getClassification(){return this._classification;}

    public void setCrystalSystem(String crystalSystem){this._crystalSystem = crystalSystem;}
    public String getCrystalSystem(){return this._crystalSystem;}

    public void setOccurrence(ArrayList<String> occurrence){this._occurrence = occurrence;}
    public ArrayList<String> getOccurrence(){return this._occurrence;}


    public void setHardness(String hardness){this._hardness = hardness;}
    public String getHardness(){return this._hardness;}
    public Double getHardnessToNum(){
        Double retValue = -1.0;
        if(this.getCardType()==enumCardType.Play){
            try {
                String temp = this._hardness;
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

    public void setSpecificGravity(String specificGravity){this._specificGravity = specificGravity;}
    public String getSpecificGravity(){return this._specificGravity;}
    public Double getSpecificGravityToNum(){
        Double retValue = -1.0;
        if(this.getCardType() == enumCardType.Play){
            try {
                String temp = this._specificGravity;

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

    public void setCleavage(String cleavage){this._cleavage = cleavage;}
    public String getCleavage(){return this._cleavage;}
    public int getCleavageToNum(){
        int retval = -1;
        if(this.getCardType() == enumCardType.Play){
            try{
                String temp = this._cleavage;
                retval = getKeyByValue(_lstCleavage, temp);
                //retval = getKeyByValue(_lstCleavage, temp);
            } catch (Exception ex){
                System.out.println(ex.toString());
            }
        }
        return retval;
    }

    public void setCrustalAbundance(String crustalAbundance){this._crustalAbundance = crustalAbundance;}
    public String getCrustalAbundance(){return this._crustalAbundance;}
    public int getCrustalAbundanceToNum(){
        int retval = -1;
        if(this.getCardType() == enumCardType.Play){
            try {
                String temp = this._crustalAbundance;
                retval = getKeyByValue(_lstCrustalAbundance, temp);
            } catch (Exception ex){
            }
        }
        return retval;
    }

    public void setEconomicValue(String economicValue){this._economicValue = economicValue;}
    public String getEconomicValue(){return this._economicValue;}
    public int getEconomicValueToNum(){
        int retval = -1;
        if(this.getCardType() == enumCardType.Play){
            try {
                String temp = this._economicValue;
                retval = getKeyByValue(_lstEconomicValue, temp);          //Get Corresponding Integer Value from Enum
            } catch (Exception ex){
            }
        }
        return retval;
    }

    public void setFileName(String fileName){this._fileName = fileName;}
    public String getFileName(){return this._fileName;}

    public void setImageName(String imageName){this._imageName = imageName;}
    public String getImageName(){return this._imageName;}


    //--------------This is only for Trump Cards--------------
    //public enumCategory getTrumpCategory() { return _trumpCategory; }
    public String getTrumpCategory() {
        return _trumpCategory;
    }
    public void setTrumpCategory(String trumpCategory) {
        this._trumpCategory = trumpCategory;
    }
    public enumCategory getTrumpCategoryEnum(){
        for (String key : _lstCategory.keySet()) {

            //System.out.println(enumCategory.valueOf(_lstCategory.get(key)));

            if(this._trumpCategory.equals(_lstCategory.get(key))){
                return enumCategory.valueOf(key);
            }

        }
        return null;
    }

    public void setSubTitle(String subTitle){this._subTitle = subTitle;}
    public String getSubTitle(){return this._subTitle;}

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
            temp += "\nCccurrence           : " ;
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
