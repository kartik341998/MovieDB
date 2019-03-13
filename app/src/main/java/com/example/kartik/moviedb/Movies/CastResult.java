package com.example.kartik.moviedb.Movies;

import java.util.ArrayList;

public class CastResult {

    ArrayList<Cast> cast=new ArrayList<Cast>();

    public CastResult(ArrayList<Cast> cast) {
        this.cast = cast;
    }

    public ArrayList<Cast> getCast() {
        return cast;
    }

    public void setCast(ArrayList<Cast> cast) {
        this.cast = cast;
    }
}
