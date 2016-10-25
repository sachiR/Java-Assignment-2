import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainGUI extends JFrame {

    JPanel panWelcome = new JPanel();
    JPanel panelNumberOfPlayers = new JPanel();
    JPanel panUser = new JPanel();
    JTextField txtNoofPlayers = new JTextField(5);
    JPanel panelPlayerNames = new JPanel();

    //ArrayList<JLabel> lblCardsInPlayersHand = new ArrayList<>();
    //ArrayList<JPanel> panPlayersCards = new ArrayList<>();
    ArrayList<JLabel> btnpc = new ArrayList<>();
    ArrayList<STPlayer> players = new ArrayList<>();
    ArrayList<JTextField> txtPlayerNames = new ArrayList<>();

    STGame game;


    public static void main(String args[]){
        new MainGUI();
    }

    public MainGUI(){
        super("Super Trump Card Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setpanWelcome();
        add(panWelcome);

        setpanelNumberOfPlayers();

        pack();
        setVisible(true);
    }

    public void setpanWelcome() {
        panWelcome.setLayout(new FlowLayout());
        JLabel lblWelcome = new JLabel("WELCOME TO -----");
        panWelcome.add(lblWelcome);
    }
    public void setpanelNumberOfPlayers(){
        panelNumberOfPlayers.setLayout(new FlowLayout());
        panelNumberOfPlayers.add(new JLabel("Number of Players :"));
        panelNumberOfPlayers.add(txtNoofPlayers);

        JButton btnNewGame = new JButton("New Game");
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setpanelPlayerNames();
            }
        });
        panelNumberOfPlayers.add(btnNewGame);
        //panal1.add(panelNumberOfPlayers);
        this.add(panelNumberOfPlayers);

        //return panelNumberOfPlayers;
    }
    private void setpanelPlayerNames() {
        panelPlayerNames.setLayout(new FlowLayout());

        for(int i = 1; i < Integer.parseInt(txtNoofPlayers.getText()) ; i++){
            panelPlayerNames.add(new JLabel("Name of the Player " + i));
            txtPlayerNames.add(new JTextField(30));
            panelPlayerNames.add(txtPlayerNames.get(i-1));
        }
        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPlayers();
                NewGame();
            }
        });
        panelPlayerNames.add(btnStart);

        panWelcome.setVisible(false);
        panelNumberOfPlayers.setVisible(false);
        //panelPlayerNames.setVisible(true);
        //return panelPlayerNames;
        this.add(panelPlayerNames);
    }

    private void NewGame() {
        game = new STGame();
        game.setPlayers(this.players);

        game.getDeck().ShuffleTheDeck();

        game.DealCardsToEachPlayer();

        //-----------------------------------------
        //JPanel panTemp = new JPanel();
        panUser.setLayout(new FlowLayout());
        JLabel lblTemp = new JLabel(game.getPlayer(0).getPlayerName());
        JLabel btnTemp;

        for(int i = 0; i < game.getPlayer(0).getCardsInHand().size(); i++){
            btnTemp = new JLabel();
            btnTemp = new JLabel(new ImageIcon(((new ImageIcon("images\\" + game.getPlayer(0).getCardsInHand().get(i).getImageName() + ".jpg")).getImage()).getScaledInstance(180, 260, java.awt.Image.SCALE_SMOOTH)));
            btnpc.add(btnTemp);
            panUser.add(btnpc.get(i));
        }

        panUser.add(lblTemp);

        //panPlayersCards.add(panTemp);
        //panPlayersCards.get(0).setVisible(true);
        panelPlayerNames.setVisible(false);
        panUser.setVisible(true);
        this.add(panUser);
        //=============================================

    }

    private void AddPlayers(){
        players.add(new STPlayer(0,"You"));

        for(int i = 0; i < Integer.parseInt(txtNoofPlayers.getText())-1; i++){
            players.add(new STPlayer(i+1,txtPlayerNames.get(i).getText()));
        }

        //PrintPlayers();
    }
//    private void PrintPlayers() {
//        for(int i = 0; i < Integer.parseInt(txtNoofPlayers.getText()); i++){
//            System.out.println(" Player   ID : " + players.get(i).getPlayerID());
//            System.out.println(" Player Name : " + players.get(i).getPlayerName());
//        }
//        System.out.println();
//    }

}
