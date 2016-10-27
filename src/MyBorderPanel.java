import javax.swing.*;
import java.awt.*;

public class MyBorderPanel extends JPanel {
    public MyBorderPanel(String label){
        //this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        //this.setBorder(BorderFactory.createTitledBorder("WELCOME TO SUPER TRUMP GAME"));

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder(label));

    }
}
