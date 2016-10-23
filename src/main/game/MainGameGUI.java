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
        Container con = this.getContentPane();
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
                String numOfPlayers = answer.getText();
                int player = Integer.parseInt(numOfPlayers);
                con.remove(welcomePanel);
                con.revalidate();
                con.repaint();

                PlayGamePanel playGame = new PlayGamePanel();
                dispose();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}