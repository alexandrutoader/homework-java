package com.siit.homework.course11.ibm.streams.tutorial.exercise5.musicplayer;

public interface UserRatedMusicLibrary extends MusicLibrary {

    StarRating userRatingOf(Song song);

    default Rating ratingOf(Song song) {
        int totalPlayCount = allSongs().stream().mapToInt(this::timesPlayed).sum();
        float score = (timesPlayed(song) / totalPlayCount) * 100.0f;
        return new Rating(Math.round(score));
    };

    static class StarRatingConverter {
        public Rating convert(StarRating starRating) {
            return new Rating(starRating.numberOfStars * 20);
        }
    }
}
