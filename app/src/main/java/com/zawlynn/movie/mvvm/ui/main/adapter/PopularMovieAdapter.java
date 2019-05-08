package com.zawlynn.movie.mvvm.ui.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zawlynn.movie.mvvm.R;
import com.zawlynn.movie.mvvm.model.Movie;
import com.zawlynn.movie.mvvm.ui.main.viewholder.PopuarViewHolder;

import java.util.ArrayList;

public class PopularMovieAdapter extends ListAdapter<Movie,PopuarViewHolder> {
    public PopularMovieAdapter() {
        super(new MovieItemCallback());
    }

    @NonNull
    @Override
    public PopuarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLayoutView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poster, parent, false);
        return new PopuarViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull final PopuarViewHolder holder, int i) {
        holder.bind(getItem(i));
    }

    private static final DiffUtil.ItemCallback<Movie> DIFF_CALLBACK = new DiffUtil.ItemCallback<Movie>() {
        public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.equals(newItem);
        }
    };
}
