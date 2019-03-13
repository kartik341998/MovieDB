package com.example.kartik.moviedb.Movies;

import java.util.ArrayList;

public class TopRatedMovieResult {

    private ArrayList<Movie> results;

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }

    public TopRatedMovieResult(ArrayList<Movie> results) {

        this.results = results;
    }
}
