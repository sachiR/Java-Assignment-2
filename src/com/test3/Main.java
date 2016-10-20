package com.test3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public Main(){
        prepareGUI();}


    public static void main(String[] args){
        Main frame = new Main();
        frame.showButtonDemo();

    }

    private void prepareGUI(){
        mainFrame = new JFrame("THE MINERAL SUPER TRUMP GAME");
        mainFrame.getContentPane().setBackground(new Color(0, 153, 0));
        mainFrame.setSize(800,700);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);

        controlPanel = new JPanel();
        controlPanel.add(headerLabel);

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        controlPanel.add(new JSeparator(SwingConstants.VERTICAL));
        controlPanel.add(new JSeparator(SwingConstants.VERTICAL));
        controlPanel.add(new JSeparator(SwingConstants.VERTICAL));
       // controlPanel.setLayout(new GridLayout(0, 1, 0, 0));
        controlPanel.setBackground(new Color(0, 153, 0));

        mainFrame.add(controlPanel);
        mainFrame.setVisible(true);
    }

    private void showButtonDemo(){
        headerLabel.setText("WELCOME TO THE MINERAL SUPER TRUMP GAME");
        headerLabel.setFont(new java.awt.Font("Serif", Font.BOLD, 30));


        JLabel bk = new JLabel("");
        JButton newGameButton = new JButton("NEW GAME");
        newGameButton.setPreferredSize(new Dimension(40, 40));
        newGameButton.setHorizontalTextPosition(SwingConstants.CENTER);

        JButton howToPlayButton = new JButton("HOW TO PLAY");
        howToPlayButton.setPreferredSize(new Dimension(50, 40));
        howToPlayButton.setHorizontalTextPosition(SwingConstants.CENTER);

        JButton exitButton = new JButton("EXIT");
        exitButton.setPreferredSize(new Dimension(40, 40));
        exitButton.setHorizontalTextPosition(SwingConstants.CENTER);

        newGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //statusLabel.setText("New Game Button clicked.");
                controlPanel.repaint();
            }
        });

        howToPlayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //statusLabel.setText("How To Play Button clicked.");
                controlPanel.repaint();
                JLabel lbel = new JLabel("HI");
                controlPanel.add(lbel);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //statusLabel.setText("Exit Button clicked.");
                System.exit(0);
            }
        });

        controlPanel.add(new JSeparator(SwingConstants.VERTICAL));
        controlPanel.add(newGameButton);
        controlPanel.add(new JSeparator(SwingConstants.VERTICAL));
        controlPanel.add(howToPlayButton);
        controlPanel.add(new JSeparator(SwingConstants.VERTICAL));
        controlPanel.add(exitButton);

        mainFrame.setVisible(true);
    }

}
