package com.test6;

import main.game.STPlayer;

import javax.swing.*;

public class PlayerView {
    STPlayer player;
    JLabel playerName = new JLabel("You");

    public PlayerView(STPlayer players){
        this.player = players;
        playerName.add(playerName);
        //addAllCards ();
    }
}
