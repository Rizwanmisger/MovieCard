package com.example.rizwan.moviefinder.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rizwan.moviefinder.R;
import com.example.rizwan.moviefinder.activity.MovieDetailsActivity;
import com.example.rizwan.moviefinder.activity.TvShowDetailsActivity;
import com.example.rizwan.moviefinder.model.Movie;
import com.example.rizwan.moviefinder.model.TvShow;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rizwan on 19/3/17.
 */
public class TvAdapter  extends RecyclerView.Adapter<TvAdapter.MyViewHolder> {

    private List<TvShow> TVList;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView poster;
        public TextView title;
        public TextView releaseDate;
        public TextView overview;
        public TextView rating;
        public TextView id;
        public View v;

        public MyViewHolder(View view) {
            super(view);
            v = view;
            poster = (ImageView) view.findViewById(R.id.poster_tv);
            title = (TextView) view.findViewById(R.id.title_tv);
            releaseDate = (TextView) view.findViewById(R.id.release_date_tv);
            overview = (TextView) view.findViewById(R.id.overview_tv);
            rating = (TextView) view.findViewById(R.id.text_rating_tv);
            id = (TextView) view.findViewById(R.id.id_tv);
            view.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            Context context = v.getContext();

            Integer tvShowId = Integer.valueOf(id.getText().toString());
            Log.v("movieIDDD=====", tvShowId.toString());
            Intent intent = new Intent(context, TvShowDetailsActivity.class);
            intent.putExtra("tvShowId" , tvShowId);
            // intent.getIntExtra("")
            context.startActivity(intent);
        }

        public void setBackgroundColor(int color)
        {
            v.setBackgroundColor(color);
        }
    }


    public TvAdapter(List<TvShow> TVList) {
        this.TVList = TVList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tv_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final TvShow tvShow = TVList.get(position);

        holder.poster.setImageResource(R.mipmap.ic_launcher);
        Context context = holder.poster.getContext();
        String posterPath = "https://image.tmdb.org/t/p/w500" + tvShow.getPosterPath();
        Log.v("pic path ", posterPath);
        Uri uri = Uri.parse(posterPath);
        Picasso.with(context).load(uri).resize(300,350).into(holder.poster);

        holder.poster.buildDrawingCache();
     /*   Bitmap image =  holder.poster.getDrawingCache();
        Palette.from(image).generate(new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
                if (vibrantSwatch != null) {
                    holder.setBackgroundColor(vibrantSwatch.getBodyTextColor());
                }
            }
        });*/


        holder.title.setText(tvShow.getName());
        holder.releaseDate.setText("Released on: " + tvShow.getReleaseDate());
        holder.overview.setText("Overview: \n" + tvShow.getOverview());
      //  holder.overview.setText("");
        holder.rating.setText(tvShow.getVoteAverage().toString());
        holder.id.setText(tvShow.getId().toString());

    }

    @Override
    public int getItemCount() {
        return TVList.size();
    }

}

