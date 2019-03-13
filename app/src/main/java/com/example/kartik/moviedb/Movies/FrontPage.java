package com.example.kartik.moviedb.Movies;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.kartik.moviedb.R;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FrontPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView recyclerViewpop , recyclerViewtop , recyclerViewup , recyclerViewnow ;
    PopMovieRecAdapter popMovieRecAdapter , topratedAdapter , upComingAdapter , nowAdapter ;
    ArrayList<Movie> pop=new ArrayList<>(),top=new ArrayList<>(),up=new ArrayList<>(), now=new ArrayList<>();

    TextView viewtop,viewup,viewpop,viewnow;

//    MovieDAO movieDAO;







    public final String Key="6b7113a734a5df464141d313bf9e6a8f" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        MovieDatabase movieDatabase= Room.databaseBuilder(this,MovieDatabase.class,"movie_db").allowMainThreadQueries().build();
//        movieDAO=movieDatabase.getMovieDao();











        recyclerViewpop=findViewById(R.id.pop);
        recyclerViewtop=findViewById(R.id.top);
        recyclerViewnow=findViewById(R.id.now);
        recyclerViewup=findViewById(R.id.upcom);




        viewpop=findViewById(R.id.viewpop);
        viewtop=findViewById(R.id.viewtop);
        viewup=findViewById(R.id.viewup);
        viewnow=findViewById(R.id.viewnow);

        viewtop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(FrontPage.this,ViewAllMovies.class);
                intent.putExtra("viewall","top");
                startActivity(intent);

            }



        });

        viewup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FrontPage.this,ViewAllMovies.class);
                intent.putExtra("viewall","up");
                startActivity(intent);

            }
        });

        viewpop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FrontPage.this,ViewAllMovies.class);
                intent.putExtra("viewall","pop");
                startActivity(intent);

            }
        });

        viewnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FrontPage.this,ViewAllMovies.class);
                intent.putExtra("viewall","now");
                startActivity(intent);

            }
        });


        popMovieRecAdapter=new PopMovieRecAdapter(this, pop, new PopMovieRecAdapter.onMovieClickListner() {
            @Override
            public void onClick(int pos) {
                Intent intent=new Intent(FrontPage.this,MovieInfo.class);
                intent.putExtra("id",pop.get(pos).getId());

                startActivity(intent);
            }
        });
        recyclerViewpop.setAdapter(popMovieRecAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewpop.setLayoutManager(linearLayoutManager);


//        pop.addAll(movieDAO.getMovies());
        popMovieRecAdapter.notifyDataSetChanged();

        topratedAdapter=new PopMovieRecAdapter(this, top, new PopMovieRecAdapter.onMovieClickListner() {
            @Override
            public void onClick(int pos) {
                Intent intent=new Intent(FrontPage.this,MovieInfo.class);
                intent.putExtra("id",top.get(pos).getId());

                startActivity(intent);
            }
        });
        recyclerViewtop.setAdapter(topratedAdapter);
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(this);
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewtop.setLayoutManager(linearLayoutManager1);


        upComingAdapter=new PopMovieRecAdapter(this, up, new PopMovieRecAdapter.onMovieClickListner() {
            @Override
            public void onClick(int pos) {
                Intent intent=new Intent(FrontPage.this,MovieInfo.class);
                intent.putExtra("id",up.get(pos).getId());

                startActivity(intent);
            }
        });
        recyclerViewup.setAdapter(upComingAdapter);
        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewup.setLayoutManager(linearLayoutManager2);


        nowAdapter=new PopMovieRecAdapter(this, now, new PopMovieRecAdapter.onMovieClickListner() {
            @Override
            public void onClick(int pos) {
                Intent intent=new Intent(FrontPage.this,MovieInfo.class);
                intent.putExtra("id",now.get(pos).getId());

                startActivity(intent);
            }
        });
        recyclerViewnow.setAdapter(nowAdapter);
        LinearLayoutManager linearLayoutManager3=new LinearLayoutManager(this);
        linearLayoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewnow.setLayoutManager(linearLayoutManager3);
















        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fetchPopularMovies();
        fetchTopRatedMovies();
        fetchUpCommingMovies();
        fetchNowPlaying();





    }

    public void fetchPopularMovies() {

        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit=builder.build();
        MovieDb movieDb=retrofit.create(MovieDb.class);
        Call<PopularMovieResult> popularMovieResultCall=movieDb.getpop(Key,1);
        popularMovieResultCall.enqueue(new Callback<PopularMovieResult>() {
            @Override
            public void onResponse(Call<PopularMovieResult> call, Response<PopularMovieResult> response) {
                PopularMovieResult popularMovieResult=response.body();

                pop.clear();
                pop.addAll(popularMovieResult.getResults()); //  popMovieRecAdapter=new PopMovieRecAdapter(this,pop );
                // jo yahan bheji hai wo hi send karte hai





                popMovieRecAdapter.notifyDataSetChanged();

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
                 top.clear();
                 top.addAll(topRatedMovieResult.getResults());

                 topratedAdapter.notifyDataSetChanged();
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
                up.clear();
                up.addAll(upcomingMoviesResult.getresults());
                upComingAdapter.notifyDataSetChanged();
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
                now.clear();
               now.addAll(nowPlayingResult.getResults());
               nowAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NowPlayingResult> call, Throwable t) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.movie) {

            Intent intent=new Intent(this,FrontPage.class);
            startActivity(intent);

        }

        else if (id == R.id.aboutus) {
            Intent intent=new Intent(FrontPage.this,AboutUs.class);
            startActivity(intent);


        }
        else if (id == R.id.feedback) {


            sendFeedback();



        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public void sendFeedback()
    {

        {

            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_SENDTO);
            Uri uri=Uri.parse("mailto:kartik.kumar228@gmail.com");
            intent.setData(uri);
            startActivity(intent);
        }
    }




}
