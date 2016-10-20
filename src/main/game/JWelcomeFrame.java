package main.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JWelcomeFrame extends JFrame {
    // JFrame properties
    final int WIDTH = 800;
    final int HEIGHT = 700;

    //Labels
    JLabel welcomeLbl = new JLabel("WELCOME TO THE MINERAL SUPER TRUMP GAME");
    // Buttons
    JButton newGameBtn = new JButton("START A NEW GAME");
    JButton howToPlayBtn = new JButton("HOW TO PLAY");
    JButton exitBtn = new JButton("EXIT THE GAME");

    public JWelcomeFrame() {
        super("THE MINERAL SUPER TRUMP GAME");
        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout(0, 1, 900, 150));

        welcomeLbl.setFont(new java.awt.Font("Serif", Font.BOLD, 30));


        Container con = this.getContentPane();
        con.setLayout(new FlowLayout());
        con.setBackground(new Color(0, 153, 0));


        JPanel bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(2,1));
        bigPanel.setBackground(new Color(0, 153, 0));
        bigPanel.add(welcomeLbl);
        con.add(bigPanel);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250, 150));
        bigPanel.add(panel);
        panel.setLayout(new GridLayout(3, 1));
        panel.setBackground(new Color(0, 153, 0));

        //Adding to the Panel
        panel.add(newGameBtn);
        newGameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                con.remove(bigPanel);
                con.remove(bigPanel);
                con.revalidate();
                con.repaint();
            }
        });

        panel.add(howToPlayBtn);
        howToPlayBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bigPanel.remove(panel);
                bigPanel.revalidate();
                bigPanel.repaint();
            }
        });

        panel.add(exitBtn);
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

