package com.practice.headJavaExercises.rockGame;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Player {
    private String name;
    private String choice;

    public Player() {
    }

    public abstract void selectChoice();

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public String getChoice() {
        return choice;
    }

    public Player setChoice(String choice) {
        this.choice = choice;
        return this;
    }
}
