package com.test2;

import java.awt.*;
import javax.swing.*;
import java.lang.*;

public class Demo extends JFrame{
    public Demo(){
    }

    public static void main(String [] args) {
        JOptionPane option = new JOptionPane();
        String name = showWelcome();
        int opt = showMenu();
        switch (opt) { //options in the menu
            case 1:
                startGame();
                break;
            case 2:
                howToPlay();
                break;
            case 3:
                option.showMessageDialog(null,"Thank you for playing " + name + ", Come Again..");
                System.exit(opt); //exit the game

        }
    }//main() ends

    private static void startGame() {
        //getting the number of players
        int numOfPlayers = numOfPlayers();
    }

    private static int numOfPlayers() {
        JOptionPane option = new JOptionPane();
        JFrame frame = new JFrame();

        //Custom button text
        Object[] buttonOptions = {"3 Players",
                "4 Players",
                "5 Players"};
        int menuChoice = option.showOptionDialog(frame,"Select the number of Players You would like to play with: ","The Mineral Super Trump Game",
                JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,buttonOptions,buttonOptions[2]);
        if (menuChoice == 0){
            return 3;
        } else if (menuChoice == 1){
            return 4;
        }else{
            return 5;
        }
    }

    private static int showMenu() {
        JOptionPane option = new JOptionPane();
        JFrame frame = new JFrame();

        //show menu
        //Custom button text
        Object[] buttonOptions = {"Start New Game",
                "How To Play",
                "Exit"};
        int menuChoice = option.showOptionDialog(frame,"Start Menu of The Game","The Mineral Super Trump Game",
                JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,buttonOptions,buttonOptions[2]);
        if (menuChoice == 0){
            return 1;
        } else if (menuChoice == 1){
            return 2;
        }else{
            return 3;
        }
    }

    private static String showWelcome() {
        JOptionPane option = new JOptionPane();

        //gets the name form the user
        String name = option.showInputDialog("Welcome To The Mineral Super Trumps Game\n            Please Enter users name");

        //if the name is invalid it will ask again
        while(name.isEmpty()){
            name = option.showInputDialog("Try Again...\nPlease Enter Your Name");
        } //while ends
    return name;
    }

    private static void howToPlay() {

    }

}// class ends

