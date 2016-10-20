package main.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JWelcomeFrame extends JFrame implements ActionListener {
    final int WIDTH = 700;
    final int HEIGHT = 800;

    JLabel welcomeLbl = new JLabel("What is your name?");
    JButton newGameBtn = new JButton("START A NEW GAME");
    JButton howToPlayBtn = new JButton("HOW TO PLAY");
    JButton exitBtn = new JButton("EXIT THE GAME");


    public JWelcomeFrame() {
        super();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
