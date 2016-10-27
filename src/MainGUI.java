import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainGUI extends JFrame {

    JPanel panelNumberOfPlayers = new JPanel();
    JTextField txtNoOfPlayers = new JTextField(5);
    JPanel panelPlayerNames = new JPanel();
    JPanel panCards = new JPanel(new BorderLayout());
    JPanel panGameInfo = new JPanel();
    Container con = getContentPane();
    JPanel north = new JPanel();
    JPanel centre = new JPanel();
    JPanel east = new JPanel();
    JPanel west = new JPanel();
    JPanel south = new JPanel();
    JPanel lbls = new JPanel();

    JPanel panel1= new JPanel();
    JPanel panel2= new JPanel();
    JPanel panel3= new JPanel();
    JPanel panel4= new JPanel();
    JPanel panel5= new JPanel();
    JPanel panel6= new JPanel();
    JPanel panel7 = new JPanel();

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
    JButton btnPlayNextCard = new JButton("Play Next Card");
    JButton btnPass = new JButton("Pass");

    JRadioButton optTrumpCat01 = new JRadioButton(STCard.enumCategory.Hardness.toString());
    JRadioButton optTrumpCat02 = new JRadioButton(STCard.enumCategory.Specific_Gravity.toString());
    JRadioButton optTrumpCat03 = new JRadioButton(STCard.enumCategory.Cleavage.toString());
    JRadioButton optTrumpCat04 = new JRadioButton(STCard.enumCategory.Crustal_Abundance.toString());
    JRadioButton optTrumpCat05 = new JRadioButton(STCard.enumCategory.Economic_Value.toString());

    Color mainColor = new Color(0, 153, 0);
    Font mainFont = new Font("Arial", Font.ITALIC, 22);

    public static void main(String args[]){
        new MainGUI();
    }

    public MainGUI(){
        super("The Mineral Super Trump Card Game");
        setDefaultCloseOperation(MainGUI.EXIT_ON_CLOSE);
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
            playerAnswer.setText("Player " + i);
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

        north.setBackground(mainColor);
        north.setPreferredSize(new Dimension(80,80));
        north.setLayout(new GridLayout());
        add(north, BorderLayout.NORTH);

        south.setBackground(mainColor);
        south.setPreferredSize(new Dimension(200,200));
        south.setLayout(new GridLayout());
        add(south, BorderLayout.SOUTH);

        east.setBackground(mainColor);
        east.setPreferredSize(new Dimension(100,100));
        east.setLayout(new GridLayout());
        add(east, BorderLayout.EAST);

        west.setBackground(mainColor);
        west.setPreferredSize(new Dimension(100,100));
        west.setLayout(new GridLayout());
        add(west, BorderLayout.WEST);

        centre.setBackground(mainColor);
        centre.setLayout(new GridLayout());
        add(centre, BorderLayout.CENTER);

        panel1.setBackground(mainColor);
        north.add(panel1);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));

        panel2.setBackground(mainColor);
        north.add(panel2);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));

        panel3.setBackground(mainColor);
        east.add(panel3);
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

        panel4.setBackground(mainColor);
        west.add(panel4);
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));

        panel5.setBackground(mainColor);
        south.add(panel5);
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.X_AXIS));

        panel6.setBackground(mainColor);
        panel6.setLayout(new BorderLayout());
        centre.add(panel6);

        panel7.setBackground(mainColor);
        panel7.setLayout(new GridLayout());
        panel6.add(panel7, BorderLayout.SOUTH);

        CreateGameInfoPanel();
        CreateCardPanelForEachPlayer();
    }

    private void CreateCardPanelForEachPlayer(){
        panelPlayerNames.setVisible(false);
        JPanel panTemp = new JPanel();
        //panTemp.setLayout(new BoxLayout(panTemp, BoxLayout.Y_AXIS ));
        for (int i = 0; i <  game.getPlayers().size(); i++){
            panTemp = new JPanel();
            panTemp.setFont(mainFont);
            panTemp.setBackground(mainColor);
            panTemp.setBorder(BorderFactory.createTitledBorder(game.getPlayer(i).getPlayerName()));

            PrintPlayersCardsInHand(i, panTemp);
            panPlayersCards.add(panTemp);
        }
        if (game.getPlayers().size() == 3) {
            panel5.add(panPlayersCards.get(0));
            panel3.add(panPlayersCards.get(1));
            panel4.add(panPlayersCards.get(2));
        } else if (game.getPlayers().size() == 4){
            panel5.add(panPlayersCards.get(0));
            panel3.add(panPlayersCards.get(1));
            panel4.add(panPlayersCards.get(2));
            panel2.add(panPlayersCards.get(3));
        } else if (game.getPlayers().size() == 5) {
            panel5.add(panPlayersCards.get(0));
            panel3.add(panPlayersCards.get(1));
            panel2.add(panPlayersCards.get(2));
            panel1.add(panPlayersCards.get(3));
            panel4.add(panPlayersCards.get(4));
        } else{
            int input = JOptionPane.showOptionDialog(null, "Sorry invalid number of players please enter again", "Invalid Value", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if(input == JOptionPane.OK_OPTION)
            {
                con.removeAll();
                con.revalidate();
                con.repaint();
                new MainGUI();
            }
        }
    }

    private void CreateGameInfoPanel(){
        //panGameInfo.setLayout(new BoxLayout(panGameInfo, BoxLayout.LINE_AXIS));
        panGameInfo.setBackground(mainColor);
        panGameInfo.setLayout(new GridLayout());
        panGameInfo.setBorder(BorderFactory.createTitledBorder("CURRENT GAME INFORMATION"));

        //panLastCardInfo.setBorder(BorderFactory.createTitledBorder("LAST CARD PLAYED"));
        lblDealerName.setText("DEALER : " + game.getPlayer(game.getDealerID()).getPlayerName() + "  |");
        lblNextPlayerName.setText("Next Player : " + game.getPlayer(game.getNextPlayerID()).getPlayerName()+ "  |");
//        lblTrumpCategory.setText(" Trump Category : " + game.getTrumpCategory()+ "|");
//        lblTrumpValue.setText(" Max Value : " );

        lbls.setBackground(mainColor);
        panGameInfo.add(lbls, BorderLayout.LINE_START);

        lbls.add(lblDealerName);
        lbls.add(lblNextPlayerName);
        lbls.add(lblTrumpCategory);
        lbls.add(lblTrumpValue);

        //btnLastPlayCard.setIcon(new STCard().getCardTopImage());

        CreateTrumpOptionGroup();

        btnPlayNextCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPlayNextCard_Clicked(e);
            }
        });
        panel7.add(btnPlayNextCard);

        btnPass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPass_Clicked(e);
            }
        });
        panel7.add(btnPass);

        //JButton b = new JButton();
        //btnLastPlayCard.setIcon(new STCard().getCardTopImage());

        //panGameInfo.add(panLastCardInfo.add(btnLastPlayCard));

        panel6.add(panGameInfo);
