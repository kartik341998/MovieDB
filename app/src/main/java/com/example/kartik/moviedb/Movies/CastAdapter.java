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

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.ViewHolder> {

    Context context;
    ArrayList<Cast> movieArrayList=new ArrayList<>();
    CastAdapter.onMovieClickListner onMovieClickListner;

    public interface onMovieClickListner{
        void onClick(int pos);
    }

    public CastAdapter(Context context, ArrayList<Cast> movieArrayList, CastAdapter.onMovieClickListner onMovieClickListner) {
        this.context = context;
        this.movieArrayList = movieArrayList;
        this.onMovieClickListner = onMovieClickListner;
    }

    public CastAdapter(Context context, ArrayList<Cast> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public CastAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.cast_row,viewGroup,false);
        CastAdapter.ViewHolder viewHolder=new CastAdapter.ViewHolder(v);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CastAdapter.ViewHolder viewHolder, int pos) {
        viewHolder.tv.setText(movieArrayList.get(pos).getName());
        viewHolder.tv2.setText(movieArrayList.get(pos).getCharacter());
        Log.d("bhavit","http://image.tmdb.org/t/p/original"+movieArrayList.get(pos).getProfile_path());
        Picasso.get().load("http://image.tmdb.org/t/p/original"+movieArrayList.get(pos).getProfile_path()).fit().into(viewHolder.img);
        viewHolder.img.setOnClickListener(new View.OnClickListener()
        {
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
        TextView tv,tv2;





        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.profile_image);
            tv=itemView.findViewById(R.id.textView2);
            tv2=itemView.findViewById(R.id.textView4);



        }
    }
}