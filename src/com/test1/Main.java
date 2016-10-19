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
        welcomePanel.setLayout(new BorderLayout());
        con.add(welcomePanel);
    }

    public static void main(String[] args)
    {
        Main cFrame = new Main();
        cFrame.setSize(800,700);
        cFrame.setVisible(true);
    }
}