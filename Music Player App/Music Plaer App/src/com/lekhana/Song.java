package com.lekhana;

public class Song {
    String song_name;
    double song_duration;

    public Song(String song_name, double song_duration) {
        this.song_name = song_name;
        this.song_duration = song_duration;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public double getSong_duration() {
        return song_duration;
    }

    public void setSong_duration(double song_duration) {
        this.song_duration = song_duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "song_name='" + song_name + '\'' +
                ", song_duration=" + song_duration +
                '}';
    }
}
