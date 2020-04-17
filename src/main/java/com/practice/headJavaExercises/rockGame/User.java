package com.practice.headJavaExercises.rockGame;

import java.util.Scanner;

public class User extends Player {
    private final Scanner input;

    public User() {
        input = new Scanner(System.in);
    }

    @Override
    public void selectChoice() {
        System.out.println("Enter your choice: R - Rock, P - Paper, S - Scissors");
        setChoice(input.nextLine().toUpperCase());
    }
}
