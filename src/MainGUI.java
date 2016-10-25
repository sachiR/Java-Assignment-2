import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainGUI extends JFrame {
    private static final int CARD_WIDTH = 60;
    private static final int CARD_HEIGHT = 90;

    JPanel panWelcome = new JPanel();
    JPanel panelNumberOfPlayers = new JPanel();
    JTextField txtNumOfPlayers = new JTextField(10);
    JPanel panelPlayerNames = new JPanel();
    JPanel panCards = new JPanel(new BorderLayout());
    ArrayList<JPanel> panPlayersCards = new ArrayList<>();
    ArrayList<JButton> btnPlayersCards = new ArrayList<>();
    ArrayList<STPlayer> players = new ArrayList<>();
    ArrayList<JTextField> txtPlayerNames = new ArrayList<>();

    JLabel lblDealerName = new JLabel();
    JLabel lblNextPlayerName = new JLabel();
    JLabel lblTrumpCategory = new JLabel();
    JLabel lblTrumpValue = new JLabel();
    JButton btnLastPlayCard = new JButton();
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
            JLabel playerQuestion=new JLabel("Enter Player " + i + " Name:  ");
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


        panCards.setLayout(new BoxLayout(panCards, BoxLayout.Y_AXIS));
        CreateCardPanelForEachPlayer();
        CreatePlayGamePanel();

        this.add(panCards);
    }
    private void CreateCardPanelForEachPlayer(){
        panelPlayerNames.setVisible(false);

        JPanel panTemp;

        //panCards.setLayout(new BoxLayout(panCards, BoxLayout.Y_AXIS));

        for(int j=0; j < game.getPlayers().size(); j++ ){

            panTemp = new JPanel();
            panTemp.setLayout(new BoxLayout(panTemp, BoxLayout.X_AXIS));
            panTemp.setBorder(BorderFactory.createTitledBorder(game.getPlayer(j).getPlayerName()));

            PrintPlayersCardsInHand(j, panTemp);

            panPlayersCards.add(panTemp);
            panCards.add(panPlayersCards.get(j));
        }

    }

    private void CreatePlayGamePanel(){
        JPanel panTemp = new JPanel();
        panTemp.setLayout(new BoxLayout(panTemp, BoxLayout.LINE_AXIS));
        panTemp.setBorder(BorderFactory.createTitledBorder("CURRENT GAME INFORMATION"));

        lblDealerName.setText(" DEALER : " + game.getPlayer(game.getDealerID()).getPlayerName());
        lblNextPlayerName.setText(" Next Player : " + game.getPlayer(game.getNextPlayer()).getPlayerName());

        panTemp.add(lblDealerName);
        panTemp.add(lblNextPlayerName);

        panPlayersCards.add(panTemp);
        int size = panPlayersCards.size()-1;
        panCards.add(panPlayersCards.get(size));

    }

    private void AddPlayers(){
        players.add(new STPlayer(0,"You"));

        for(int i = 0; i < Integer.parseInt(txtNumOfPlayers.getText())-1; i++){
            players.add(new STPlayer(i+1,txtPlayerNames.get(i).getText()));
        }
    }
    private void PrintPlayers() {
        for(int i = 0; i < Integer.parseInt(txtNumOfPlayers.getText()); i++){
            System.out.println(" Player   ID : " + players.get(i).getPlayerID());
            System.out.println(" Player Name : " + players.get(i).getPlayerName());
        }
        System.out.println();
    }
    private void PrintPlayersCardsInHand(int playerID, JPanel pan) {
        JButton btnTemp;
        for(int i = 0; i < game.getPlayer(playerID).getCardsInHand().size(); i++){
            btnTemp = createButton(playerID, i);
            pan.add(btnTemp);
        }
    }

    private JButton createButton(int playerID, int cardID) {
        JButton button = new JButton();
        //JButton button = new JButton(new ImageIcon(((new ImageIcon("images\\" + game.getPlayer(playerID).getCardsInHand().get(cardID).getImageName() + ".jpg")).getImage()).getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH)));
        if(playerID == 0) {
            button.setIcon(new ImageIcon(((new ImageIcon("images\\" + game.getPlayer(playerID).getCardsInHand().get(cardID).getImageName() + ".jpg")).getImage()).getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH)));
        } else {
            button.setIcon(new ImageIcon(((new ImageIcon("images\\Slide66.jpg")).getImage()).getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH)));
        }

        button.setName(String.valueOf(game.getPlayer(playerID).getCardsInHand().get(cardID).getCardID()));

        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnClick(e);
            }
        });
        return button;
    }

    private void btnClick(ActionEvent e){

        /*
        btnLastPlayCard = btnPlayersCards.get(Integer.parseInt(((JComponent) e.getSource()).getName()));
        panPlayersCards.get(panPlayersCards.size()-1).add(btnLastPlayCard);
        */

        JOptionPane.showMessageDialog(null, "You clicked on Card ID " + ((JComponent) e.getSource()).getName() , "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
    }
}
