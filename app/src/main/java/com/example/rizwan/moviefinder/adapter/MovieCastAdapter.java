package com.example.rizwan.moviefinder.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rizwan.moviefinder.R;
import com.example.rizwan.moviefinder.activity.MovieDetailsActivity;
import com.example.rizwan.moviefinder.model.Movie;
import com.example.rizwan.moviefinder.model.MovieCast;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rizwan on 26/3/17.
 */
public class MovieCastAdapter extends RecyclerView.Adapter<MovieCastAdapter.MyViewHolder> {

    private List<MovieCast> movieCastList;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView poster;
        public TextView character;
        public TextView name;
        public TextView id;

        public MyViewHolder(View view) {
            super(view);

            poster = (ImageView) view.findViewById(R.id.poster_movie_cast);
            character = (TextView) view.findViewById(R.id.movie_cast_character);
            name = (TextView) view.findViewById(R.id.movie_cast_name);
            id = (TextView) view.findViewById(R.id.movie_cast_id);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();

            Integer movieId = Integer.valueOf(id.getText().toString());
            Log.v("movieIDDD=====", movieId.toString());
            Intent intent = new Intent(context, MovieDetailsActivity.class);
            intent.putExtra("movieId", movieId);
            // intent.getIntExtra("")
            context.startActivity(intent);
        }
    }


    public MovieCastAdapter(List<MovieCast> movieCastList) {
        this.movieCastList = movieCastList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_cast_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final MovieCast movieCast = movieCastList.get(position);

        holder.poster.setImageResource(R.mipmap.ic_launcher);
        Context context = holder.poster.getContext();
        String posterPath = "https://image.tmdb.org/t/p/w500" + movieCast.getProfile_path();
        Log.v("pic path ", posterPath);
        Uri uri = Uri.parse(posterPath);
        Picasso.with(context).load(uri).resize(300, 350).into(holder.poster);


        holder.character.setText(movieCast.getCharacter());
        holder.name.setText( movieCast.getName());
        holder.id.setText(movieCast.getId());

    }

    @Override
    public int getItemCount() {
        return movieCastList.size();
    }


}
