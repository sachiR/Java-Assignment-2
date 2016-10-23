package main.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainGameGUI extends JFrame{
    // JFrame properties
    final int WIDTH = 1200;
    final int HEIGHT = 720;

    //Labels
    JLabel welcomeLbl = new JLabel("WELCOME TO THE MINERAL SUPER TRUMP GAME");
    JLabel question = new JLabel("Please enter the number of players you like to play with?");
    JTextField answer = new JTextField(10);
    // Buttons
    JButton newGameBtn = new JButton("START A NEW GAME");
    Container con = this.getContentPane();


    public static void main(String[] args) {
        MainGameGUI frame = new MainGameGUI();
        frame.setVisible(true);
    }

    public MainGameGUI(){
        //title,size and layout of the JFrame
        super("THE MINERAL SUPER TRUMP GAME");
        setSize(WIDTH, HEIGHT);

        //welcome label font size
        welcomeLbl.setFont(new java.awt.Font("Serif", Font.BOLD, 36));

        //container and set properties
        con.setLayout(new FlowLayout());
        con.setBackground(new Color(0, 153, 0));

        // New Panel properties
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridLayout(2,1));
        welcomePanel.setBackground(new Color(0, 153, 0));
        //welcomePanel.setPreferredSize(new Dimension(1000, 400));

        con.add(welcomePanel);
        welcomePanel.add(welcomeLbl);

        //New Panel properties
        JPanel smallWelcomePanel = new JPanel();

        smallWelcomePanel.setLayout(new FlowLayout());
        smallWelcomePanel.setBackground(new Color(0, 153, 0));
        welcomePanel.add(smallWelcomePanel);

        question.setFont(new java.awt.Font("Arial", Font.ITALIC, 18));
        smallWelcomePanel.add(question);

        answer.setFont(new java.awt.Font("Arial", Font.BOLD, 18));
        smallWelcomePanel.add(answer);


        //Adding new game button to the Panel and its action
        newGameBtn.setFont(new java.awt.Font("Arial", Font.ITALIC, 16));
        smallWelcomePanel.add(newGameBtn);

        newGameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                con.remove(welcomePanel);
                con.revalidate();
                con.repaint();
                playGame();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void playGame() {
        con.setLayout(new BorderLayout());

        JPanel canvasSouth = makePanel(new Color(0, 153, 0));
        add(canvasSouth, BorderLayout.SOUTH);

        JPanel canvasNorth = makePanel(new Color(0, 153, 0));
        add(canvasNorth, BorderLayout.NORTH);

        JPanel canvasEast = makePanel(new Color(0, 153, 0));
        add(canvasEast, BorderLayout.EAST);

        JPanel canvasWest = makePanel(new Color(0, 153, 0));
        add(canvasWest, BorderLayout.WEST);

        JPanel canvasCentre = makePanel(new Color(0, 153, 0));
        add(canvasCentre, BorderLayout.CENTER);

        String numOfPlayers = answer.getText();
        int player = Integer.parseInt(numOfPlayers);

        JLabel numOfPlayerLabel = new JLabel("The Number of players are " + player);
        canvasCentre.add(numOfPlayerLabel);

        STGame game = new STGame(player);
        JLabel randomDealerLabel = new JLabel("The Dealer ID is " + game.getDealerID());
        canvasCentre.add(randomDealerLabel);

        JLabel nextPlayerLabel = new JLabel("The Next Player ID is " + game.getNextPlayer());
        canvasCentre.add(nextPlayerLabel);
        game.dealCardsToEachPlayer();

        JButton passBtn = new JButton("Pass");
        canvasSouth.add(passBtn);

        STPlayer playerID = game.getPlayer(0);
        PlayerView playView = new PlayerView(playerID);
        canvasSouth.add(playView);

        passBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.drawCardFromDeck(0);
            }
        });
    }



    protected JPanel makePanel(Color color) {
        JPanel pane = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(100, 100);
            }
        };
        pane.setBackground(color);
        return pane;
    }

}