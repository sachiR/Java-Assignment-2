import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainGUI extends JFrame {

    JPanel panelNumberOfPlayers = new JPanel();
    JTextField txtNoOfPlayers = new JTextField(5);
    JPanel panelPlayerNames = new JPanel();
    JPanel panCards = new JPanel(new BorderLayout());
    JPanel panGameInfo = new JPanel();

    ArrayList<JPanel> panPlayersCards = new ArrayList<>();
    ArrayList<STPlayer> players = new ArrayList<>();
    ArrayList<JTextField> txtPlayerNames = new ArrayList<>();
    ArrayList<JButton> btnPlayersCards = new ArrayList<>();

    STGame game;

    JLabel lblDealerName = new JLabel();
    JLabel lblNextPlayerName = new JLabel();
    JLabel lblTrumpCategory = new JLabel();
    JLabel lblTrumpValue = new JLabel();
    JButton btnLastPlayCard = new JButton();

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

        setpanelNumberOfPlayers();
        pack();
        setVisible(true);
    }

    public void setpanelNumberOfPlayers(){
        panelNumberOfPlayers.setLayout(new FlowLayout());
        panelNumberOfPlayers.setBackground(mainColor);

        JLabel lblWelcome = new JLabel("WELCOME TO THE MINERAL SUPER TRUMP GAME");
        lblWelcome.setFont(new java.awt.Font("Serif", Font.BOLD, 48));
        panelNumberOfPlayers.add(lblWelcome);

        JLabel numQuestion = new JLabel("Please Enter the Number of Players");
        numQuestion.setFont(mainFont);
        panelNumberOfPlayers.add(numQuestion);
        txtNoOfPlayers.setFont(mainFont);
        panelNumberOfPlayers.add(txtNoOfPlayers);

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

        for (int i = 1; i < Integer.parseInt(txtNoOfPlayers.getText()); i++) {
            smallPlayerName.setLayout(new GridLayout((i + 4), 1));
            JLabel playerQuestion = new JLabel("Enter Player " + i + " Name:  ");
            smallPlayerName.add(playerQuestion);
            playerQuestion.setFont(mainFont);

            JTextField playerAnswer = new JTextField(30);
            playerAnswer.setFont(mainFont);
            txtPlayerNames.add(playerAnswer);
            smallPlayerName.add(txtPlayerNames.get(i - 1));
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

        panelNumberOfPlayers.setVisible(false);
        this.add(panelPlayerNames);
    }

    private void NewGame() {
        game = new STGame();
        game.setPlayers(this.players);

        game.getDeck().ShuffleTheDeck();

        game.DealCardsToEachPlayer();
        panCards.setBackground(mainColor);

        panCards.setLayout(new BoxLayout(panCards, BoxLayout.Y_AXIS));
        CreateCardPanelForEachPlayer();
        CreateGameInfoPanel();

        this.add(panCards);
    }

    private void CreateCardPanelForEachPlayer(){
        panelPlayerNames.setVisible(false);

        JPanel panTemp;

        //panCards.setLayout(new BoxLayout(panCards, BoxLayout.Y_AXIS));

        for(int j=0; j < game.getPlayers().size(); j++ ){
            panTemp = new JPanel();
            panTemp.setBackground(mainColor);
            panTemp.setLayout(new BoxLayout(panTemp, BoxLayout.X_AXIS));
            panTemp.setBorder(BorderFactory.createTitledBorder(game.getPlayer(j).getPlayerName()));

            PrintPlayersCardsInHand(j, panTemp);

            panPlayersCards.add(panTemp);
            panCards.add(panPlayersCards.get(j));
        }

    }

    private void CreateGameInfoPanel() {
        panGameInfo.setBackground(mainColor);
        panGameInfo.setLayout(new BoxLayout(panGameInfo, BoxLayout.LINE_AXIS));
        panGameInfo.setBorder(BorderFactory.createTitledBorder("CURRENT GAME INFORMATION"));

        lblDealerName.setText(" DEALER : " + game.getPlayer(game.getDealerID()).getPlayerName());
        lblNextPlayerName.setText("Next Player : " + game.getPlayer(game.getNextPlayer()).getPlayerName());

        panGameInfo.add(lblDealerName);
        panGameInfo.add(lblNextPlayerName);

        panGameInfo.add(btnLastPlayCard);

        panPlayersCards.add(panGameInfo);
        int size = panPlayersCards.size() - 1;
        panCards.add(panPlayersCards.get(size));

        JButton btnPassGame = new JButton("Pass");
        panCards.add(btnPassGame);
        btnPassGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                STCard card = game.drawCardFromDeck(0);
                if (card != null) {
                    PrintPlayersCardsInHand(0, panPlayersCards.get(0));
                } else {
                    int result = JOptionPane.showConfirmDialog(null, "Sorry No More Cards Available In The Deck \n Would You Like To Play A New Game", "No More Cards", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        removeAll();
                        new MainGUI();
                    }
                }
            }
        });
    }

    private void AddPlayers(){
        players.add(new STPlayer(0,"You"));

        for(int i = 0; i < Integer.parseInt(txtNoOfPlayers.getText())-1; i++){
            players.add(new STPlayer(i+1,txtPlayerNames.get(i).getText()));
        }
    }

    private void PrintPlayers() {
        for(int i = 0; i < Integer.parseInt(txtNoOfPlayers.getText()); i++){
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
        if(playerID == 0) {
            button.setIcon(game.getPlayer(playerID).getCardsInHand().get(cardID).getCardBottomImage());
            //button.setIcon(new ImageIcon(((new ImageIcon("images\\" + game.getPlayer(playerID).getCardsInHand().get(cardID).getImageName() + ".jpg")).getImage()).getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH)));
        } else {
            button.setIcon(game.getPlayer(playerID).getCardsInHand().get(cardID).getCardTopImage());
            //button.setIcon(new ImageIcon(((new ImageIcon("images\\Slide66.jpg")).getImage()).getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH)));
        }

        button.setName(String.valueOf(game.getPlayer(playerID).getCardsInHand().get(cardID).getCardID()));
        button.putClientProperty("playerID", Integer.valueOf(playerID));

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

        panGameInfo.remove(btnLastPlayCard);
        btnLastPlayCard = (JButton)e.getSource();

        int playerid = -1;
        Object property = btnLastPlayCard.getClientProperty("playerID");
        if (property instanceof Integer) {
            playerid = ((Integer)property);
            // do stuff
        }

        int cardid = Integer.parseInt(btnLastPlayCard.getName());
        //int playerid = Integer.parseInt(btnLastPlayCard.getText());

        int index = GetIndexByCardID(playerid, cardid);

        ImageIcon img = game.getPlayer(playerid).getCardsInHand().get(index).getCardBottomImage();

        btnLastPlayCard.setIcon(img);

        panGameInfo.add(btnLastPlayCard);

        panPlayersCards.get(playerid).remove(btnLastPlayCard);
        panPlayersCards.get(playerid).revalidate();
        panPlayersCards.get(playerid).repaint();

        //=== Remove Card from Player ===
        game.getPlayer(playerid).getCardsInHand().remove(index);
    }

    private int GetIndexByCardID(int playerID, int cardID){
        for(int i = 0; i<game.getPlayer(playerID).getCardsInHand().size(); i++){
            if(game.getPlayer(playerID).getCardsInHand().get(i).getCardID() == cardID ){return i;}
        }
        return -1;
    }
}
