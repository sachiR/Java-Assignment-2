package dim.game;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;



public class Cards {
    //Specifying keys of the mineral cards
    private String title, chemistry,classification,crystalSystem,occurrence,cleavage,crustalAbundance,economicValue;
    private  double hardness,specificGravity;
    private BufferedImage cardImage;

    //The constructor for Cards class
    public Cards(String title,String chemistry,String classification,String system,String occurrence,String cleavage,String abundance,String value,double hardness,double gravity, BufferedImage image){
        this.title = title;
        this.chemistry = chemistry;
        this.classification = classification;
        this.crystalSystem = system;
        this.occurrence = occurrence ;
        this.cleavage = cleavage;
        this.crustalAbundance = abundance;
        this.economicValue = value;
        this.hardness = hardness;
        this.specificGravity = gravity;
        this.cardImage = image;
    }

    public double Hardness(){
        return hardness;
    }// ends Hardness()

    public double Gravity(){
        return specificGravity;
    }// ends Gravity()

    public String Cleavage(){
        return cleavage;
    }//ends Cleavage()

    public String Abundance(){
        return crustalAbundance;
    }//ends Abundance()

    public String Value(){
        return economicValue;
    }//ends Value()

    public BufferedImage GetCardImage(){
        return cardImage;
    }//ends GetCardImage()

    public static void main(String args[]) throws IOException {
        // need to change occurrence to array
        Cards Quartz = new Cards("Quartz","SiO_2","tectosilicate","hexagonal","igneous,metamorphic,sedimentary","poor/none","high","moderate",7,2.65, ImageIO.read(new File("C:\\Users\\Sachini\\Documents\\GitHub\\Java-Assignment-2\\src\\dim\\game\\images\\Slide01.jpg")));

        //create a JFrame to display the card
        JFrame window = new JFrame("trump of mineral");
        window.setSize(400,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        //create a JPanel
        JPanel contentPane = new JPanel(new BorderLayout());

        //create a JLabel
        JLabel cardLabel = new JLabel(new ImageIcon(Quartz.GetCardImage()));
        cardLabel.setSize(300,400);

        contentPane.add(cardLabel);
        window.add(contentPane);
    } //MainGUI() ends here
} //class ends here

