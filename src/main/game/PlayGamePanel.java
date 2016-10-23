package main.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlayGamePanel extends JFrame{

            private static final long serialVersionUID = 1L;

            public PlayGamePanel() {
                nonMaingame canvas = new nonMaingame();
                setSize(1200, 730);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setTitle("THE MINERAL SUPER TRUMP GAME");
                add(canvas);
                setVisible(true);

            }

            public class nonMaingame extends JPanel implements ActionListener {


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


                    JButton passBtn = new JButton("Pass");
                    canvasSouth.add(passBtn);
                    passBtn.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

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