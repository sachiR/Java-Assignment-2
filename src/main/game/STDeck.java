package main.game;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;

public class STDeck {
    private static final int NUMBER_OF_TIMES_TO_SHUFFLE = 500;
    private static final int NUMBER_OF_CARDS = 60;

    private ArrayList<STCard> _cards = new ArrayList<STCard>();

    public ArrayList<STCard> getCards() { return _cards; }
    public STCard getCard(int index){return _cards.get(index);}

    private int cardid = 0;

    public STDeck() {
        ReadXML("C:\\Users\\Sachini\\Documents\\GitHub\\Java-Assignment-2\\src\\Resources\\MstCards_151021.xml");
        //ReadXML("MstCards_151021.xml");
    }

    public void ShuffleTheDeck() {
        Random rnd = new Random();
        for(int i = 0; i< NUMBER_OF_TIMES_TO_SHUFFLE; i++)
        {
            int i1 = rnd.nextInt(NUMBER_OF_CARDS-1);
            int i2 = rnd.nextInt(NUMBER_OF_CARDS-1);

            Collections.swap(_cards,i1,i2);
        }
    }

    private void ReadXML(String fileName){

        HashMap<String,ArrayList<String>> card;
        try {

            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("dict");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node node = nList.item(temp);
                //System.out.println("\nCurrent Element :"+node.getNodeName());
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element)node ;
                    if(!(element.getElementsByTagName("key").item(0).getTextContent().equals("cards"))){
                        card = getcardDetails(element);
                        if(card.size()> 0){

                            AddToDeck(card);
                        }
                    }
                }
            }
            //System.out.println("for the breakpoint");
        } catch (Exception e) {
            //System.out.println(e.toString());
            e.printStackTrace();
        }
    }
    private  HashMap<String,ArrayList<String>> getcardDetails(Element element){
        HashMap<String,ArrayList<String>> tempCard = new  HashMap<String,ArrayList<String>> ();
        String cardType = element.getElementsByTagName("key").item(3).getTextContent();
        int occurenceValues = element.getElementsByTagName("string").getLength() - 11;
        int delta = 0;

        //get card details for all cards except "rule" cards
        for (int count=0;(count < element.getElementsByTagName("key").getLength() && (!cardType.equals("rule")));count++){
            //add filename and imagename
            String key = element.getElementsByTagName("key")
                    .item(count)
                    .getTextContent();
            ArrayList<String> values = new ArrayList<String>();
            if(count<2){
                values.add(element.getElementsByTagName("string")
                        .item(count)
                        .getTextContent());
                tempCard.put(key,values);
                continue;
            }
            //add card_type
            if(count==2){
                values.add(element.getElementsByTagName("key")
                        .item(count+1)
                        .getTextContent());
                tempCard.put(key,values);
                continue;
            }
            //add title,chemistry,classification,crystal_system, occurrence,hardness,specific_gravity,
            // cleavage,crustal_abundance and economic_value
            if(count>3){
                if (key.equals("occurrence")){
                    for(int temp =0; temp < occurenceValues; temp++){
                        values.add(element.getElementsByTagName("string")
                                .item((count-2)+temp)
                                .getTextContent());
                        delta++;
                    }
                    delta--;
                }
                else{
                    values.add(element.getElementsByTagName("string")
                            .item(count-2+delta)
                            .getTextContent());
                }
                tempCard.put(key,values);
                continue;
            }
        }
        return tempCard;
    }

    private void AddToDeck(HashMap<String,ArrayList<String>> tempCard){
        STCard card;  // = new STCard();
        ArrayList<String> temp = new ArrayList<>();

        String type = tempCard.get("card_type").get(0);
        String title = tempCard.get("title").get(0);

        if(type.equalsIgnoreCase("play")){
            card = new STCard(cardid,title);
            card.setChemistry(tempCard.get("chemistry").get(0));
            card.setClassification(tempCard.get("classification").get(0));
            card.setCrystalSystem(tempCard.get("crystal_system").get(0));
            card.setHardness(tempCard.get("hardness").get(0));
            card.setSpecificGravity(tempCard.get("specific_gravity").get(0));
            card.setCleavage(tempCard.get("cleavage").get(0));
            card.setCrustalAbundance(tempCard.get("crustal_abundance").get(0));
            card.setEconomicValue(tempCard.get("economic_value").get(0));

            for(int i = 0; i < tempCard.get("occurrence").size(); i++ ){
                temp.add(tempCard.get("occurrence").get(i) );
            }
            card.setOccurrence(temp);

        } else {
            card = new STCard(cardid, title, tempCard.get("subtitle").get(0));
            card.setSubTitle(tempCard.get("subtitle").get(0));
            card.setTrumpCategory(tempCard.get("subtitle").get(0));
        }
        card.setFileName(tempCard.get("fileName").get(0));
        card.setImageName(tempCard.get("imageName").get(0));

        this._cards.add(card);
        cardid++;
    }

}

