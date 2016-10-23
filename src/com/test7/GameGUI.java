package com.test7;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameGUI extends JFrame {

    /**

     */
    private static final long serialVersionUID = 1L;

    public GameGUI() {
        nonMaingame canvas = new nonMaingame();
        setSize(1020, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("THE MINERAL SUPER TRUMP GAME");
        add(canvas);

    }

    public static void main(String[] args) {
        new GameGUI().setVisible(true);

    }

    public class nonMaingame extends JPanel implements ActionListener {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        JLabel text;

        public nonMaingame() {
            setLayout(new BorderLayout());

            JPanel canvasSouth = makePanel(Color.RED);
            add(canvasSouth, BorderLayout.SOUTH);

            JPanel canvasNorth = makePanel(Color.BLUE);
            add(canvasNorth, BorderLayout.NORTH);

            JPanel canvasEast = makePanel(Color.YELLOW);
            canvasEast.setBackground(Color.YELLOW);
            add(canvasEast, BorderLayout.EAST);

            JPanel canvasWest = makePanel(Color.MAGENTA);
            add(canvasWest, BorderLayout.WEST);

            JPanel canvasCentre = makePanel(Color.pink);
            add(canvasCentre, BorderLayout.CENTER);

            JLabel welcomeLbl = new JLabel("WELCOME TO THE MINERAL SUPER TRUMP GAME");
            welcomeLbl.setFont(new java.awt.Font("Serif", Font.BOLD, 30));
            canvasNorth.add(welcomeLbl);

            JLabel question = new JLabel("Please enter the number of players you like to play with?");
            JTextField answer = new JTextField(10);
            canvasCentre.add(question);
            canvasCentre.add(answer);

            JButton nextBtn = new JButton("Next");
            canvasSouth.add(nextBtn);
            nextBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String numOfPlayers = answer.getText();
                    int player = Integer.parseInt(numOfPlayers);

                }
            });
        }

        protected JPanel makePanel(Color color) {
            JPanel pane = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(100, 100);
                }
            };
            pane.setBackground(color);
            return pane;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub

        }

    }
}