package com.example.kartik.moviedb.Movies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kartik.moviedb.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ViewAllAdapter extends RecyclerView.Adapter<ViewAllAdapter.ViewHolder> {
    Context context;
    ArrayList<Movie> movieArrayList=new ArrayList<>();
    ViewAllAdapter.onMovieClickListner onMovieClickListner;

    public interface onMovieClickListner{
        void onClick(int pos);
    }

    public ViewAllAdapter(Context context, ArrayList<Movie> movieArrayList, ViewAllAdapter.onMovieClickListner onMovieClickListner) {
        this.context = context;
        this.movieArrayList = movieArrayList;
        this.onMovieClickListner = onMovieClickListner;
    }

    public ViewAllAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public ViewAllAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.viewall,viewGroup,false);
        ViewAllAdapter.ViewHolder viewHolder=new ViewAllAdapter.ViewHolder(v);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewAllAdapter.ViewHolder viewHolder, int pos) {
        viewHolder.tv.setText(movieArrayList.get(pos).getTitle());
        Log.d("bhavit","http://image.tmdb.org/t/p/original"+movieArrayList.get(pos).getPoster_path());
        Picasso.get().load("http://image.tmdb.org/t/p/original"+movieArrayList.get(pos).getPoster_path()).fit().into(viewHolder.img);
        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMovieClickListner.onClick(viewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView img;
        TextView tv;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.poster);
            tv=itemView.findViewById(R.id.tvmovie);


        }
    }
}
