package com.example.kartik.moviedb.Movies;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "movies")

public class Movie {
    private String vote_count;

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String video;
    private String vote_average;
    private String title;
    private String popularity;
    private String poster_path;
    private String orginal_title;
    private String orginal_language;

    @Ignore
    private ArrayList<Integer> genre_ids;

    private String backdrop_path;
    private String overview;
    private String release_date;

    public Movie()
    {

    }


    public Movie(String vote_count, int id, String video, String vote_average, String title, String popularity, String poster_path, String orginal_title, String orginal_language, ArrayList<Integer> genre_ids, String backdrop_path, String overview, String release_date) {
        this.vote_count = vote_count;
        this.id = id;
        this.video = video;
        this.vote_average = vote_average;
        this.title = title;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.orginal_title = orginal_title;
        this.orginal_language = orginal_language;
        this.genre_ids = genre_ids;
        this.backdrop_path = backdrop_path;
        this.overview = overview;
        this.release_date = release_date;
    }


    public String getVote_count() {
        return vote_count;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
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

    public String getOrginal_title() {
        return orginal_title;
    }

    public void setOrginal_title(String orginal_title) {
        this.orginal_title = orginal_title;
    }

    public String getOrginal_language() {
        return orginal_language;
    }

    public void setOrginal_language(String orginal_language) {
        this.orginal_language = orginal_language;
    }

    public ArrayList<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(ArrayList<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
