package com.siit.homework.course11.ibm.streams.tutorial.exercise5.thirdpartyplugin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.siit.homework.course11.ibm.streams.tutorial.exercise5.musicplayer.Rating;
import com.siit.homework.course11.ibm.streams.tutorial.exercise5.musicplayer.Song;
import com.siit.homework.course11.ibm.streams.tutorial.exercise5.musicplayer.StarRating;
import com.siit.homework.course11.ibm.streams.tutorial.exercise5.musicplayer.UserRatedMusicLibrary;

public class UserRatedLocalFilesystemMusicLibrary implements UserRatedMusicLibrary {

    private final Set<Song> allSongs = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            new Song("A Change Is Gonna Come", "Sam Cooke"),
            new Song("Bad Moon Rising", "Creedence Clearwater Revival"),
            new Song("Candy", "Paulo Nutini"),
            new Song("Desolation Row", "Bob Dylan"),
            new Song("Eleanor Rigby", "The Beatles"))));

    @Override
    public StarRating userRatingOf(Song song) {
        // Simulate real user ratings
        switch (song.getTitle()) {
            case "Candy":
                return StarRating.FIVE_STARS;
            case "A Change Is Gonna Come":
                return StarRating.FOUR_STARS;
            case "Desolation Row":
                return StarRating.THREE_STARS;
            case "Bad Moon Rising":
                return StarRating.TWO_STARS;
            case "Eleanor Rigby":
                return StarRating.ONE_STARS;
            default:
                return StarRating.ZERO_STARS;
        }
    }

    @Override
    public Rating ratingOf(Song song) {
        int score;
        switch (song.getTitle()) {
            case "Candy":
                score = 78;
                break;
            case "A Change Is Gonna Come":
                score = 65;
                break;
            case "Desolation Row":
                score = 60;
                break;
            case "Bad Moon Rising":
                score = 28;
                break;
            case "Eleanor Rigby":
                score = 42;
                break;
            default:
                score = 0;
        }
        return new Rating(Math.round(score));
    }

    @Override
    public Collection<Song> allSongs() {
        return allSongs;
    }

    @Override
    public int timesPlayed(Song song) {
        // Could read a local database file to find the number of times played
        return 5;
    }
}
