package com.gilace.mvpmovies.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gilace.mvpmovies.R;
import com.gilace.mvpmovies.retrofite.model.Datum;

import java.util.ArrayList;
import java.util.List;


public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.RecyclerViewHolder> {

    private List<Datum> datumList;
    private Context context;
//    private View view;

    class RecyclerViewHolder extends RecyclerView.ViewHolder {


        ImageView thumbnail;
        TextView title;
        TextView rating;
        TextView genre;
        TextView releaseYear;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            title = itemView.findViewById(R.id.title);
            rating = itemView.findViewById(R.id.rating);
            genre = itemView.findViewById(R.id.genre);
            releaseYear = itemView.findViewById(R.id.releaseYear);
        }
    }

    public void cleanAdapter() {
        datumList.clear();
    }

    public MoviesListAdapter(Context context) {
        this.context = context;
        datumList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
//        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(itemView);
//        view = itemView;
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Datum datum = datumList.get(position);
        Glide
                .with(context)
                .load(datum.getPoster())
                .into(holder.thumbnail);

        holder.title.setText(datum.getTitle());
        holder.genre.setText(datum.getGenres().toString());
        holder.rating.setText(datum.getImdbRating());
        holder.releaseYear.setText(datum.getYear());

    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    public void add(List<Datum> items) {

        int previousDataSize = this.datumList.size();

        if (previousDataSize == 0) {
            datumList.addAll(items);
//            notifyItemInserted(0);
            notifyDataSetChanged();
        } else {
//            this.datumList.clear();
            datumList.addAll(items);
            notifyItemRangeInserted(previousDataSize, items.size());
        }


    }


}

