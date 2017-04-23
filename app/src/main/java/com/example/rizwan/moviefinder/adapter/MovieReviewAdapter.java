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
import com.example.rizwan.moviefinder.model.MovieCast;
import com.example.rizwan.moviefinder.model.MovieReview;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rizwan on 26/3/17.
 */
public class MovieReviewAdapter extends RecyclerView.Adapter<MovieReviewAdapter.MyViewHolder> {

private List<MovieReview> movieReviewList;

public class MyViewHolder extends RecyclerView.ViewHolder  {
    public TextView author;
    public TextView content;

    public MyViewHolder(View view) {
        super(view);

        author = (TextView) view.findViewById(R.id.movie_review_author);
        content = (TextView) view.findViewById(R.id.movie_review_content);


    }
}


    public MovieReviewAdapter(List<MovieReview> movieReviewList) {
        this.movieReviewList = movieReviewList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_review_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final MovieReview movieReview = movieReviewList.get(position);

        holder.author.setText(movieReview.getAuthor());
        String review = movieReview.getContent().replace("*","");
        review = review.replace("\\r" , "");
        holder.content.setText(review);


    }

    @Override
    public int getItemCount() {
        return movieReviewList.size();
    }


}
