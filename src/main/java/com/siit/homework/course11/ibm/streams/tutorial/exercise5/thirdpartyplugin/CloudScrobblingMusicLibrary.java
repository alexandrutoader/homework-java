package com.siit.homework.course11.ibm.streams.tutorial.exercise5.thirdpartyplugin;

import java.util.Arrays;
import java.util.Collection;

import com.siit.homework.course11.ibm.streams.tutorial.exercise5.musicplayer.MusicLibrary;
import com.siit.homework.course11.ibm.streams.tutorial.exercise5.musicplayer.Rating;
import com.siit.homework.course11.ibm.streams.tutorial.exercise5.musicplayer.Song;

public class CloudScrobblingMusicLibrary implements MusicLibrary {
    private final CloudScrobblingService cloudScrobblingService;

    public CloudScrobblingMusicLibrary() {
        this.cloudScrobblingService = new CloudScrobblingService();
    }

    @Override
    public Collection<Song> allSongs() {
        return cloudScrobblingService.retrieveAllSongs();
    }

    @Override
    public int timesPlayed(Song song) {
        return cloudScrobblingService.retrieveTimesPlayedFromCloud(song);
    }

    public static final class CloudScrobblingService {

        public int retrieveTimesPlayedFromCloud(Song song) {
            // Simulate real cloud service by returning a random number
            return (int) (1 + Math.round(Math.random() % 500));
        }

        public int retrieveScrobbledRatingOf(Song song) {
            // Simulate real cloud service by returning a stable but meaningless number
            switch (song.getTitle()) {
                case "Candy":
                    return 78;
                case "A Change Is Gonna Come":
                    return 65;
                case "Desolation Row":
                    return 34;
                case "Bad Moon Rising":
                    return 28;
                case "Eleanor Rigby":
                    return 42;
                default:
                    return 0;
            }
        }

        public Collection<Song> retrieveAllSongs() {
            return Arrays.asList(
                    new Song("A Change Is Gonna Come", "Sam Cooke"),
                    new Song("Bad Moon Rising", "Creedence Clearwater Revival"),
                    new Song("Candy", "Paulo Nutini"),
                    new Song("Desolation Row", "Bob Dylan"),
                    new Song("Eleanor Rigby", "The Beatles"));
        }
    }

    @Override
    public Rating ratingOf(Song song) {
        // Simulate real cloud service by returning a stable but meaningless number
        int score;
        switch (song.getTitle()) {
            case "Candy":
                score = 78;
                break;
            case "A Change Is Gonna Come":
                score = 65;
                break;
            case "Desolation Row":
                 score = 34;
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
}
