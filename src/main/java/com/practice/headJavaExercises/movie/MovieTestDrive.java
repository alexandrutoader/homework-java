package com.practice.headJavaExercises.movie;

public class MovieTestDrive {
    public static void main(String[] args) {
        Movie one = new Movie();
        one.title = "Gone with the Stock";
        one.genre = "Tragic";
        one.rating = -2;

        Movie two = new Movie();
        two.title = "Lost in Cubicle Space";
        two.genre = "Comedy";
        two.rating = 5;

        Movie three = new Movie();
        three.title = "Byte club";
        three.genre = "Tragic but ultimately uplifting";
        three.rating = 127;

        System.out.println("First movie: ");
        System.out.println(one.title);
        System.out.println(one.genre);
        System.out.println(one.rating);

        System.out.println("Second movie: ");
        System.out.println(two.title);
        System.out.println(two.genre);
        System.out.println(two.rating);

        System.out.println("Third movie: ");
        System.out.println(three.title);
        System.out.println(three.genre);
        System.out.println(three.rating);
    }
}
