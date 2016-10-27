import javax.swing.*;
import java.awt.*;

public class PanelNumberOfPlayers extends JPanel {

    public PanelNumberOfPlayers(String label){
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createTitledBorder(label));
    }
}