//        int size = panPlayersCards.size()-1;
//        panCards.add(panPlayersCards.get(size));

    }

    private void UpdateGameInfoPanel(){

        UpdateTrumpSelectedOption();

        lblNextPlayerName.setText("Next Player : " + game.getPlayer(game.getNextPlayerID()).getPlayerName()+ "  |");
        lblTrumpCategory.setText("Trump Category : " + game.getTrumpCategory()+ "  |");
        lblTrumpValue.setText("Max Value : " + game.getTrumpValue()+ "  |");

        btnLastPlayCard.setIcon(game.getLastPlayCard().getCardBottomImage());
        lbls.add(btnLastPlayCard,BorderLayout.CENTER);


        //panGameInfo.revalidate();
        //panGameInfo.repaint();

    }



    private void btnPass_Clicked(ActionEvent e) {
        STCard card = game.GetCardFromDeck();
        //int npid
        game.getPlayer(0).getCardsInHand().add(card);

        JButton btn = createButton(game.getNextPlayerID(), game.getPlayer(0).getCardsInHand().size()-1);
        btnPlayersCards.add(btn);

        panPlayersCards.get(0).add(btn);

        game.ChangePlayer();

        panPlayersCards.get(0).revalidate();
        panPlayersCards.get(0).repaint();

        UpdateGameInfoPanel();
    }

    private void btnPlayNextCard_Clicked(ActionEvent e) {

        STCard stcard = game.PlayRandomCard(game.getNextPlayerID());
        if(stcard == null || game.getNextPlayerID() != 0 ){
            STCard card = game.GetCardFromDeck();
            //int npid
            game.getPlayer(game.getNextPlayerID()).getCardsInHand().add(card);

            JButton btn = createButton(game.getNextPlayerID(), game.getPlayer(game.getNextPlayerID()).getCardsInHand().size()-1);
            btnPlayersCards.add(btn);

            panPlayersCards.get(game.getNextPlayerID()).add(btn);

            game.ChangePlayer();

            panPlayersCards.get(game.getNextPlayerID()).revalidate();
            panPlayersCards.get(game.getNextPlayerID()).repaint();

            UpdateGameInfoPanel();
            return;
        }
        panGameInfo.remove(btnLastPlayCard);
        ButtonClickOnGame(stcard);


        RemoveCardButtonFromHand(stcard);
        UpdateGameInfoPanel();

    }

    private void btnClick(ActionEvent e){

        //--- Check if Trump Category Selected ---
        if(IsTrumpSelected() == null){
            JOptionPane.showMessageDialog(null, "You Have NOT Selected any Trump Category, Please Select a Category and try Again " , "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JButton btnTemp = new JButton();

        //--- Get Clicked btnPlayersCards and Add to btnLastPlayCard ---
        for (int j = 0; j < btnPlayersCards.size(); j++) {
            if (e.getSource() == btnPlayersCards.get(j)) //gameButtons[i][j] was clicked
            {
                //btnLastPlayCard = btnPlayersCards.get(j);
                btnTemp = btnPlayersCards.get(j);
                break;
            }
        }
        //--- Get the Player ID and STCard ID from the btnLastPlayCard ---
        int playerID = -1;
        int cardID = Integer.parseInt(btnTemp.getName());

        Object property = btnTemp.getClientProperty("playerID");
        if (property instanceof Integer) {
            playerID = ((Integer)property);
        }

        //--- Get the Index of the Card in Players Array of Cards ---
        int index = game.GetIndexByCardIDOfCardInHand(playerID, cardID);

        STCard stcard = game.getPlayer(playerID).getCardsInHand().get(index);

        if(game.getLastPlayCard() == null){
            ButtonClickOnGame(stcard);
        } else {
            if(game.ValidatePlayedCard(stcard)){

            } else {
                JOptionPane.showMessageDialog(null, "Selected Card is Not Valid, Please Select Higher Value in Trump or Change Trump Category " , "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
                return;
            };
        }
        panGameInfo.remove(btnLastPlayCard);

        btnLastPlayCard = btnTemp;
        RemoveCardButtonFromHand(stcard);
        UpdateGameInfoPanel();

    }

    private void ButtonClickOnGame(STCard stcard ){
        int cardid = stcard.getCardID();
        int playerid = -1;


        for(int i = 0; i< btnPlayersCards.size(); i++){
            int id = Integer.parseInt(btnPlayersCards.get(i).getName());
            if(id == cardid){
                btnLastPlayCard = btnPlayersCards.get(i);
                Object property = btnLastPlayCard.getClientProperty("playerID");

                if (property instanceof Integer) {
                    playerid = ((Integer)property);
                }

                break;
            }
        }
    }

    private void CreateTrumpOptionGroup(){
        JPanel panTemp = new JPanel();
        panTemp.setLayout(new BoxLayout(panTemp, BoxLayout.LINE_AXIS));
        panTemp.setBorder(BorderFactory.createTitledBorder("Select Trump Category"));

        optTrumpCat01.setMnemonic(KeyEvent.VK_H);
        optTrumpCat02.setMnemonic(KeyEvent.VK_S);
        optTrumpCat03.setMnemonic(KeyEvent.VK_C);
        optTrumpCat04.setMnemonic(KeyEvent.VK_A);
        optTrumpCat05.setMnemonic(KeyEvent.VK_E);

        optTrumpCat01.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    JOptionPane.showMessageDialog(null, "Changed Trump Category to " + STCard.enumCategory.Hardness.toString() , "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
                    game.setTrumpCategory(STCard.enumCategory.Hardness);
                    lblTrumpCategory.setText("Trump Category : " + game.getTrumpCategory());
                }
            }
        });

        optTrumpCat02.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    JOptionPane.showMessageDialog(null, "Changed Trup Category to " + STCard.enumCategory.Specific_Gravity.toString() , "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
                    game.setTrumpCategory(STCard.enumCategory.Specific_Gravity);
                    lblTrumpCategory.setText("Trump Category : " + game.getTrumpCategory());
                }
            }
        });

        optTrumpCat03.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    JOptionPane.showMessageDialog(null, "Changed Trump Category to " + STCard.enumCategory.Cleavage.toString() , "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
                    game.setTrumpCategory(STCard.enumCategory.Cleavage);
                    lblTrumpCategory.setText("Trump Category : " + game.getTrumpCategory());
                }
            }
        });

        optTrumpCat04.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    JOptionPane.showMessageDialog(null, "Changed Trump Category to " + STCard.enumCategory.Crustal_Abundance.toString() , "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
                    game.setTrumpCategory(STCard.enumCategory.Crustal_Abundance);
                    lblTrumpCategory.setText("Trump Category : " + game.getTrumpCategory());
                }
            }
        });

        optTrumpCat05.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==1){
                    JOptionPane.showMessageDialog(null, "Changed Trump Category to " + STCard.enumCategory.Economic_Value.toString() , "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
                    game.setTrumpCategory(STCard.enumCategory.Economic_Value);
                    lblTrumpCategory.setText("Trump Category : " + game.getTrumpCategory());
                }
            }
        });

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();

        group.add(optTrumpCat01);
        group.add(optTrumpCat02);
        group.add(optTrumpCat03);
        group.add(optTrumpCat04);
        group.add(optTrumpCat05);

        lbls.add(optTrumpCat01);
        lbls.add(optTrumpCat02);
        lbls.add(optTrumpCat03);
        lbls.add(optTrumpCat04);
        lbls.add(optTrumpCat05);
    }

    private void UpdateTrumpSelectedOption(){
        switch (game.getTrumpCategory().ordinal()){
            case 0:
                optTrumpCat01.doClick();
                break;
            case 1:
                optTrumpCat02.doClick();
                break;
            case 2:
                optTrumpCat03.doClick();
                break;
            case 3:
                optTrumpCat04.doClick();
                break;
            case 4:
                optTrumpCat05.doClick();
                break;
        }

    }

    private JRadioButton IsTrumpSelected(){
        if(optTrumpCat01.isSelected()){
            return optTrumpCat01;
        }
        if(optTrumpCat02.isSelected()){
            return optTrumpCat02;
        }
        if(optTrumpCat03.isSelected()){
            return optTrumpCat03;
        }
        if(optTrumpCat04.isSelected()){
            return optTrumpCat04;
        }
        if(optTrumpCat05.isSelected()){
            return optTrumpCat05;
        }
        return null;
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
            btnPlayersCards.add(btnTemp);
            pan.add(btnTemp);
        }
    }

    private JButton createButton(int playerID, int cardID) {
        JButton button = new JButton();
        if(playerID == 0) {
            button.setIcon(game.getPlayer(playerID).getCardsInHand().get(cardID).getCardBottomImage());

            button.setFocusable(false);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnClick(e);
                }
            });
        } else {
            button.setSelected(false);
            button.setIcon(game.getPlayer(playerID).getCardsInHand().get(cardID).getCardTopImage());
            //button.setIcon(new ImageIcon(((new ImageIcon("images\\Slide66.jpg")).getImage()).getScaledInstance(CARD_WIDTH, CARD_HEIGHT, java.awt.Image.SCALE_SMOOTH)));
        }

        button.setName(String.valueOf(game.getPlayer(playerID).getCardsInHand().get(cardID).getCardID()));
        button.putClientProperty("playerID", Integer.valueOf(playerID));

        //--- CHECK START - THIS NEED TO BE COMMENT---
        /*
        button.setFocusable(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnClick(e);
            }
        });
        */
        //--- END CHECK---

        return button;
    }

    private void AddButtonToPlayerPanel(JPanel pan, JButton btn){
        pan.add(btn);
    }

    private void UpdatePlayerCardPanel(int uid){
        panPlayersCards.get(uid).revalidate();
        panPlayersCards.get(uid).repaint();
    }

    private void RemoveCardButtonFromHand(STCard selectedCard ){

        game.AfterCardPlay(selectedCard);

        panPlayersCards.get(game.getLastPlayerID()).remove(btnLastPlayCard);
        panPlayersCards.get(game.getLastPlayerID()).revalidate();
        panPlayersCards.get(game.getLastPlayerID()).repaint();

    }
}
