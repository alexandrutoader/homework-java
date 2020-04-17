package com.practice.headJavaExercises.rockGame;

import java.util.Random;

public class Computer extends Player {
    private final Random rand;

    public Computer() {
        setName("Computer");
        rand = new Random();
    }

    @Override
    public void selectChoice() {
        int MAX_NUMBER = 3;
        int randomNumber = rand.nextInt(MAX_NUMBER);
        switch(randomNumber) {
            case 0:
                setChoice("ROCK");
                break;
            case 1:
                setChoice("PAPER");
                break;
            case 2:
                setChoice("SCISSORS");
                break;
        }
    }
}
