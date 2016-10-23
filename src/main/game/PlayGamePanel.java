package main.game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PlayGamePanel extends JPanel {
                private static final long serialVersionUID = 1L;
                JLabel text;

                public PlayGamePanel() {
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
                    JButton startTheGameBtn = new JButton("START A NEW GAME");
                    canvasCentre.add(startTheGameBtn);
                    startTheGameBtn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            canvasCentre.remove(startTheGameBtn);

                            JButton passBtn = new JButton("Pass");
                            canvasSouth.add(passBtn);
                            passBtn.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {

                                }
                            });
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
            }