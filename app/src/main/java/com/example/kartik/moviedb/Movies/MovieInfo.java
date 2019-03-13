package com.example.kartik.moviedb.Movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kartik.moviedb.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.security.Key;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieInfo extends AppCompatActivity implements Callback<Movie> {

    String id;
    ImageView tpl,poster;
    TextView movname,relyear,runtime,moviegenre,desc,rating;
    RecyclerView recyclerView;
    CastAdapter castAdapter;
    ArrayList<Cast> casts=new ArrayList<Cast>();





    public final String Key="6b7113a734a5df464141d313bf9e6a8f" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        recyclerView=findViewById(R.id.castrec);

        tpl=findViewById(R.id.trailer_placeholder);
        poster=findViewById(R.id.movie_poster);
        movname=findViewById(R.id.movie_name);
        relyear=findViewById(R.id.release_year);
        runtime=findViewById(R.id.run_time);
        moviegenre=findViewById(R.id.movie_genre);
        desc=findViewById(R.id.description);
        rating=findViewById(R.id.rating_number);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        castAdapter=new CastAdapter(this,casts);

        recyclerView.setAdapter(castAdapter);








        Intent intent=getIntent();
        id=intent.getStringExtra("id");

        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit=builder.build();
        MovieDb movieDb=retrofit.create(MovieDb.class);

        Call<Movie> movieCall=movieDb.getm(id,Key);
        movieCall.enqueue(this);


        Call<CastResult> castCall=movieDb.getcast(id,Key);
        castCall.enqueue(new Callback<CastResult>() {
            @Override
            public void onResponse(Call<CastResult> call, Response<CastResult> response) {

                Log.d("kkkk",response.toString());

                casts.clear();
                casts.addAll(response.body().getCast());
                castAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CastResult> call, Throwable t) {

            }
        });

    }

    @Override
    public void onResponse(Call<Movie> call, Response<Movie> response) {

        Movie movie=response.body();
        Log.d("kk",response.toString());

        Picasso.get().load("http://image.tmdb.org/t/p/original"+movie.getPoster_path()).fit().into(poster);
        Picasso.get().load("http://image.tmdb.org/t/p/original"+movie.getBackdrop_path()).fit().into(tpl);
       movname.setText(movie.getTitle());
        relyear.setText(movie.getRelease_date());
        desc.setText(movie.getOverview());
                rating.setText(movie.getVote_average());



    }

    @Override
    public void onFailure(Call<Movie> call, Throwable t) {

    }






}
