package com.example.kartik.moviedb.Movies;

public class NowPlayingMovies {

    private String id;
    private String vote_average;
    private String title;
    private String popularity;
    private String poster_path;
    private String orignal_title;
    private String release_date;

    public NowPlayingMovies(String id, String vote_average, String title, String popularity, String poster_path, String orignal_title, String release_date) {
        this.id = id;
        this.vote_average = vote_average;
        this.title = title;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.orignal_title = orignal_title;
        this.release_date = release_date;
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

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOrignal_title() {
        return orignal_title;
    }

    public void setOrignal_title(String orignal_title) {
        this.orignal_title = orignal_title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
