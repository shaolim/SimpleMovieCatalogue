package com.example.michael.simplemoviecatalogue.data;

public enum MovieType {
    UPCOMING("upcoming"), NOW_PLAYING("now_playing");

    private String type;

    MovieType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
