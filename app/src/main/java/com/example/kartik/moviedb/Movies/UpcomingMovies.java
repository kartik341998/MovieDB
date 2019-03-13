package com.example.kartik.moviedb.Movies;

import java.util.ArrayList;

public class UpcomingMovies {
    private String vote_count;
    private String id;
    private String vote_average;
    private String title;
    private String populatiry;
    private String poster_path;
    private ArrayList<Integer> genre_ids;

    public UpcomingMovies(String vote_count, String id, String vote_average, String title, String populatiry, String poster_path, ArrayList<Integer> genre_ids) {
        this.vote_count = vote_count;
        this.id = id;
        this.vote_average = vote_average;
        this.title = title;
        this.populatiry = populatiry;
        this.poster_path = poster_path;
        this.genre_ids = genre_ids;
    }

    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPopulatiry() {
        return populatiry;
    }

    public void setPopulatiry(String populatiry) {
        this.populatiry = populatiry;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public ArrayList<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(ArrayList<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }
}
