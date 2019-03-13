package com.example.kartik.moviedb.Movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.kartik.moviedb.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViewAllMovies extends AppCompatActivity {

    String movieview;
    RecyclerView viewrec;
    ViewAllAdapter viewAllAdapter;
    ArrayList<Movie> allmovies=new ArrayList<Movie>();

    public final String Key="6b7113a734a5df464141d313bf9e6a8f" ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_movies);

        Intent intent=getIntent();
        movieview=intent.getStringExtra("viewall");

        viewrec=findViewById(R.id.recviewall);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        viewrec.setLayoutManager(gridLayoutManager);
        viewAllAdapter=new ViewAllAdapter(this, allmovies, new ViewAllAdapter.onMovieClickListner() {
            @Override
            public void onClick(int pos) {

                Intent intent1=new Intent(ViewAllMovies.this,MovieInfo.class);
                intent1.putExtra("id",allmovies.get(pos).getId());
                startActivity(intent1);




            }
        });

        viewrec.setAdapter(viewAllAdapter);

        if(movieview.equals("up"))
        {
            fetchUpCommingMovies();
        }


        else if(movieview.equals("pop"))
        {
            fetchPopularMovies();

        }
        else if(movieview.equals("top"))
        {
            fetchTopRatedMovies();

        }
        else if (movieview.equals("now"))
        {
            fetchNowPlaying();
        }


    }
    public void fetchPopularMovies() {

        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit=builder.build();
        MovieDb movieDb=retrofit.create(MovieDb.class);
        Call<PopularMovieResult> popularMovieResultCall=movieDb.getpop(Key,2);
        popularMovieResultCall.enqueue(new Callback<PopularMovieResult>() {
            @Override
            public void onResponse(Call<PopularMovieResult> call, Response<PopularMovieResult> response) {
                PopularMovieResult popularMovieResult=response.body();

                Log.d("tag",response.toString());
                allmovies.clear();
                allmovies.addAll(popularMovieResult.getResults()); //  popMovieRecAdapter=new PopMovieRecAdapter(this,pop );
                // jo yahan bheji hai wo hi send karte hai

                viewAllAdapter.notifyDataSetChanged();

                Log.d("nj",response.toString());


            }

            @Override
            public void onFailure(Call<PopularMovieResult> call, Throwable t) {

            }
        });


    }


    public void fetchTopRatedMovies()
    {
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit=builder.build();
        MovieDb movieDb=retrofit.create(MovieDb.class);

        Call<TopRatedMovieResult> topRatedMovieResultCall=movieDb.gettoprated(Key);
        topRatedMovieResultCall.enqueue(new Callback<TopRatedMovieResult>() {
            @Override
            public void onResponse(Call<TopRatedMovieResult> call, Response<TopRatedMovieResult> response) {

                TopRatedMovieResult topRatedMovieResult=response.body();
                allmovies.clear();
                allmovies.addAll(topRatedMovieResult.getResults());

                viewAllAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TopRatedMovieResult> call, Throwable t) {

            }
        });

    }
    public void fetchUpCommingMovies()
    {
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit=builder.build();
        MovieDb movieDb=retrofit.create(MovieDb.class);

        Call<UpcomingMoviesResult> upcomingMoviesResultCall=movieDb.getupcoming(Key);
        upcomingMoviesResultCall.enqueue(new Callback<UpcomingMoviesResult>() {
            @Override
            public void onResponse(Call<UpcomingMoviesResult> call, Response<UpcomingMoviesResult> response) {

                UpcomingMoviesResult upcomingMoviesResult=response.body();
                allmovies.clear();
                allmovies.addAll(upcomingMoviesResult.getresults());
                viewAllAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<UpcomingMoviesResult> call, Throwable t) {

            }
        });


    }
    public void fetchNowPlaying()
    {
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit=builder.build();
        MovieDb movieDb=retrofit.create(MovieDb.class);

        Call<NowPlayingResult> nowPlayingResultCall=movieDb.getnow(Key);
        nowPlayingResultCall.enqueue(new Callback<NowPlayingResult>() {
            @Override
            public void onResponse(Call<NowPlayingResult> call, Response<NowPlayingResult> response) {

                NowPlayingResult nowPlayingResult=response.body();
                allmovies.clear();
                allmovies.addAll(nowPlayingResult.getResults());
                viewAllAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NowPlayingResult> call, Throwable t) {

            }
        });

    }

}
