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
import com.example.rizwan.moviefinder.activity.MovieDetailActivity;
import com.example.rizwan.moviefinder.activity.MovieDetailsActivity;
import com.example.rizwan.moviefinder.model.Movie;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * Created by rizwan on 18/2/17.
 */


    public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

        private List<Movie> moviesList;

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            public ImageView poster;
            public TextView title;
            public TextView releaseDate;
            public TextView overview;
            public TextView rating;
            public TextView id;

            public MyViewHolder(View view) {
                super(view);

                poster = (ImageView) view.findViewById(R.id.poster);
                title = (TextView) view.findViewById(R.id.title);
                releaseDate = (TextView) view.findViewById(R.id.release_date);
                overview = (TextView) view.findViewById(R.id.overview);
                rating = (TextView) view.findViewById(R.id.text_rating);
                id = (TextView) view.findViewById(R.id.id);
                view.setOnClickListener(this);

            }

            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                Integer movieId = Integer.valueOf(id.getText().toString());
                Log.v("movieIDDD=====" , movieId.toString());
                Intent intent = new Intent(context, MovieDetailsActivity.class);
                intent.putExtra("movieId" , movieId);
               // intent.getIntExtra("")
                context.startActivity(intent);
            }
        }


        public MovieAdapter(List<Movie> moviesList) {
            this.moviesList = moviesList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.movie_list_row, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
           final Movie movie = moviesList.get(position);

            holder.poster.setImageResource(R.mipmap.ic_launcher);
            Context context = holder.poster.getContext();
            String posterPath = "https://image.tmdb.org/t/p/w500" + movie.getPosterPath();
            Log.v("pic path " , posterPath);
            Uri uri = Uri.parse(posterPath);
            Picasso.with(context).load(uri).resize(300,350).into(holder.poster);


            holder.title.setText(movie.getTitle());
            holder.releaseDate.setText("Released on: " + movie.getReleaseDate());
            holder.overview.setText("Desc: \n" + movie.getOverview());
            holder.rating.setText(movie.getVoteAverage().toString());
            holder.id.setText(movie.getId().toString());

        }

        @Override
        public int getItemCount() {
            return moviesList.size();
        }

}