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
        welcomePanel.setPreferredSize(new Dimension(1000, 400));

        con.add(welcomePanel);
        welcomePanel.add(welcomeLbl);

        //New Panel properties
        JPanel smallWelcomePanel = new JPanel();

        smallWelcomePanel.setLayout(new FlowLayout());
        smallWelcomePanel.setBackground(new Color(0, 153, 0));
        welcomePanel.add(smallWelcomePanel);

        question.setFont(new java.awt.Font("Arial", Font.BOLD, 25));
        smallWelcomePanel.add(question);

        answer.setFont(new java.awt.Font("Arial", Font.BOLD, 25));
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

        JPanel canvasSouth = makePanel(Color.RED);
        add(canvasSouth, BorderLayout.SOUTH);

        JPanel canvasNorth = makePanel(Color.BLUE);
        add(canvasNorth, BorderLayout.NORTH);

        JPanel canvasEast = makePanel(Color.YELLOW);
        canvasEast.setBackground(Color.YELLOW);
        add(canvasEast, BorderLayout.EAST);

        JPanel canvasWest = makePanel(Color.MAGENTA);
        add(canvasWest, BorderLayout.WEST);

        JPanel canvasCentre = makePanel(Color.pink);
        add(canvasCentre, BorderLayout.CENTER);
//        String numOfPlayers = answer.getText();
//        int player = Integer.parseInt(numOfPlayers);
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