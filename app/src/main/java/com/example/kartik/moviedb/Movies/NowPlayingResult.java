package com.example.kartik.moviedb.Movies;

import java.util.ArrayList;

public class NowPlayingResult {

    ArrayList<Movie> results;

    public NowPlayingResult(ArrayList<Movie> results) {
        this.results = results;
    }

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }
}
