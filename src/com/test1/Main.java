package com.test1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
public class Main extends JFrame {
    private JPanel options;

    public Main() {
        super("The Mineral Super Trump Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container con = this.getContentPane();
        con.setBackground(new Color(0, 153, 0));

        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new FlowLayout());
        welcomePanel.setBackground(new Color(0, 153, 0));

        JLabel welcomeLabel = new JLabel("Welcome to the Mineral Super Trump Game");
        welcomeLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 32));
        welcomePanel.add(welcomeLabel);

        JButton newGameBtn = new JButton("NEW GAME");
        JButton howToPlayBtn = new JButton("How To Play");
        JButton exitBtn = new JButton("Exit The Game");
        welcomePanel.add(newGameBtn,BorderLayout.CENTER);
        welcomePanel.add(howToPlayBtn,BorderLayout.CENTER);
        welcomePanel.add(exitBtn,BorderLayout.CENTER);

        con.add(welcomePanel);
    }

    public static void main(String[] args)
    {
        Main cFrame = new Main();
        cFrame.setSize(800,700);
        cFrame.setVisible(true);
    }
}