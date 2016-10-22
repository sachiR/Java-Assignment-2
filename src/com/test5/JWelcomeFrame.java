package com.test5;

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
        //title,size and layout of the JFrame
        super("THE MINERAL SUPER TRUMP GAME");
        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout(0, 1, 900, 150));

        //welcome label font size
        welcomeLbl.setFont(new java.awt.Font("Serif", Font.BOLD, 30));

        //container and set properties
        Container con = this.getContentPane();
        con.setLayout(new FlowLayout());
        con.setBackground(new Color(0, 153, 0));

        //JPanel bigPanel and properties (bigPanel= headline + panel)
        JPanel bigPanel = new JPanel();
        bigPanel.setLayout(new GridLayout(2,1));
        bigPanel.setBackground(new Color(0, 153, 0));
        bigPanel.add(welcomeLbl);
        con.add(bigPanel);

        //JPanel panel and properties (panel=3buttons)
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250, 150));
        bigPanel.add(panel);
        panel.setLayout(new GridLayout(3, 1));
        panel.setBackground(new Color(0, 153, 0));

        //Adding new game button to the Panel and its action
        panel.add(newGameBtn);
        newGameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                con.remove(bigPanel);
                con.remove(bigPanel);
                con.revalidate();
                con.repaint();

            }
        });

        //Adding how to play button to panel and its action
        panel.add(howToPlayBtn);
        howToPlayBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bigPanel.remove(panel);

                bigPanel.revalidate();
                bigPanel.repaint();

                JHowToPlayFrame howToPlay = new JHowToPlayFrame();
                bigPanel.add(howToPlay);
                howToPlay.setBackground(new Color(0, 153, 0));
            }
        });

        //Adding exit button to panel and its action
        panel.add(exitBtn);
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

