import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainGUI extends JFrame {

    JPanel panWelcome = new JPanel();
    JPanel panelNumberOfPlayers = new JPanel();
    JTextField txtNumOfPlayers = new JTextField(10);
    JPanel panelPlayerNames = new JPanel();
    JPanel panCards = new JPanel(new BorderLayout());
    ArrayList<JPanel> panPlayersCards = new ArrayList<>();
    ArrayList<JButton> btnPlayersCards = new ArrayList<>();
    ArrayList<STPlayer> players = new ArrayList<>();
    ArrayList<JTextField> txtPlayerNames = new ArrayList<>();

    STGame game;

    Color mainColor = new Color(0, 153, 0);
    Font mainFont = new Font("Arial", Font.ITALIC, 22);


    public static void main(String args[]){
        new MainGUI();
    }

    public MainGUI(){
        super("The Mineral Super Trump Card Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        //setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        setPanelNumberOfPlayers();
        pack();
        setVisible(true);
    }

    public void setPanelNumberOfPlayers(){
        panelNumberOfPlayers.setLayout(new FlowLayout());
        panelNumberOfPlayers.setBackground(mainColor);

        JLabel lblWelcome = new JLabel("WELCOME TO THE MINERAL SUPER TRUMP GAME");
        lblWelcome.setFont(new java.awt.Font("Serif", Font.BOLD, 48));
        panelNumberOfPlayers.add(lblWelcome);

        JLabel numQuestion = new JLabel("Please Enter the Number of Players");
        numQuestion.setFont(mainFont);
        panelNumberOfPlayers.add(numQuestion);
        txtNumOfPlayers.setFont(mainFont);
        panelNumberOfPlayers.add(txtNumOfPlayers);

        JButton btnNewGame = new JButton("New Game");
        btnNewGame.setFont(new java.awt.Font("Arial", Font.ITALIC, 26));
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPanelPlayerNames();
            }
        });
        panelNumberOfPlayers.add(btnNewGame);
        this.add(panelNumberOfPlayers);
    }

    private void setPanelPlayerNames() {
        panelPlayerNames.setLayout(new FlowLayout());
        panelPlayerNames.setBackground(mainColor);

        JLabel lblWelcome = new JLabel("WELCOME TO THE MINERAL SUPER TRUMP GAME");
        lblWelcome.setFont(new java.awt.Font("Serif", Font.BOLD, 48));
        panelPlayerNames.add(lblWelcome);

        JPanel smallPlayerName = new JPanel();
        smallPlayerName.setBackground(mainColor);
        panelPlayerNames.add(smallPlayerName);
        for(int i = 1; i < Integer.parseInt(txtNumOfPlayers.getText()) ; i++){
            smallPlayerName.setLayout(new GridLayout((i+4),1));
            JLabel playerQuestion=new JLabel("Enter Player " + (i+1) + " Name:  ");
            smallPlayerName.add(playerQuestion);
            playerQuestion.setFont(mainFont);

            JTextField playerAnswer = new JTextField(30);
            playerAnswer.setFont(mainFont);
            txtPlayerNames.add(playerAnswer);
            smallPlayerName.add(txtPlayerNames.get(i-1));
        }

        JButton btnStart = new JButton("Start The Game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddPlayers();
                NewGame();
            }
        });
        btnStart.setFont(mainFont);
        panelPlayerNames.add(btnStart);

        panWelcome.setVisible(false);
        panelNumberOfPlayers.setVisible(false);
        this.add(panelPlayerNames);
    }

    private void NewGame() {
        game = new STGame();
        game.setPlayers(this.players);

        game.getDeck().ShuffleTheDeck();

        game.DealCardsToEachPlayer();

        //-----------------------------------------
        //------Set Panel for Each Player-----

        panelPlayerNames.setVisible(false);
        //panCards.setLayout(new BoxLayout(panCards, BoxLayout.Y_AXIS));
        //panCards.setVisible(true);

        JPanel panTemp;
        JLabel lblTemp;

        panCards.setLayout(new BoxLayout(panCards, BoxLayout.Y_AXIS));

        for(int j=0; j < game.getPlayers().size(); j++ ){

            panTemp = new JPanel();
            panTemp.setLayout(new BoxLayout(panTemp, BoxLayout.X_AXIS));
            panTemp.setBorder(BorderFactory.createTitledBorder(game.getPlayer(j).getPlayerName()));

            PrintPlayersCardsInHand(j, panTemp);
            panPlayersCards.add(panTemp);
            panCards.add(panPlayersCards.get(j));
        }

        this.add(panCards);
    }

    private void AddPlayers(){
        players.add(new STPlayer(0,"You"));

        for(int i = 0; i < Integer.parseInt(txtNumOfPlayers.getText())-1; i++){
            players.add(new STPlayer(i+1,txtPlayerNames.get(i).getText()));
        }
    }

    private void PrintPlayersCardsInHand(int playerID, JPanel pan) {
        JButton btnTemp;
        for(int i = 0; i < game.getPlayer(playerID).getCardsInHand().size(); i++){
            btnTemp = new JButton(new ImageIcon(((new ImageIcon("images\\" + game.getPlayer(playerID).getCardsInHand().get(i).getImageName() + ".jpg")).getImage()).getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH)));
            pan.add(btnTemp);
        }
    }

}
