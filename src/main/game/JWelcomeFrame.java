package main.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JWelcomeFrame extends JFrame implements ActionListener {
    final int WIDTH = 800;
    final int HEIGHT = 700;

    JLabel welcomeLbl = new JLabel("WELCOME TO THE MINERAL SUPER TRUMP GAME");
    JButton newGameBtn = new JButton("START A NEW GAME");
    JButton howToPlayBtn = new JButton("HOW TO PLAY");
    JButton exitBtn = new JButton("EXIT THE GAME");

    public JWelcomeFrame() {
        super("THE MINERAL SUPER TRUMP GAME");
        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout(0,1,900,150));
        Container con = this.getContentPane();
        con.setBackground(new Color(0, 153, 0));

        welcomeLbl.setFont(new java.awt.Font("Serif", Font.BOLD, 30));

        add(welcomeLbl);
        add(newGameBtn);
        add(howToPlayBtn);
        add(exitBtn);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
