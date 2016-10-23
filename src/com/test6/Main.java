package com.test6;

import main.game.STDeck;
import main.game.STGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends JFrame {
    JLabel question = new JLabel("Please enter the number of players you like to play with?");
    Font bigFont = new Font("Arial", Font.BOLD, 16);
    JTextField answer = new JTextField(10);
    JButton pressMe = new JButton("Start the game");
    JLabel greeting = new JLabel("");
    final int WIDTH = 800;
    final int HEIGHT = 700;

    public Main() {
        super("The Mineral Super Trump Game");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        question.setFont(bigFont);
        greeting.setFont(bigFont);
        add(question);
        add(answer);

        add(pressMe);
        add(greeting);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pressMe.addActionListener(e -> {
            String players = answer.getText();
            int numOfPlayers = Integer.valueOf(players);
            STGame game = new STGame(numOfPlayers);
            JLabel playLabel = new JLabel("The Num Of Players are " + players);
            add(playLabel);

        });
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setVisible(true);
    }
}