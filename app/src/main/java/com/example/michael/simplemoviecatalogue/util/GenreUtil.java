package com.example.michael.simplemoviecatalogue.util;

import android.util.SparseArray;

public class GenreUtil {

    private static SparseArray<String> genre;

    static {
        genre = new SparseArray<>();
        genre.put(28, "Action");
        genre.put(12, "Adventure");
        genre.put(16, "Animation");
        genre.put(35, "Comedy");
        genre.put(80, "Crime");
        genre.put(99, "Documentary");
        genre.put(18, "Drama");
        genre.put(10751, "Family");
        genre.put(14, "Fantasy");
        genre.put(36, "History");
        genre.put(27, "Horror");
        genre.put(10402, "Music");
        genre.put(9648, "Mystery");
        genre.put(10794, "Romance");
        genre.put(878, "Sci-Fi");
        genre.put(10770, "TV Movie");
        genre.put(53, "Thriller");
        genre.put(10752, "War");
        genre.put(37, "Western");
    }

    public static String getGenre(Integer genreId) {

        try {
            return genre.get(genreId);
        } catch (Exception e) {
            return "";
        }
    }
}
