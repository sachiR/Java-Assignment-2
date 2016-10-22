package com.test6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends JFrame {
    JLabel question = new JLabel("How many players do you want to play with?");
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
            String name = answer.getText();
            String greet = "Hello, " + name;
            greeting.setText(greet);
        });
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setVisible(true);
    }
}