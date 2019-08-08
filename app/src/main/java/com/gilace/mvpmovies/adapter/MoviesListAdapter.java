package com.gilace.mvpmovies.adapter;

import android.content.Context;
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

    public List<Datum> datumList;
    Context context;
    View view;

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {


        ImageView thumbnail;
        TextView title;
        TextView rating;
        TextView genre;
        TextView releaseYear;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            title = itemView.findViewById(R.id.title);
            rating = itemView.findViewById(R.id.rating);
            rating = itemView.findViewById(R.id.rating);
            rating = itemView.findViewById(R.id.rating);
        }
    }

    public MoviesListAdapter(Context context) {
        this.context = context;
        datumList=new ArrayList<>();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(itemView);
        view = itemView;
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Datum datum = datumList.get(position);
        Glide
                .with(context)
                .load(datum.getPoster())
                .into(holder.thumbnail);


    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    public void add(List<Datum> items) {

        int previousDataSize = this.datumList.size();

        if (previousDataSize == 0) {
            datumList.addAll(items);
            notifyItemInserted(1);
        } else {
            datumList.addAll(items);
            notifyItemRangeInserted(previousDataSize, items.size());
        }


    }


}

