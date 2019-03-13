package com.example.kartik.moviedb.Movies;

import java.lang.ref.SoftReference;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieDb {

    @GET("movie/popular")
    Call<PopularMovieResult> getpop(@Query("api_key") String key,@Query("pages") int page);

    @GET("movie/top_rated")
    Call<TopRatedMovieResult> gettoprated(@Query("api_key") String key);

    @GET("movie/upcoming")
    Call<UpcomingMoviesResult> getupcoming(@Query("api_key") String key);

    @GET("movie/now_playing")
    Call<NowPlayingResult> getnow(@Query("api_key") String key);

    @GET("movie/{movie_id}")
    Call<Movie> getm( @Path("movie_id") String id,@Query("api_key") String key);

    @GET("movie/{movie_id}/credits")
    Call<CastResult> getcast(@Path("movie_id") String id,@Query("api_key") String key);










}
