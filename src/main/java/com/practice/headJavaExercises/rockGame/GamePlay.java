package com.practice.headJavaExercises.rockGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GamePlay {
    private final User player;
    private final Computer computer;
    private int playerWins;
    private int playerLoses;
    private int ties;
    private boolean isRunning = false;
    private final Scanner scan;

    public static void main(String[] args) {
        new GamePlay();
    }

    public GamePlay() {
        player = new User();
        computer = new Computer();
        scan = new Scanner(System.in);
        start();
    }

    private void start() {
        isRunning = true;
        System.out.println("Please, enter your name:");
        player.setName(scan.nextLine());

        while (isRunning) {
            player.selectChoice();
            computer.selectChoice();
            displayChoices();
            displayWinner(decideWinner());
            updateScore(decideWinner());
            displayScore();
            playAgain();
        }
    }

    private void displayScore() {
        System.out.println(player.getName());
        System.out.println("----------");
        System.out.println("Wins: " + playerWins);
        System.out.println("Loses: " + playerLoses);
        System.out.println("Ties: " + ties);
        System.out.println("----------");
    }

    private int decideWinner() {
        // 0 - User wins
        // 1 - Computer wins
        // 2 - tie
        // 3 - invalid input
        switch (player.getChoice()) {
            case "R":
                player.setChoice("ROCK");
                break;
            case "P":
                player.setChoice("PAPER");
                break;
            case "S":
                player.setChoice("SCISSORS");
                break;
        }

        String[] validInputs = new String[]{"ROCK", "PAPER", "SCISSORS"};

        // Convert String Array to List
        List<String> list = Arrays.asList(validInputs);

        if(!list.contains(player.getChoice())){
            return 3;
        }

        if (player.getChoice().equals("ROCK") && computer.getChoice().equals("SCISSORS")) {
            return 0;
        } else if (player.getChoice().equals("PAPER") && computer.getChoice().equals("ROCK")) {
            return 0;
        } else if (player.getChoice().equals("SCISSORS") && computer.getChoice().equals("PAPER")) {
            return 0;
        } else if (computer.getChoice().equals("ROCK") && player.getChoice().equals("SCISSORS")) {
            return 1;
        } else if (computer.getChoice().equals("PAPER") && player.getChoice().equals("ROCK")) {
            return 1;
        } else if (computer.getChoice().equals("SCISSORS") && player.getChoice().equals("PAPER")) {
            return 1;
        } else {
            return 2;
        }
    }

    private void displayChoices() {
        switch (player.getChoice()) {
            case "R":
                player.setChoice("ROCK");
                break;
            case "P":
                player.setChoice("PAPER");
                break;
            case "S":
                player.setChoice("SCISSORS");
                break;
        }

        System.out.println("User has selected: " + player.getChoice());
        System.out.println("Computer has selected: " + computer.getChoice());
    }

    private void displayWinner(int winner) {
        switch (winner) {
            case 0:
                System.out.println("User has won!");
                break;
            case 1:
                System.out.println("Computer has won!");
                break;
            case 2:
                System.out.println("It is a tie!");
                break;
            default:
                System.out.println("Invalid input!");
        }
    }

    private void playAgain() {
        String choice;
        System.out.println("Do you want to play again? Enter Yes to play again.");
        choice = scan.nextLine();
        if (!(choice.toUpperCase().equals("YES"))) {
            isRunning = false;
        }

    }

    private void updateScore(int winner) {
        if (winner == 0) {
            playerWins++;
        } else if (winner == 1) {
            playerLoses++;
        } else if (winner == 2) {
            ties++;
        }
    }
}
